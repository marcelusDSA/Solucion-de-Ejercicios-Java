package edu.upc.eetac.dsa.exercises.java.lang;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by marcelus on 28/09/15.
 */
public class LeerFichero {

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {


        int suma = 0;
        int contador = 0;
        String cadena;
        FileReader f = new FileReader(archivo); // en esta clase leemos el archivo
        BufferedReader b = new BufferedReader(f); // con esta clase leemos un flujo de datos
        while ((cadena = b.readLine()) != null) {
            contador = contador + 1;
           // if (Integer.parseInt(cadena) < 1000) {
                suma = suma + Integer.parseInt(cadena);
                System.out.println(cadena);
            }
            /*else {
                System.out.println("Numero mas grande que 100");
                //b.close();*/
            System.out.println("numero de linias con numeros en el fichero " + contador);
            System.out.println("la suma aridmetica es " + suma / contador);
            b.close();
        }

    }
