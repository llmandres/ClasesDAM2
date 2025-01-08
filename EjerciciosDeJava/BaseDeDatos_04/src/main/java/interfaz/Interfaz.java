package interfaz;

import java.util.List;
import java.util.Scanner;
import entidad.Coche;
import entidad.Pasajero;
import modelo.negocio.NegocioCoche;
import modelo.negocio.NegocioPasajero;
import modelo.persistencia.DaoCoche;

public class Interfaz {
    
    private static final NegocioCoche dc = new NegocioCoche();
    private static final NegocioPasajero np = new NegocioPasajero();
    private static Scanner sc = new Scanner(System.in);
    
    public static void mostrarInterfaz() {
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
        System.out.println("7- Menu de Pasajeros");
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
                break;
            case 6:
                listarCoches();
                break;
            case 7:
            	menuPasajeros();
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
        System.out.println("Introduce el año de fabricacion");
        int anioFabricacion = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el número de kilómetros");
        int kilometros = Integer.parseInt(sc.nextLine());
        int numero = dc.validarAlta(marca, modelo, anioFabricacion, kilometros);
        if( numero == 1) {
        	System.out.println("Marca o modelo vacio");
        }else if(numero == 2) {
        	System.out.println("Se ha guardado correctamente");
        }else {
        	System.out.println("Ha ocurrido un error");
        }
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

    public static void darDeBajaCoche(Scanner sc) {
        System.out.println("Introduce la ID del coche que desea borrar");
        int id = Integer.parseInt(sc.nextLine());
        int numero = dc.validarBaja(id);
        if(numero == 0) {
        	System.out.println("El coche no se ha dado de baja correctamente");
        }else if (numero == 2) {
        	System.out.println("El coche se ha dado de baja correctamente");
        }
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
        System.out.println("Introduce el año de fabricacion");
        int anioFabricacion = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el número de kilómetros");
        int kilometros = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce la ID del coche que quieres modificar");
        int id = Integer.parseInt(sc.nextLine());
        int numero = dc.modificarPorID(marca, modelo, anioFabricacion, kilometros, id);
        if(numero == 2) {
        	System.out.println("El coche se ha modificado correctamente");
        }else {
        	System.out.println("El coche no se ha modificado correctamente.");
        }
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
    }

    public static void buscarCochePorId(Scanner sc) {
        System.out.println("Introduce la ID del coche que buscas");
        int id = Integer.parseInt(sc.nextLine());
        Coche c = dc.buscarPorId(id);
        if (c != null) {
            System.out.println(c.toString());
        } else {
            System.out.println("Coche no encontrado.");
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
    public static void menuPasajeros() {
    	int opcion = 0;
    	 do {
             System.out.println("====== Menú de Gestión de Pasajeros ======");
             System.out.println("1. Crear nuevo pasajero");
             System.out.println("2. Borrar pasajero por ID");
             System.out.println("3. Consultar pasajero por ID");
             System.out.println("4. Listar todos los pasajeros");
             System.out.println("5. Añadir pasajero a coche");
             System.out.println("6. Eliminar pasajero de un coche");
             System.out.println("7. Listar todos los pasajeros de un coche");
             System.out.println("8. Salir");
             System.out.print("Seleccione una opción: ");
             opcion = Integer.parseInt(sc.nextLine());
             menuPasajerosFunc(opcion);
    	 }while(opcion != 8);
    }
    public static void menuPasajerosFunc(int opcion) {
    	switch (opcion) {
        case 1:
            darAltaPasajero();
            break;
        case 2:
            darBajaPasajero();
            break;
        case 3:
            buscarPorIdPasajero();
            break;
        case 4:
            listarPasajeros();
            break;
        case 5:
            aniadirPasajeroACoche();
            break;
        case 6:
            eliminarPasajeroACoche();
            break;
        case 7:
            listarPasajerosEnCoche();
            break;
        case 8:
            System.out.println("Saliendo del programa. ¡Hasta luego!");
            break;
        default:
            System.out.println("Opción no válida. Por favor, intente de nuevo.");
    }
    	
    }
    public static void darAltaPasajero() {
    	  System.out.println("Introduce el nombre");
          String nombre = sc.nextLine();
          System.out.println("Introduce la edad");
          int edad = Integer.parseInt(sc.nextLine());
          System.out.println("Introduce el peso");
          double peso = Double.parseDouble(sc.nextLine());
          int numero = np.validarAltaPasajero(nombre, edad, peso);
          if (numero == 1) {
        	  System.out.println("Pasajero dado de alta");
          }else {
        	  System.out.println("Pasajero no dado de alta");
          }
    }
    public static void darBajaPasajero() {
        System.out.println("Introduce el ID del pasajero");
        int idPasajero = Integer.parseInt(sc.nextLine());

        int numero = np.validarBajaPasajero(idPasajero);
        if (numero == 1) {
      	  System.out.println("Pasajero dado de baja");
        }else {
      	  System.out.println("Pasajero no dado de baja");
        }
  }
    public static void buscarPorIdPasajero() {
        System.out.println("Introduce el ID del pasajero");
        int idPasajero = Integer.parseInt(sc.nextLine());

        Pasajero p = np.buscarPasajeroPorId(idPasajero);
        if (p != null) {
      	  System.out.println(p.toString());
        }else {
      	  System.out.println("No se ha encontrado");
        }
  }
    public static void listarPasajeros() {
    	List<Pasajero> listaPasajeros = np.listarPasajeros();
        if (listaPasajeros != null) {
      	  listaPasajeros.forEach((v) ->{
      		  System.out.println(v.toString());
      	  });
        }else {
      	  System.out.println("Lista Vacia o Error");
        }
  }
    public static void aniadirPasajeroACoche() {
        System.out.println("Introduce el ID del coche");
        int idCoche = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el ID del pasajero");
        int idPasajero = Integer.parseInt(sc.nextLine());

        int numero = np.aniadirPasajeroaCoche(idCoche, idPasajero);
        if (numero == 1) {
      	  System.out.println("Añadido correctamente");
        }else {
      	  System.out.println("Error al añadir");
        }
  }
    public static void eliminarPasajeroACoche() {
        System.out.println("Introduce el ID del pasajero");
        int idPasajero = Integer.parseInt(sc.nextLine());

        int numero = np.eliminarPasajeroaCoche(idPasajero);
        if (numero == 1) {
      	  System.out.println("Eliminado correctamente");
        }else {
      	  System.out.println("Error al eliminar");
        }
  }
    public static void listarPasajerosEnCoche() {
        System.out.println("Introduce el ID del coche");
        int idcoche = Integer.parseInt(sc.nextLine());
        List<Pasajero> listaPasajerosEnCoche = np.listarPasajeroDeCoche(idcoche);
        if (listaPasajerosEnCoche != null) {
      	  listaPasajerosEnCoche.forEach((v) ->{
      		  System.out.println(v.toString());
      	  });
        }else {
      	  System.out.println("Lista Vacia o Error");
        }
  }

}




