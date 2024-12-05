package actividadHilos_01.parteA;

import java.util.Date;
import java.util.Scanner;

public class HiloA extends Thread {
	
	private long num;


	public HiloA(long num, String nombreHilo) {
		this.num = num;
		

	}


	@Override
	public void run() {
		System.out.println("--------------------------------------");
		System.out.println("El numero pedido a analizar es : " + num);
		System.out.println("El nombre del hilo es : " + Thread.currentThread().getName());
        Date inicio = new Date();
        long tiempoInicio = inicio.getTime();
		if(esPrimo(num)) {
			System.out.println("El numero es primo");
		}else {
			System.out.println("El numero no es primo");
		}
        Date finaltime = new Date();
        long tiempofinal = finaltime.getTime();
        
        long tiempoTotal = tiempofinal - tiempoInicio;
        System.out.println("El programa ha tardado en funcionar estos milisegundos : " + tiempoTotal );
        System.out.println("-----------------------------------------");
		
	}
	
	 public static boolean esPrimo(long numero) {
	        if (numero < 2) {
	            return false;
	        }

	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false; 
	            }
	        }
	        return true; 
	    }

}
