package modelo.gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class GestorCliente {
    private InetSocketAddress direccionServidor;

    public GestorCliente(String ipServidor, int puerto) {
        this.direccionServidor = new InetSocketAddress(ipServidor, puerto);
    }


    public String realizarOperacion(double numero1, double numero2, String opcion) {
        try (Socket socketAlServidor = new Socket()) {
            socketAlServidor.connect(direccionServidor);
            System.out.println("Conexión establecida con éxito a " + direccionServidor.getAddress());
            
            PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
            String aEnviar = numero1 + "_" + numero2;
            salida.println(opcion);
            salida.println(aEnviar);


            BufferedReader bf = new BufferedReader(new InputStreamReader(socketAlServidor.getInputStream()));
            return "El resultado es :  " + bf.readLine();

        } catch (IOException e) {
            return "Error de conexión con el servidor: " + e.getMessage();
        }
    }
}