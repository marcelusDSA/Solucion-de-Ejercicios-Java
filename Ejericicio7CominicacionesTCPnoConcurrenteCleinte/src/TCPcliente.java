import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by marcelus on 29/09/15.
 */
public class TCPcliente {
    public static void main (String args[]) throws IOException{
        String msn = JOptionPane.showInputDialog("Ingrese un mensaje");

        Socket socket = new Socket("127.0.0.1",12345); // crea la conexion con el socket del servidor
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(msn);

       /* DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String  n= dataInputStream.readUTF();
        System.out.println(n);*/


        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String time = bufferedReader.readLine();
        System.out.println(time);
    }
}
