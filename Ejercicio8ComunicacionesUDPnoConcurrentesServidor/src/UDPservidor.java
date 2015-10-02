/**
 * Created by marcelus on 30/09/15.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;

public class UDPservidor {
    public static void main (String args[]) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        DatagramSocket datagramSocket = new DatagramSocket();
        byte [] bufer = new byte[1000];
        while (true){
            //ahora construimos el datagrama para recibir peticiones
            DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

            // ahora leemos la peticion del DatagramSocket
            datagramSocket.receive(peticion);
            System.out.println("Datagrama recibido del host: " + peticion.getAddress() + " desde el puesto " + peticion.getPort());


            // Solucion de la asignatura
            ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayInputStream);
            dataOutputStream.writeUTF(simpleDateFormat.format(System.currentTimeMillis()));
            byte[]datos = byteArrayInputStream.toByteArray();
            peticion = new DatagramPacket(datos,datos.length, peticion.getAddress(),peticion.getPort());
            datagramSocket.send(peticion);


        }
    }
}
