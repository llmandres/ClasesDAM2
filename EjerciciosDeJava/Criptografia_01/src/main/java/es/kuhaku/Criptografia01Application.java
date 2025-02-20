package es.kuhaku;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Criptografia01Application {
    private static SecretKey aesKey; // Clave simétrica
    private static KeyPair rsaKeyPair; // Claves asimétricas 
    private static String aesString = ""; 
    private static String confidencialStringEncriptado = "";
    private static String stringEncriptadoAutenticidad = ""; 

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Criptografia01Application.class, args);
        
        KeyGenerator generador = KeyGenerator.getInstance("AES");
        KeyPairGenerator generadorRSA = KeyPairGenerator.getInstance("RSA");
        aesKey = generador.generateKey();
        rsaKeyPair = generadorRSA.generateKeyPair();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Encriptar frase (AES)");
            System.out.println("2. Mostrar frase encriptada (AES)");
            System.out.println("3. Desencriptar frase (AES)");
            System.out.println("4. Encriptar frase con RSA (Confidencialidad)");
            System.out.println("5. Encriptar frase con RSA (Autenticidad)");
            System.out.println("6. Desencriptar frase confidencial (RSA)");
            System.out.println("7. Desencriptar frase autenticada (RSA)");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Introduce una frase para encriptar (AES): ");
                    String text = scanner.nextLine();
                    aesString = encriptarAES(text, aesKey); // String encriptado con la llave
                    System.out.println("Frase encriptada correctamente.");
                    break;
                case 2:
                	if(aesString.equals("")) {
                		System.out.println("Introduce una String primero");
                   		Thread.sleep(1000);
                		break;
                	}
                    System.out.println("Frase encriptada (AES): " + aesString); // Se muestra en Base64
                    break;
                case 3:
                	if(aesString.equals("")) {
                		System.out.println("Introduce una String primero");
                		Thread.sleep(1000);
                		break;
                	}
                    System.out.println("Frase desencriptada (AES): " + decryptAES(aesString, aesKey)); // Se desencripta
                    // mandando el String encriptado y la misma llave
                    break;
                case 4:
                    System.out.print("Introduce una frase para encriptar (Confidencialidad - RSA): ");
                    confidencialStringEncriptado = encryptRSA(scanner.nextLine(), rsaKeyPair.getPublic()); // Se encripta pasandole
                    // la key publica
                    System.out.println("Frase encriptada con RSA correctamente.");
                    break;
                case 5:
                    System.out.print("Introduce una frase para encriptar (Autenticidad - RSA): ");
                    stringEncriptadoAutenticidad = encryptRSA(scanner.nextLine(), rsaKeyPair.getPrivate()); // Se encripta
                    // usando la key privada
                    System.out.println("Frase autenticada con RSA correctamente.");
                    break;
                case 6:
                	if(confidencialStringEncriptado.equals("")) {
                		System.out.println("Introduce una String primero");
                   		Thread.sleep(1000);
                		break;
                	}
                    System.out.println("Frase confidencial desencriptada (RSA): " + decryptRSA(confidencialStringEncriptado, rsaKeyPair.getPrivate()));
                    // Se desencripta con la privada ahora, ya que he usado la publica para encriptar
                    break;
                case 7:
                	if(stringEncriptadoAutenticidad.equals("")) {
                		System.out.println("Introduce una String primero");
                   		Thread.sleep(1000);
                		break;
                	}
                    System.out.println("Frase autenticada desencriptada (RSA): " + decryptRSA(stringEncriptadoAutenticidad, rsaKeyPair.getPublic()));
                    // Se desencripta con la publica ahora, ya que he usado la privada para encriptar
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }
    }

    // AES 

    private static String encriptarAES(String text, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptAES(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));// Han sido Encodeadas anteriormente
        // asi que se usa decoder
        return new String(decryptedBytes);
    }

    // RSA 

    private static String encryptRSA(String text, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptRSA(String encryptedText, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));// Han sido Encodeadas anteriormente
        // asi que se usa decoder
        return new String(decryptedBytes);
    }
}
