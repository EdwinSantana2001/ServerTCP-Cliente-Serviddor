import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {


        ServerSocket servidor = null;//Socket del Servidor
        Socket sc = null;//Socket del Cliente
        DataInputStream in;//Comunicación
        DataOutputStream out;//Comunicación

        final int PUERTO =25565;//Puerto del servidor


        try {
            servidor = new ServerSocket(PUERTO);//le doy el puerto de la linea 19
            System.out.println("¡¡Servidor Iniciado!!");
            while (true){
                sc = servidor.accept();//Lo que hace es que se queda a la espera de peticiones
                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());//Cliente ->Servidor //Comunicación a partir del socked
                out = new DataOutputStream(sc.getOutputStream());//Servidor ->Cliente

                String ms= in.readUTF();//Queda a la espera de que el cliente mande "algo" peticion?
                System.out.println(ms);//leo el mensaje mediante consola

                out.writeUTF("Hola mundo desde el Servidor");

                sc.close();
                System.out.println("Cliente desconectado");
            }

        } catch (IOException e) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,e);
        }

    }
}