package es.upgrade.rest.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Utilizado Spring Web y Lombok

@RestController // Convierte la clase en el objeto Controlador / Rest
public class RestMensaje {
	private String mensaje = "mensaje inicial";
	
	
	@GetMapping("/mensaje") // Esto se hace un punto de acceso
	public String getMensaje() {
		return mensaje;
	}
	
	@PutMapping("/mensaje") // Con esto podemos modificar un recurso usando el method PUT
	public String modificarMensaje(@RequestBody String mensaje) {  // El RequestBody, espera un mensaje y que lo pase directamente ahi
		this.mensaje = mensaje;
		return "Mensaje modificado"; // 200 OK (Se deberia de enviar eso)
		
	}

}
