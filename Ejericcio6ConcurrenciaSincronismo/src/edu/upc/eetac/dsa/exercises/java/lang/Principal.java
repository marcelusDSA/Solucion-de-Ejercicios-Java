package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class Principal  {
    public static void main (String args[]){
        String linea=  "adarga antigua, rocín flaco y galgo corredor.\n";
        ClaseBuffer claseBuffer = new ClaseBuffer();
        Thread threadConsumidores = new Thread(new Consumidores(claseBuffer)," consumidor");
        Thread threadProductores = new Thread(new Productores(claseBuffer, linea), "productores");
        threadConsumidores.start();
        threadProductores.start();
    }
}
