package edu.upc.eetac.dsa.ejecicios.java.lang;

/**
 * Created by marcelus on 27/09/15.
 */
public class Arbol {

    private int altura;
    private  String nombre;

    public Arbol (){
       // System.out.println("Un arbol");
    }
    public Arbol (int altura){
        this.altura= altura;
       // System.out.println("Un arbol de "+ altura+" metros");
    }
    public Arbol (String nombre){
        this.nombre = nombre;
       // System.out.println("un "+ nombre);

    }
    public Arbol (int altura, String nombre){
        this.altura = altura;
        this.nombre = nombre;
       // System.out.println("un "+nombre+" de "+ altura+" metros");
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* private int altura;
    private String nombre;

    public Arbol (){
        this (0, null);
    }
    public Arbol (int altura) {
        this.altura= altura;
        nombre=null;

    }
    public Arbol (String nombre){
        this.nombre=nombre;
        altura = 0;
    }
    public Arbol(int altura ,String nombre){
        this.altura= altura;
        this.nombre= nombre;
    }

    public void Printar (){

        if (nombre == null){
            System.out.println("un arbol de " + altura);
        }
        else{
            System.out.println(" un "+nombre);
        }
        if (nombre == null & altura<0){

            System.out.println(" un arbol");
        }
        else{
            System.out.println("un "+nombre +"de "+altura);
        }
    }*/
}
