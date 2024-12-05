package excepcionesActividad2;

public class Persona {
	private int edad;
	private String nombre;
	
	
	
	public Persona(int edad, String nombre) {
		super();
		if(nombre == null) {
			throw new IllegalArgumentException("ERROR, el atributo 'nombre' es null");
		}else if(nombre.equals("")) {
			throw new NombreVacioNoPermitidoRuntimeException("El atributo 'nombre' esta vacio");
		}else {
			this.nombre = nombre;
			
		}
		
		this.edad = edad;
	}
	public Persona() {
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) throws EdadNoPermitida {
		if(edad<0) {
			throw new EdadNoPermitida("Edad negativa introducida");
		}else {
		this.edad = edad;
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
