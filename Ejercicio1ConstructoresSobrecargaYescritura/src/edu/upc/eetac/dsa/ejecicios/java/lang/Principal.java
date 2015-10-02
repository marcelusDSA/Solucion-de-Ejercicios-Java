package edu.upc.eetac.dsa.ejecicios.java.lang;


import sun.reflect.generics.tree.Tree;

/**
 * Created by marcelus on 27/09/15.
 */
public class Principal {

    public static void main (String args[]) throws Exception{
        Arbol[] arboles = new Arbol[4];
        arboles [0] = new Arbol(4);
        arboles [1] = new Arbol("Roble");
        arboles [2] = new Arbol();
        arboles [3] = new Arbol(5, "pino");

        for(int i = 0; i < arboles.length ; i++){

            if(arboles[i].getAltura() != 0 & arboles[i].getNombre()==null)
                System.out.println("Un arbol de " +arboles[i].getAltura()+" metros");
            if (arboles[i].getNombre() != null & arboles[i].getAltura()==0)
                System.out.println("Un "+arboles[i].getNombre());
            if (arboles[i].getAltura() != 0 & arboles[i].getNombre() != null)
                System.out.println("Un "+arboles[i].getNombre()+" de "+arboles[i].getAltura()+" metros");
            if (arboles[i].getAltura()== 0 & arboles[i].getNombre()== null)
                System.out.println("Un arbol");
        }

    }
}
