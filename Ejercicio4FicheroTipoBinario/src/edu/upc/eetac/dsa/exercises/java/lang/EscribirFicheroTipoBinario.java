package edu.upc.eetac.dsa.exercises.java.lang;

import javax.imageio.stream.FileImageOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by marcelus on 28/09/15.
 */
public class EscribirFicheroTipoBinario {
    private int entero;
    private double decimal;
    private char binario;

    public void EscribirEnFicheroBinario(String ficehro) throws IOException , FileNotFoundException {



            Scanner sc = new Scanner(System.in);
            FileOutputStream Fout = new FileOutputStream(ficehro);
            DataOutputStream Dout = new DataOutputStream(Fout);
        try {
            while (entero != -1){
            System.out.println("Introduzca un numero entero");
            entero = sc.nextInt();
            Dout.write(entero);
            System.out.println("Introduzca un numero decimal");
            decimal = sc.nextDouble();
            Dout.writeDouble(decimal);
            System.out.println("Introduzca un numero binario");
            binario = sc.next().charAt(binario);
            System.out.println("Introduzca -1 para salir");
            entero=sc.nextInt();
            }

        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (Fout != null)
                    Fout.close();

                if (Dout != null)
                    Dout.close();
            }

            catch (IOException e){
                System.out.println(e.getMessage());
            }


        }


    }
}
