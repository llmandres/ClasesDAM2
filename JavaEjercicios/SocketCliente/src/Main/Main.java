package Main;

import modelo.gestor.GestorCliente;
import vista.Vista;

public class Main {
	public static void main(String[] args) {
        GestorCliente gestor = new GestorCliente("172.26.100.176", 4951);

        Vista vista = new Vista(gestor);
        try {
			vista.iniciar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
