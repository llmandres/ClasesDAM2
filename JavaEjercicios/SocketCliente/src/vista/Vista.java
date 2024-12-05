package vista;

import java.util.Scanner;

import modelo.gestor.GestorCliente;

public class Vista {
    private GestorCliente gestor;

    public Vista(GestorCliente gestor) {
        this.gestor = gestor;
    }
    public void iniciar() throws InterruptedException {
        try (Scanner sc = new Scanner(System.in)) {
            String opcion;
            do {
                System.out.println("-------------------------------------------------------------------------");
                mostrarMenu();
                opcion = sc.nextLine();

                if (opcion.equals("5")) {
                    System.out.println("Saliendo del programa...");
                    break;
                }
                System.out.print("Número 1: ");
                double numero1 = Double.parseDouble(sc.nextLine());
                
                System.out.print("Número 2: ");
                double numero2 = Double.parseDouble(sc.nextLine());

                String resultado = gestor.realizarOperacion(numero1, numero2, opcion);
                System.out.println("El resultado de la operación es: " + resultado);
                Thread.sleep(3000);
                
                System.out.println("-------------------------------------------------------------------------");

            } while (!opcion.equals("5"));
        }
    }

    private void mostrarMenu() {
        System.out.println("Opciones Calculadora:");
        System.out.println("0. Sumar");
        System.out.println("1. Restar");
        System.out.println("2. Dividir");
        System.out.println("3. Multiplicar");
        System.out.println("4. Resto");
        System.out.println("5. Salir del programa");
        System.out.print("Seleccione una opción: ");
    }
}