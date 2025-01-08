package interfaz;

import java.util.Scanner;
import entidad.Coche;
import modelo.persistencia.DaoCoche;

public class Interfaz {
    
    private static final DaoCoche dc = new DaoCoche();
    
    public static void mostrarInterfaz() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            menu();
            try {
                String inputUsuario = sc.nextLine(); 
                opcion = Integer.parseInt(inputUsuario); 
                menuFunc(opcion, sc);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                opcion = -1; // Esto para que siga el bucle
            }
        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("\n--- Menú de Gestión de Coches ---");
        System.out.println("1- Dar de alta coche");
        System.out.println("2- Dar de baja coche por id");
        System.out.println("3- Modificar coche por id");
        System.out.println("4- Buscar coche por id");
        System.out.println("5- Buscar coches por marca");
        System.out.println("6- Listar todos los coches");
        System.out.println("0- Salir de la aplicación");
        System.out.print("Seleccione una opción: ");
    }

    public static void menuFunc(int opcion, Scanner sc) {
        switch (opcion) {
            case 1:
                darDeAltaCoche(sc);
                break;
            case 2:
                darDeBajaCoche(sc);
                break;
            case 3:
                modificarCoche(sc);
                break;
            case 4:
                buscarCochePorId(sc);
                break;
            case 5:
                buscarCochePorMarca(sc);
                break;
            case 6:
                listarCoches();
                break;
            case 0:
                System.out.println("Saliendo de la aplicación...");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    public static void darDeAltaCoche(Scanner sc) {
        System.out.println("Introduce la marca");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo");
        String modelo = sc.nextLine();
        System.out.println("Introduce el tipo de motor");
        String tipoMotor = sc.nextLine();
        System.out.println("Introduce el número de kilómetros");
        int kilometros = Integer.parseInt(sc.nextLine());
        System.out.println( dc.darAlta(marca, modelo, tipoMotor, kilometros));
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

    public static void darDeBajaCoche(Scanner sc) {
        System.out.println("Introduce la ID del coche que desea borrar");
        int id = Integer.parseInt(sc.nextLine());
       System.out.println( dc.darDeBaja(id));

        try {
  			Thread.sleep(3000);
  		} catch (InterruptedException e) {

  			e.printStackTrace();
  		}
    }

    public static void modificarCoche(Scanner sc) {
        System.out.println("Introduce la marca");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo");
        String modelo = sc.nextLine();
        System.out.println("Introduce el tipo de motor");
        String tipoMotor = sc.nextLine();
        System.out.println("Introduce el número de kilómetros");
        int kilometros = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce la ID del coche que quieres modificar");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println(dc.modificarPorID(marca, modelo, tipoMotor, kilometros, id));
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

    public static void buscarCochePorId(Scanner sc) {
        System.out.println("Introduce la ID del coche que buscas");
        int id = Integer.parseInt(sc.nextLine());
        Coche c = dc.buscarPorID(id);
        if (c != null) {
            System.out.println(c.toString());
        } else {
            System.out.println("Coche no encontrado.");
        }
    }

    public static void buscarCochePorMarca(Scanner sc) {
        System.out.println("Introduce la marca del coche");
        String marca = sc.nextLine();
        Coche c = dc.buscarPorMarca(marca);
        if (c != null) {
            System.out.println(c.toString());
        } else {
            System.out.println("Coche no encontrado.");
        }
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

    public static void listarCoches() {
        System.out.println("Mostrando coches:");
        dc.listarCoches().forEach(v -> {
            System.out.println(v.toString());
        });
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

}




