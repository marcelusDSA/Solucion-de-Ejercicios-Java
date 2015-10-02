package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 27/09/15.
 */
public class Principal {
    public static void main (String args[]){

        Shape[] shapes = new Shape[2];
        shapes[0]= new Circle(2.5);
        shapes[1]= new Rectangle(3,5);
        for (Shape shape: shapes)
            System.out.println(shape+" con area "+shape.area());
    }
}
