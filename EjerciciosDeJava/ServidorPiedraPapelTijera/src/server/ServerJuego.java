package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJuego {
	 public static final int PUERTO = 4951;

	    public static void main(String[] args) {

	        InetSocketAddress direccion = new InetSocketAddress(PUERTO);

	        try (ServerSocket serverSocket = new ServerSocket()) {
	            serverSocket.bind(direccion);
	            System.out.println("Esperando Peticiones");
	            Socket[] arraySocket = new Socket[2];
	            while(true) {
	            for(int i = 0;i<2;i++) {
	        
	                Socket socketAlCliente = serverSocket.accept();
	                System.out.println("Jugador conectado, esperando al segundo...");
	                arraySocket[i] = socketAlCliente;
	               
	            }
	            
	            
	            //aqui ya tienes en el array 
	            new Thread(new Cliente(arraySocket[0], arraySocket[1])).start();
	            }
	        } catch (IOException io) {
	            System.err.println("Error en el servidor: " + io.getMessage());
	        }
	        
	    }
	}

