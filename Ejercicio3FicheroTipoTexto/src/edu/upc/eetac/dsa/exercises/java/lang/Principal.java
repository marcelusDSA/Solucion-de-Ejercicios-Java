package edu.upc.eetac.dsa.exercises.java.lang;

import java.io.IOException;

/**
 * Created by marcelus on 28/09/15.
 */
public class Principal {
    public static void main (String args[]) throws IOException {
        LeerFichero leerFichero= new LeerFichero();
        leerFichero.muestraContenido("/home/marcelus/IdeaProjects/Ejercicio3FicheroTipoTexto/src/edu/upc/eetac/dsa/exercises/java/lang/numeros.txt");

    }
}
