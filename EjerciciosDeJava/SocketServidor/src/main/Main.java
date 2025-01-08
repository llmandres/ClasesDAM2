package main;

import modelo.negocio.Gestor;
import vista.ServidorVista;

public class Main {

	public static void main(String[] args) {
		Gestor gestor = new Gestor();
        ServidorVista vista = new ServidorVista(gestor);
        vista.iniciarServidor();

	}

}
