package es.kuhaku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;

import es.kuhaku.modelo.entidad.Ordenador;

@SpringBootApplication
public class Json01Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Json01Application.class, args);
		
		   StringBuilder jsonData = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ordenador.json"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                jsonData.append(line);
	            }
	            
	     } catch (IOException e) {

        System.out.println("Error al leer el archivo: " + e.getMessage());
    } catch (Exception e) {

        System.out.println("Error general: " + e.getMessage());
    }
		 Gson gson = new Gson();
         Ordenador ordenador = gson.fromJson(jsonData.toString(), Ordenador.class);
		System.out.println(ordenador);
	
	       

}
}
