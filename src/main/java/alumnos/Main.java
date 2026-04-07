package alumnos;

public class Main {

    public static void main(String[] args) {
        final int N = 5;

        // creamos los 5 tenedores
        Tenedor[] tenedores = new Tenedor[N];
        for (int i = 0; i < N; i++) {
            tenedores[i] = new Tenedor(i);
        }

        // cada alumno tiene el tenedor i a la izquierda
        // y el tenedor (i+1) mod 5 a la derecha
        Alumno[] alumnos = new Alumno[N];
        for (int i = 0; i < N; i++) {
            alumnos[i] = new Alumno(i, tenedores[i], tenedores[(i + 1) % N]);
        }

        System.out.println("=== Cinco alumnos se sientan a comer ===\n");

        // arrancamos todos los hilos a la vez
        for (Alumno a : alumnos) {
            a.start();
        }

        // esperamos a que todos terminen antes de salir del programa
        for (Alumno a : alumnos) {
            try {
                a.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n=== Todos los alumnos han terminado. Fin. ===");
    }
}