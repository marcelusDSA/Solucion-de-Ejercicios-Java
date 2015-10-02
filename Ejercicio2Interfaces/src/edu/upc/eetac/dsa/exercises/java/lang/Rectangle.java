package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 27/09/15.
 */
public class Rectangle extends Abstracto {

    private double ii;
    private double jj;

    public Rectangle (double i, double j){
        super("Rectangulo");
        this.ii= i;
        this.jj=j;
    }
    public double area(){
        return ii*jj;
    }
}
