package interfaces_basico;

public class Main {
	public static void main(String[] args) {
		Operable operacion = new Suma();
		System.out.println(operacion.operar(10,200));
		
		operacion = new Resta();
		System.out.println(operacion.operar(10,200));
		
		
		
		// Interfaz con una clase anonima, son clases de un uso
		// No es reutilizable la clase pero si el objeto.
		Operable multiplicacion = new Operable() {
			
			@Override
			public double operar(double n1, double n2) {
				return n1*n2;
			}
		};
		System.out.println(multiplicacion.operar(10,300));
		multiplicacion = null;
		// Las funciones landa salen de interfaces funcionales.
		
		// Esto es una funcion lambda
		// Se pone los parametros de entrada y pones la flecha 
		// TIENE QUE SER FUNCIONAL, ya que las interfaces funcionales 
		// solo tienen un metodo lo que hace que sea posible ponerlo
		// de esta forma.
		// Realmente la flecha lambda es igual una clase anonima. Pero
		// mas moderno y bonito
		Operable division = (op1,op2) -> {
			double resultado = op1/op2;
			return resultado;
		};
		System.out.println(division.operar(10, 30));
		
		// Si solo tenemos una instrucción y devuelve algo
		// no hace falta poner la palabra "return"
		Operable siempreCero = (op1,op2) -> 0;
		System.out.println(siempreCero.operar(1, 0));
	}
}
