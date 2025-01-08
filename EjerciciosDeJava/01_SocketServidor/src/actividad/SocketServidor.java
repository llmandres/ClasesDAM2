package actividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static final int PUERTO = 4951;
	public static void main(String[] args) {
		
		System.out.println("CALCULADORA");
		System.out.println("-----------");
		int numeroPeticion = 0;
		
		
		InputStreamReader entrada = null;
		PrintStream salida = null;
		
		Socket socketAlCliente = null;
		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		
		try(ServerSocket serverSocket = new ServerSocket()){
			
			serverSocket.bind(direccion);
			while(true) {
			System.out.println("Esperando Peticion");

			socketAlCliente = serverSocket.accept();
			System.out.println("Peticion numero : " + ++numeroPeticion);
			
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			BufferedReader bf = new BufferedReader(entrada);
			
			String opcion = bf.readLine();
			int iOpcion = Integer.parseInt(opcion);
			
			String recibido = bf.readLine();
			
			System.out.println("Contenido recibido : " + recibido );
			
			String[] operadores = recibido.split("_");
			double iNumero1 = Double.parseDouble(operadores[0]);
			double iNumero2 = Double.parseDouble(operadores[1]);
			
		
			double resultado = devolverOperacion(iOpcion, iNumero1, iNumero2);
			
			
			
			System.out.println("El calculo es : " +devolverOperacion(iOpcion, iNumero1, iNumero2));
			salida = new PrintStream(socketAlCliente.getOutputStream());
			salida.println(resultado);
			socketAlCliente.close();
			}
			
			
			
		} catch (IOException io){
			
		}

	}
	
	public static double devolverOperacion(int opcion, double numero1, double numero2) {
		switch (opcion) {
		case 0: {
			return numero1 + numero2;
		}
	
		case 1: {
			return numero1 - numero2;
		}

		case 2: {
			return numero1 / numero2;
		}

		case 3: {
			return numero1 * numero2;
		}

		case 4: {
			return numero1 %numero2;
		}

		default:{
			System.out.println("Opcion no valida");
			return 0;
		}
		}
	}
	

}
