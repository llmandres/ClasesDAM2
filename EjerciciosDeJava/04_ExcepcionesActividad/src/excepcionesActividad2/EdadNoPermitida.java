package excepcionesActividad2;

public class EdadNoPermitida extends Exception {

	private static final long serialVersionUID = 1L;
	
	public EdadNoPermitida() {
		super();
	}
	
	public EdadNoPermitida(String mensajeError) {
		System.out.println(mensajeError);
	}

}
