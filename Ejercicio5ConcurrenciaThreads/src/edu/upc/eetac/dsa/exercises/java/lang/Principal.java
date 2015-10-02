package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class Principal {
    public static void main (String args[]) throws InterruptedException {

        ClaseThreadSol claseThreadSol = new ClaseThreadSol("Thread de la claseThreadSol");
        Thread thread = new Thread(new ClaseRunnable(), "Thread de la clase Runnable");
        claseThreadSol.start();
        thread.start();
        claseThreadSol.join();
        thread.join();
        System.out.println("Se acabo");

        ClaseThread claseThread = new ClaseThread("thread 1");
         ClaseThread claseThread1 = new ClaseThread("thread 2");
        //claseThread.SetMensaje("este es el mensaje del thread 1");
        //  claseThread1.SetMensaje("este es el mensaje del thread 2");
        claseThread1.start();
        claseThread.start();

        claseThread1.join();
        claseThread.join();
    }
}
