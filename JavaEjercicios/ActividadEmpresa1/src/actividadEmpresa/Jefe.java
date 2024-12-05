package actividadEmpresa;

import java.util.List;

public class Jefe extends Empleado {

	private int numeroEmpleados;
	private List<Empleado> listaEmpleadosACargo;
	private String despacho;
	
	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}
	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}
	public List<Empleado> getListaEmpleadosACargo() {
		return listaEmpleadosACargo;
	}
	public void setListaEmpleadosACargo(List<Empleado> listaEmpleadosACargo) {
		this.listaEmpleadosACargo = listaEmpleadosACargo;
	}
	
	public String getDespacho() {
		return despacho;
	}
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}
	
	@Override
	public String toString() {
		return "Jefe [numeroEmpleados=" + numeroEmpleados + ", listaEmpleadosACargo=" + listaEmpleadosACargo
				+ ", despacho=" + despacho + ", getNumeroEmpleados()=" + getNumeroEmpleados()
				+ ", getListaEmpleadosACargo()=" + getListaEmpleadosACargo() + ", getDespacho()=" + getDespacho()
				+ ", calcularSueldo()=" + calcularSueldo() + ", getNombre()=" + getNombre() + ", getSexo()=" + getSexo()
				+ ", getEdad()=" + getEdad() + ", getDireccion()=" + getDireccion() + ", getSalario()=" + getSalario()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	public double calcularSueldo() {
		double diez = 0;
		double salarioAniadir = 0;
		for (Empleado e : this.listaEmpleadosACargo) {
			diez = e.getSalario()*0.10;
			salarioAniadir = salarioAniadir + diez;
		}
		double salarioCurrito = this.getSalario() + salarioAniadir;
		return salarioCurrito;
	}
}
