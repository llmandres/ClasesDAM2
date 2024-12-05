package actividadFuncionesLambda;

public class Main {

	public static void main(String[] args) {
		
		// Numero elevado a otro
		Operable operacion = (n1,n2) -> {
			for (int i = 1; i <= n2; i++) {
				n1 = n1*n2;
			}
			return n1;
		};
		System.out.println(operacion.operar(2, 2));
		
		// Raiz cuadrada del primer numero
		
		operacion = new Operable() {
			
			@Override
			public double operar(double numero1, double numero2) {
				return Math.sqrt(numero1); 
		}
	};
	System.out.println(operacion.operar(4, 0));
}
}
	


