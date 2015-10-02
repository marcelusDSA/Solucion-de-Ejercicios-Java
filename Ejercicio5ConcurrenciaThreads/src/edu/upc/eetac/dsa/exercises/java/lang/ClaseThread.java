package edu.upc.eetac.dsa.exercises.java.lang;

/**
 * Created by marcelus on 29/09/15.
 */
public class ClaseThread extends Thread {
    private String mensaje;
    long ultimaEjecucion;
    int contador;

    public ClaseThread (String name){
        super(name);
    }
    public void run (){

        for (int i=0; i<10; i++){
            long ejecucionAcuantal= System.currentTimeMillis();
            long transcurido= (ultimaEjecucion==0) ? 0 : ejecucionAcuantal-ultimaEjecucion;
            ultimaEjecucion= ejecucionAcuantal;
            System.out.println(getName()+" transcurrido en "+transcurido+" ms y el numero de mensaje es " +contador++);
            long sleep= (long)(Math.random()*2000);
            try{
                Thread.sleep(sleep);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println(mensaje);
        }
        System.out.println("Este proceso ha terminado "+this.getName());
    }
    public void SetMensaje(String mensaje){// este metodo lo utilizamos para escibir a cada objeto de thread y diferenciar cada proceso
        this.mensaje=mensaje;
    }
}
