package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class ClaseRunnable implements Runnable {
    int contador;
    long ultimaEjecicion;

    public void run() {
        for (int i = 0; i < 10; i++) {
            long ejecucionActual = System.currentTimeMillis();
            long transcurrido = (ultimaEjecicion == 0) ? 0 : ejecucionActual - ultimaEjecicion;
            ultimaEjecicion = ejecucionActual;
            System.out.println(Thread.currentThread().getName() + " transcurrido  en " + transcurrido + " ms y este el numero de mensaje" + contador++);
            long sleep = (long) (Math.random() * 200);

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
