package actividadHilos_01.parteC;

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
		
		HiloA a = new HiloA(num1, "HiloNumero1");
		a.run();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new HiloA(num2, "HiloNumero2");
		t2.run();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t3 = new HiloA(num3, "HiloNumero3");
		t3.run();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
