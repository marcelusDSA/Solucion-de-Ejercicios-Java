package edu.upc.eetac.dsa.exercises.java.lang;

import java.io.*;

/**
 * Created by marcelus on 29/09/15.
 */
public class LeerFicheroTipoBinario {

    public void leerFicheroBinario (String fichero) throws IOException {

        int entero;
        double decimal;
        char binario;
        FileInputStream Fin= null; // clase para leer el fichero
        DataInputStream Din = null; // Objeto para leer los datos de la clase que lee el fichero

        try {

        Fin = new FileInputStream(fichero);
        Din = new DataInputStream(Fin);

        while (true){
            entero=Din.readInt();
            System.out.println( entero);
            decimal=Din.readDouble();
            System.out.println(decimal);
            binario=Din.readChar();
            System.out.println(binario);
             }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (EOFException e){
            System.out.println("Fin de fichero");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (Fin !=null)
                    Fin.close();
                if (Din != null)
                    Din.close();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }

        }
    }
}
