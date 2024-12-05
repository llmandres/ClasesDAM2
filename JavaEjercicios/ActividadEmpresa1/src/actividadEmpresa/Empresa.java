package actividadEmpresa;

import java.util.List;

public class Empresa {
	private String nombre;
	private String NIF;
	private Direccion direccion;
	private List<Empleado> listaEmpleados;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	public double calcularSalarioEmpleados() {
		double salarioTotal = 0;
		for(Empleado e : this.listaEmpleados) {
			salarioTotal = salarioTotal + e.getSalario();
		}
		return salarioTotal;
	}
	public int cuantosJefesEnEmpleados() {
		int numeroJefes = 0;
		for(Empleado e : this.listaEmpleados) {
			if(e instanceof Jefe) {
				numeroJefes++;
			}
		}
		return numeroJefes;
	}
	
	
	
	

}
