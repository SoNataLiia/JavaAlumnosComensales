package alumnos;

//representa un tenedor compartido entre dos alumnos.
//usamos synchronized para evitar que dos alumnos lo cojan a la vez.
public class Tenedor {

    private final int id;
    private boolean enUso = false;

    public Tenedor(int id) {
        this.id = id;
    }

    //el alumno intenta coger el tenedor, si esta ocupado, espera.
    public synchronized void coger(int idAlumno) throws InterruptedException {
        while (enUso) {
            System.out.println("Alumno " + idAlumno + " espera el tenedor " + id);
            wait();
        }
        enUso = true;
        System.out.println("Alumno " + idAlumno + " coge el tenedor " + id);
    }

    // el alumno suelta el tenedor y notifica a quien espere.
    public synchronized void soltar(int idAlumno) {
        enUso = false;
        System.out.println("Alumno " + idAlumno + " suelta el tenedor " + id);
        notifyAll();
    }
}
