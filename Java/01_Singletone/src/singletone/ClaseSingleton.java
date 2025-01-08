package singletone;

public class ClaseSingleton {
	// Esta estructura sirve para no permitir a otros crear objetos en tu programa
	// esto se hace haciendo private al constructor.
	
	
	// STATIC para que no se necesite crear una ClaseSingleton para acceder a el
	private static ClaseSingleton instance = null;
	
	private ClaseSingleton() {
		
	}
	
	// Ahora con getInstance podemos crear el UNICO OBJETO que se creara de este tipo
	// usamos la referencia creada static instance para dar un objeto.
	
	// Si la instance apunta a null nos dara un objeto creado, pero si ya ha sido creado una vez
	// nos devolvera la referencia con el objeto ya creado dentro previamante. Porque ya no pasa
	// por el if.
	public static ClaseSingleton getInstance() {
		if (instance == null){
		instance = new ClaseSingleton();
		}
		return instance;
	}
	

}
