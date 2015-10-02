import org.omg.CORBA.*;
import org.omg.CORBA.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.*;
import java.io.*;

/**
 * Created by marcelus on 30/09/15.
 */
public class UDPcliente {

    public static void main (String args[]) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] mensaje = args[0].getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");

        //ahora se construye un datagrama para enviar el mensaje al servidor
        DatagramPacket datagramPacket = new DatagramPacket(mensaje, args[0].length(),inetAddress,12345);
        //ahora enviamos el datagrama
        datagramSocket.send(datagramPacket);

        // ahora se construye el datagrama que contendra la repuesta
        byte[] bufer = new  byte[0];
         datagramPacket = new DatagramPacket(bufer, bufer.length);
        datagramSocket.send(datagramPacket);

        byte [] datos = new byte[1496];
         datagramPacket = new DatagramPacket(datos, datos.length);
        datagramSocket.receive(datagramPacket);

        java.io.DataInputStream dataInputStream = new java.io.DataInputStream(new ByteArrayInputStream(datagramPacket.getData()));
        String time = dataInputStream.readUTF();
        System.out.println(time);
        //printamos la respuesta del servidor al cliente
        //System.out.println(" Respuesta" + respuestaServidor);

    }
}
