package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.negocio.Gestor;

public class ServidorVista {

    public static final int PUERTO = 4951;
    private Gestor gestor;

    public ServidorVista(Gestor gestor) {
        this.gestor = gestor;
    }

    public void iniciarServidor() {
        System.out.println("CALCULADORA ");
        System.out.println("-------------------------------");
        InetSocketAddress direccion = new InetSocketAddress(PUERTO);

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(direccion);
            int numeroPeticion = 0;

            while (true) {
                System.out.println("Esperando peticion...");
                try (Socket socketAlCliente = serverSocket.accept()) {
                    System.out.println("Peticion número: " + ++numeroPeticion);
                    procesarSolicitud(socketAlCliente);
                } catch (IOException e) {
                    System.out.println("Error al procesar la solicitud del cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    private void procesarSolicitud(Socket socketAlCliente) {
        try (
        	InputStreamReader entrada = new InputStreamReader(socketAlCliente.getInputStream());
            BufferedReader bf = new BufferedReader(entrada);
            PrintStream salida = new PrintStream(socketAlCliente.getOutputStream())
        ) {
            String opcionStr = bf.readLine();
            int opcion = Integer.parseInt(opcionStr);


            String recibido = bf.readLine();
            String[] operadores = recibido.split("_");
            double numero1 = Double.parseDouble(operadores[0]);
            double numero2 = Double.parseDouble(operadores[1]);

            System.out.println("Contenido recibido: " + recibido);

            String resultado = gestor.procesarOperacion(opcion, numero1, numero2);
            
            System.out.println("Resultado enviado: " + resultado);
            salida.println(resultado);

        } catch (IOException e) {
            System.out.println("Error en la comunicación con el cliente: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en los datos recibidos del cliente: " + e.getMessage());
        }
    }

}