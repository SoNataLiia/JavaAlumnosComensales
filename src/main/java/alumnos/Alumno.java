package alumnos;

// cada alumno es un hilo independiente que piensa, coge tenedores y come.
// para evitar deadlock, los alumnos pares cogen primero el izquierdo
// y los impares primero el derecho, asi rompemos la simetria.
public class Alumno extends Thread {

    private final int id;
    private final Tenedor tenedorIzquierdo;
    private final Tenedor tenedorDerecho;

    public Alumno(int id, Tenedor izquierdo, Tenedor derecho) {
        this.id = id;
        this.tenedorIzquierdo = izquierdo;
        this.tenedorDerecho = derecho;
    }

    @Override
    public void run() {
        try {
            for (int ronda = 1; ronda <= 5; ronda++) {
                esperar();
                comer();
            }
            System.out.println("Alumno " + id + " ha terminado de comer.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // el alumno espera un tiempo aleatorio antes de intentar comer.
    private void esperar() throws InterruptedException {
        System.out.println("Alumno " + id + " esta esperando para comer...");
        Thread.sleep((long) (Math.random() * 1000 + 300));
    }

    private void comer() throws InterruptedException {
        // para evitar que todos cojan el tenedor izquierdo al mismo tiempo
        //  alternamos el orden segun el id.
        if (id % 2 == 0) {
            tenedorIzquierdo.coger(id);
            tenedorDerecho.coger(id);
        } else {
            tenedorDerecho.coger(id);
            tenedorIzquierdo.coger(id);
        }


        System.out.println(">>> Alumno " + id + " COMIENDO arroz <<<");
        Thread.sleep((long) (Math.random() * 1000 + 500));

        tenedorIzquierdo.soltar(id);
        tenedorDerecho.soltar(id);
    }
}