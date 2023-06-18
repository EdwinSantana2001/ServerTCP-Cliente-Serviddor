import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * para que no se decuadren los mensajes cliente servidor se recomienda siempre hacer cliente servidor respectivamente
 *
 * Punto en cuenta seria la conección de el server al cliente y viseversa se hace a partir del socket.
 * Ambos tanto el cliente como el servidor
 * **/

public class Cliente {
    public static void main(String[] args) {

        DataInputStream in;//Comunicación
        DataOutputStream out;//Comunicación
        final String HOST="127.0.0.1";//Localhost a mi propia pc 127.0.0.1= LocalHost
        final int PUERTO= 25565;//Es el puerto que ya he definido en mi Clase Servidor Si hago una modificacion aqui tambien en el servidor "Obvio"

        try {
            Socket sc = new Socket(HOST,PUERTO);

            in = new DataInputStream(sc.getInputStream());//Cliente ->Servidor //Comunicación a partir del socked
            out = new DataOutputStream(sc.getOutputStream());//Servidor ->Cliente

            System.out.println("¡Hola mundo desde el cliente!");

            String ms = in.readUTF();//Recibe mensaje desde el servidor
            System.out.println(ms);//imprime el mensaje de el servidor en la consola
            sc.close();

        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
