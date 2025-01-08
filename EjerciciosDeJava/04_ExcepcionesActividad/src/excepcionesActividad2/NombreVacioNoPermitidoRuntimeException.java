package excepcionesActividad2;

public class NombreVacioNoPermitidoRuntimeException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public NombreVacioNoPermitidoRuntimeException() {
		super();
	}
	
	public NombreVacioNoPermitidoRuntimeException(String error) {
		System.out.println(error);
	}

}
