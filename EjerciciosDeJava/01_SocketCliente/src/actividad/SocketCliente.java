package actividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
	public static final int PUERTO = 4951;
	public static final String IP_SERVER = "172.26.100.176";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Calculadora");
		System.out.println("-----------------");
		
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		
		try(Scanner sc = new Scanner(System.in)){
			
			String opcion = "0";
			double numero1 = 0;
			double numero2 = 0;
			do {
				System.out.println("-------------------------------------------------------------------------");
			menu();
			opcion = sc.nextLine();
			if(opcion.equals("5")) {
				break;
			}
				
			System.out.println("Introduzca los numeros con los que quieres operar");
			System.out.println("Numero 1");
			numero1 = Integer.parseInt(sc.nextLine());
			System.out.println("Numero 2");
			numero2 = Integer.parseInt(sc.nextLine());
			
			
		
			try (Socket socketAlServidor = new Socket()) {
	            socketAlServidor.connect(direccionServidor);
	            System.out.println("Conexion establecida a " + IP_SERVER + " con exito");
	            
	            PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
	    		String aEnviar = numero1 + "_" + numero2;
	    	    salida.println(opcion);
	            salida.println(aEnviar);
	     

	            
	            InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
	            BufferedReader bf = new BufferedReader(entrada);
	            
	            System.out.println("El resultado de la operacion es: " + bf.readLine());
	            Thread.sleep(4000);
	            
	        } catch (IOException e) {
	            System.out.println("Error de conexion con el servidor: " + e.getMessage());
	        }
			
			
			System.out.println("-------------------------------------------------------------------------");
			}while(!opcion.equals("5"));
			

		}


	}
	
	public static void menu () {
		System.out.println("Opciones Calculadora");
		System.out.println("0. Sumar");
		System.out.println("1. Restar");
		System.out.println("2. Dividir");
		System.out.println("3. Multiplicar");
		System.out.println("4. Resto");
		System.out.println("5. Salir del programa");
	}

}
