import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * Created by marcelus on 29/09/15.
 */
public class ClaseTCPservidor {
    public static void main (String args[]) throws IOException{
        String msnServer = "Te envio la informacion necesaria para que te ubiques ";
        ServerSocket serverSocket = new ServerSocket(12345); // aqui se crea el serverSocket
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Socket TCP iniciado");
        while (true){
            Socket socket = serverSocket.accept(); // socket aceptado
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // Esta clase es para leer datos utilizando los mismo metodos de esta clase
            System.out.println(" IP : " + socket.getInetAddress());
            System.out.println(" Puerto : " + socket.getLocalPort());
            System.out.println("Mensaje :" + dataInputStream.readUTF());

           /* DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());// Aquie le estamos enviando un mensaje de tipo String al cleinte
            dataOutputStream.writeUTF(simpleDateFormat.format(System.currentTimeMillis()));
            dataOutputStream.writeUTF(msnServer);
            dataOutputStream.flush();*/





            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(msnServer);
           // printWriter.println(simpleDateFormat.format(System.currentTimeMillis()));
            printWriter.flush();

        }

    }
}
