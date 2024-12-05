package actividadHilos_01.parteA;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca 3 numeros ");
		System.out.println("Primer numero: ");
		Long num1 = sc.nextLong();
		System.out.println("Primer numero: ");
		Long num2 = sc.nextLong();
		System.out.println("Primer numero: ");
		Long num3 =sc.nextLong();
		
		Thread hilo1 = new HiloA(num1, "HiloNumero1");
		hilo1.start();
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread hilo2 =new HiloA(num2, "HiloNumero2");
		hilo2.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread hilo3= new HiloA(num3, "HiloNumero3");
		hilo3.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
