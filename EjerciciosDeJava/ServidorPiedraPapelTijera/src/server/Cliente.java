package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente implements Runnable {
    private Socket jugador1;
    private Socket jugador2;

    public Cliente(Socket jugador1, Socket jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

	@Override
	public void run() {
		int contadorwinj1 = 0;
		int contadorwinj2 = 0;
        try (
                BufferedReader j1entrada = new BufferedReader(new InputStreamReader(jugador1.getInputStream()));
                PrintStream j1salida = new PrintStream(jugador1.getOutputStream());
                BufferedReader j2entrada = new BufferedReader(new InputStreamReader(jugador2.getInputStream()));
                PrintStream j2salida = new PrintStream(jugador2.getOutputStream())
            ) {
			// Codigo : codigo_eleccion
			// R: Piedra P: Papel , S: Tijeras
        	j1salida.println("Eres el Jugador 1");
        	j2salida.println("Eres el Jugador 2");
        	 while (contadorwinj1 < 3 && contadorwinj2 < 3) {
                 j1salida.println("Jugador 1, elige R (Piedra), P (Papel) o S (Tijeras):");
                 j2salida.println("Jugador 2, elige R (Piedra), P (Papel) o S (Tijeras):");

                 String eleccionj1 = j1entrada.readLine();
                 String eleccionj2 = j2entrada.readLine();

                 // Lógica del juego
                 String resultado = juegoLogica(eleccionj1, eleccionj2, contadorwinj1, contadorwinj2);
                 j1salida.println(resultado);
                 j2salida.println(resultado);

                 if (resultado.contains("Jugador 1 gana")) {
                     contadorwinj1++;
                 } else if (resultado.contains("Jugador 2 gana")) {
                     contadorwinj2++;
                 }

                 j1salida.println("Jugador 1 lleva " + contadorwinj1 + " victorias.");
                 j2salida.println("Jugador 2 lleva " + contadorwinj2 + " victorias.");
             }

             // Final de la partida
             if (contadorwinj1 == 3) {

                 j1salida.println("_¡Jugador 1 Gana!");
                 j2salida.println("_¡Jugador 1 Gana!");
             } else if (contadorwinj2 == 3) {

                 j1salida.println("_¡Jugador 2 Gana!");
                 j2salida.println("_¡Jugador 2 Gana!");
             }
		}catch (IOException e) {
	        System.err.println("Error durante la partida: " + e.getMessage());
	    } finally {
	        try {
	            // Cerrar los sockets después de la partida
	            if (jugador1 != null && !jugador1.isClosed()) {
	                jugador1.close();
	            }
	            if (jugador2 != null && !jugador2.isClosed()) {
	                jugador2.close();
	            }
	        } catch (IOException e) {
	            System.err.println("Error al cerrar los sockets: " + e.getMessage());
	        }
	    }

	}
	private String juegoLogica (String eleccionj1, String eleccionj2, int contadorj1 , int contadorj2) {
		if(eleccionj1.equals(eleccionj2)) {
			return "Empate";
		}
		 switch (eleccionj1) {
         case "R": // Piedra
             if (eleccionj2.equals("S")) {
                 return "Jugador 1 gana (Piedra vs Tijeras)";
             } else if (eleccionj2.equals("P")) {
                 return "Jugador 2 gana (Papel vs Piedra)";
             }
             break;

         case "P": // Papel
             if (eleccionj2.equals("R")) {
                 return "Jugador 1 gana (Papel vs Piedra)";
             } else if (eleccionj2.equals("S")) {
                 return "Jugador 2 gana (Tijeras vs Papel)";
             }
             break;

         case "S": // Tijeras
             if (eleccionj2.equals("P")) {
                 return "Jugador 1 gana (Tijeras vs Papel)";
             } else if (eleccionj2.equals("R")) {
                 return "Jugador 2 gana (Piedra vs Tijeras)";
             }
             break;

         default:
             return "Elección no válida";
     }

     return "Elección no válida";
 }

}
