package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class ClaseBuffer {
    private final static int BUFFER_SIZE = 32;
    private char[] buffer;
    private int cabeza;
    private int cola;

    public ClaseBuffer (){
        buffer= new char[BUFFER_SIZE];
        this.cabeza=0;
        this.cola=0;
    }
    private boolean EstaVacio(){
        return cabeza==cola;
    }
    private boolean EstaLleno(){
        if( cola +1== cabeza) {
            return true;
        }
        if(cola == (buffer.length -1) && cabeza ==0){
           return true;
        }
        return false;
    }
    public synchronized char get(){

        while (EstaVacio())
            try {
                wait();
            }
            catch (InterruptedException e){

            }
        char c= buffer[cabeza++];
        if (cabeza==buffer.length){
            cabeza=0;
        }
        notifyAll();
        return c;
    }
    public synchronized void put(char c){
        while (EstaLleno())
            try {
                wait();
            }
            catch (InterruptedException e){
                    e.printStackTrace();
            }
        buffer[cola]=c;
        if(cola==buffer.length) {
            cola = 0;
        }
        notifyAll();
    }



}
