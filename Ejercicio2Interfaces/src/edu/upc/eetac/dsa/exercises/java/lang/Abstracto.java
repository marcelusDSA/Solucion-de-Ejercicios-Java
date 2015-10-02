package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 28/09/15.
 */
public class Abstracto implements Shape {

    private String tipo;

    public Abstracto (String tipo){

        this.tipo= tipo;
    }
    public String toString (){
        return "i am "+tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double area (){
        double aDouble= Double.parseDouble(tipo);
        return (aDouble);
    }
}
