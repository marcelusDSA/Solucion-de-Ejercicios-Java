package edu.upc.eetac.dsa.exercises.java.lang;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by marcelus on 28/09/15.
 */
public class Principal {
    public static void main(String args[]) throws IOException, FileNotFoundException{
        EscribirFicheroTipoBinario escribirFicheroTipoBinario = new EscribirFicheroTipoBinario();
        LeerFicheroTipoBinario leerFicheroTipoBinario= new LeerFicheroTipoBinario();

        escribirFicheroTipoBinario.EscribirEnFicheroBinario("/home/marcelus/IdeaProjects/Ejercicio4FicheroTipoBinario/src/edu/upc/eetac/dsa/exercises/java/lang/datos.dat");
        leerFicheroTipoBinario.leerFicheroBinario("/home/marcelus/IdeaProjects/Ejercicio4FicheroTipoBinario/src/edu/upc/eetac/dsa/exercises/java/lang/datos.dat");
    }
}
