package actividadHilos_01.parteB;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce 2 numeros y 1 cadena de texto");
		System.out.println("Introduce el primer numero");
		long num1 = sc.nextLong();	
		System.out.println("Introduce el segundo numero");
		long num2 = sc.nextLong();	
		System.out.println("Introduce la cadena de texto");
		sc.nextLine();
		String cadena = sc.nextLine();	
		
		
		new HiloA(num1, "Hilo1");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Presiona el espacio para continuar");
		sc.nextLine();
		new HiloC(num1, num2, cadena, "Hilo3");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Presiona el espacio para continuar");
		sc.nextLine();
		new HiloB(num2, "Hilo2");
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
