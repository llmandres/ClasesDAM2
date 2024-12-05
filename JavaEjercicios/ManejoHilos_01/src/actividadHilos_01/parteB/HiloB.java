package actividadHilos_01.parteB;

import java.util.Date;
import java.util.Scanner;

public class HiloB extends Thread {
	
	private long num;


	public HiloB(long num, String nombreHilo) {
		this.num = num;
		this.start();
		

	}


	@Override
	public void run() {
		System.out.println("--------------------------------------");
        Date inicio = new Date();
        long tiempoInicio = inicio.getTime();
		for(long i = num; i<=1000000000;i++) {
			System.out.println(i);
		}
		Date finaltime = new Date();
	    long tiempofinal = finaltime.getTime();    
	    long tiempoTotal = tiempofinal - tiempoInicio;
	    System.out.println("El programa ha tardado en funcionar estos milisegundos : " + tiempoTotal );

        System.out.println("-----------------------------------------");
		
	}

}
