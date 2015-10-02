package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class Consumidores implements Runnable {
    private ClaseBuffer buffer =null;

    public Consumidores (ClaseBuffer buffer){
        this.buffer=buffer;
    }
    @Override
    public void run(){
        StringBuilder sd = new StringBuilder();
        char c;
        while ((c=buffer.get())!= '\n'){
            sd.append(c);
        }
        System.out.println(sd);
    }
}
