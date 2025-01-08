package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJuego {
    public static final int PUERTO = 4951;
    public static final String IP_SERVER = "localhost";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Piedra Papel Tijera");
        System.out.println("-----------------");

        InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

        try (Scanner sc = new Scanner(System.in)) {

            try (Socket socketAlServidor = new Socket()) {
                socketAlServidor.connect(direccionServidor);
                System.out.println("Conexión establecida a " + IP_SERVER + " con éxito");

                PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
                BufferedReader bf = new BufferedReader(new InputStreamReader(socketAlServidor.getInputStream()));

                String recibido;
                
                System.out.println(bf.readLine());

   
                while (true) {
     
                    recibido = bf.readLine();
                    System.out.println(recibido); 


                    if (recibido.startsWith("_¡")) {
                        System.out.println("Juego terminado.");
                        break; 
                    }
                    if (recibido.contains("elige")) {
                        menu();
                        String opcion = sc.nextLine().toUpperCase(); 

     
                        if (!opcion.equals("P") && !opcion.equals("S") && !opcion.equals("R")) {
                            System.out.println("Opción no válida. Por favor, elige nuevamente.");
                            continue;
                        }

                   
                        salida.println(opcion);
                    }

            
                    recibido = bf.readLine();
                    System.out.println(recibido); 
     



 
                    recibido = bf.readLine(); 
                    if (recibido != null) {
                        System.out.println(recibido);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error de conexión con el servidor: " + e.getMessage());
            }

        }
    }

    // Menú de opciones para el jugador
    public static void menu() {
        System.out.println("Opciones:");
        System.out.println("P. Papel");
        System.out.println("S. Tijeras");
        System.out.println("R. Piedra");
        System.out.print("Elige una opción: ");
    }
}