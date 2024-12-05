package actividadHilos_01.parteB;

import java.util.Date;
import java.util.Scanner;

public class HiloC implements Runnable {
	
	private long num;
	private long num2;
	private String cadena;


	public HiloC(long num, long num2, String cadena, String nombreHilo) {
		this.num = num;
		this.num2 = num2;
		this.cadena = cadena;
		Thread t1 = new Thread(this,nombreHilo);
		t1.start();
		

	}


	@Override
	public void run() {
		System.out.println("--------------------------------------");
		long repeticion = 0;
		if(num>num2) {
			repeticion = num-num2;
		}else if(num2>num) {
			repeticion = num2-num;
		}else {
			repeticion = 0;
		}
        Date inicio = new Date();
        long tiempoInicio = inicio.getTime();
		for(long i = 1; i<=repeticion;i++) {
			System.out.println(cadena);
		}
		Date finaltime = new Date();
	    long tiempofinal = finaltime.getTime();    
	    long tiempoTotal = tiempofinal - tiempoInicio;
	    System.out.println("El programa ha tardado en funcionar estos milisegundos : " + tiempoTotal );

        System.out.println("-----------------------------------------");
	}
	
	

}
