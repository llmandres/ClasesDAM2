package actividad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static final String NOMBRE_FICHERO = "login.txt";
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion = 0;
		File fn = new File(NOMBRE_FICHERO);
		if(!fn.exists()) {
			try {
				System.out.println("Fichero no existente, creando...");
				fn.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
			menu();
			
		}
	}
	
	public static HashMap<String, String> leerFichero() throws IOException {
		 HashMap<String, String> usuarios = new HashMap<>();
	        
	        try (FileReader fr = new FileReader(NOMBRE_FICHERO);
	             BufferedReader br = new BufferedReader(fr)) {
	            String frase;
	            while ((frase = br.readLine()) != null) {
	                String[] partes = frase.split("/");
	                if (partes.length == 2) {
	                    String usuario = partes[0].trim();
	                    String contrasenia = partes[1].trim();
	                    usuarios.put(usuario, contrasenia);
	                }
	            }
	        }
	        
	        return usuarios;
	}
	public static void escribirFichero(String usuario, String contrasenia) {
		try(FileWriter fw = new FileWriter("login.txt",true);
			BufferedWriter pw = new BufferedWriter(fw);) {
			pw.newLine();
			pw.write(usuario + "/" + contrasenia);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		public static boolean comprobarUsuario(String usuario, String password) throws IOException {
	        HashMap<String, String> usuarios = leerFichero();
	        
	 
	        if (usuarios.containsKey(usuario)) {
	            return usuarios.get(usuario).equals(password);
	        } else {
	            return false; 
	        }
	}
		public static void leerFicheroDeUsuarios() throws IOException {
			HashMap<String, String> usuarios = leerFichero();
		
			usuarios.forEach((t, u) -> {
				System.out.println(t + "/" + u);
			});
		
		}
		public static boolean Logearse(String usuario, String password) throws IOException {
			HashMap<String, String> usuarios = leerFichero();
		
			for (String t : usuarios.keySet()) {
		        String u = usuarios.get(t);
		        if (usuario.equals(t) && u.equals(password)) {
		            return true; 
		        }
		    }
		    return false; 
		
		}
		public static void menu() {
			int opcion = 0;
			do {
			System.out.println("Bienvenido al sistema de login que quieres hacer?");
			System.out.println("1.Ver los usuarios");
			System.out.println("2. Añadir un usuario");
			System.out.println("3. Loguearse");
			System.out.println("4 Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1: {
				try {
					leerFicheroDeUsuarios();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				case 2:{
					aniadirUsuario();

				}
				break;
				case 3:{
					int numeroIntentos = 0;
					System.out.println("Sistema Login");
	
					do {

					System.out.println("Introduce el usuario");
					String usuariologin = sc.nextLine();
					System.out.println("Introduce la contraseña");
					String contrasenialogin = sc.nextLine();
					try {
						Logearse(usuariologin, contrasenialogin);
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						if(Logearse(usuariologin, contrasenialogin) == false) {
						
							System.out.println("Contraseña o Usuario erroneo");
							numeroIntentos++;
						}else {
							System.out.println("Bienvenido al programa!");
							numeroIntentos = 5;
							opcion = 4;
						}
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}while(numeroIntentos < 3);
					if(numeroIntentos == 3) {
						System.out.println("Numero de intentos maximos alcanzados");
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						System.out.println("Expulsado");
						opcion = 4;
					}
				}
				break;
				case 4: {
					System.out.println("Saliendo");
				}
				break;	
				
			default:{
				System.out.println("Opcion no valida");
		
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			}
			}while(opcion != 4);
	
}
		public static void aniadirUsuario() {
			System.out.println("Introduce el usuario");
			String usuario = sc.nextLine();
			System.out.println("Introduce la contraseña");
			String contrasenia = sc.nextLine();
		
			try {
				if(comprobarUsuario(usuario, contrasenia) == true) {
					System.out.println("El usuario ya existe");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					escribirFichero(usuario, contrasenia);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}


