package actividadEmpresa;

public class Currito extends Empleado {
	
	private double jornada;
	private double horasExtra;
	
	public double getJornada() {
		return jornada;
	}
	public void setJornada(double jornada) {
		this.jornada = jornada;
	}
	public double getHorasExtra() {
		return horasExtra;
	}
	public void setHorasExtra(double horasExtra) {
		this.horasExtra = horasExtra;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Currito [jornada=" + jornada + ", horasExtra=" + horasExtra + ", getJornada()=" + getJornada()
				+ ", getHorasExtra()=" + getHorasExtra() + ", calcularSueldo()=" + calcularSueldo() + ", getNombre()="
				+ getNombre() + ", getSexo()=" + getSexo() + ", getEdad()=" + getEdad() + ", getDireccion()="
				+ getDireccion() + ", getSalario()=" + getSalario() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	/*
	 * Este método devuelve un valor double cuyo valor corresponde
	 * al salario del trabajador más el total de sus horas extra
	 * multiplicado por 50
	 */
	@Override
	public double calcularSueldo() {
		double sueldoExtra = this.horasExtra * 50;
		double salarioCurrito = this.getSalario() + sueldoExtra;
		return salarioCurrito;
	}
	
	
	

}
