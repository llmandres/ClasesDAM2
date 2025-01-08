package modelo.negocio;

public class Gestor {


    public String procesarOperacion(int opcion, double numero1, double numero2) {
        try {
            double resultado = realizarCalculo(opcion, numero1, numero2);
            return String.valueOf(resultado);
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        } catch (IllegalArgumentException e) {
            return "Operación no válida";
        }
    }


    private double realizarCalculo(int opcion, double numero1, double numero2) {
        switch (opcion) {
            case 0: return numero1 + numero2;
            case 1: return numero1 - numero2;
            case 2: return numero1 / numero2;
            case 3: return numero1 * numero2;
            case 4: return numero1 % numero2;
            default: throw new IllegalArgumentException("Opción no válida");
        }
    }
}