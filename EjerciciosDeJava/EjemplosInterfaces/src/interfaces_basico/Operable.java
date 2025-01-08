package interfaces_basico;

@FunctionalInterface  // Esto comprueba que la interfaz si es funcional en tiempo 
					  //de compilación.
public interface Operable {
	
	// Cuando una interfaz tiene un unico metodo se llama interfaz funcional
	// , normalmente usadas en funciones landa.
	double operar(double n1, double n2);
	// void segundoMetodo(); -> Si esto no es un comentario daria error en tiempo
	// de compilacion debido a la etiqueta @FunctionalInterface.

}
