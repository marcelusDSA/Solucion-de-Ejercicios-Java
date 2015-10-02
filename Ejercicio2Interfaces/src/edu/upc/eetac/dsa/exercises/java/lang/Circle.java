package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 27/09/15.
 */
public class Circle extends Abstracto {


   private double radio;

   public Circle(double r){
      super("circulo");
       this.radio = r;
    }
    public double area(){

        return Math.PI*radio*radio;

    }


}
