package actividadEmpresa;

import java.util.ArrayList;
import java.util.List;

public class MainEmpresa {

	public static void main(String[] args) {
		Empresa e = new Empresa();
		Jefe j = new Jefe();
		Empleado c1 = new Currito();
		Empleado c2 =  new Currito();
		List<Empleado> listaEmpleado = new ArrayList<Empleado>();
		e.setListaEmpleados(listaEmpleado);
		listaEmpleado.add(j);
		listaEmpleado.add(c1);
		listaEmpleado.add(c2);
		List<Empleado> listaEmpleadoACargo = new ArrayList<Empleado>();
		j.setListaEmpleadosACargo(listaEmpleadoACargo);
		listaEmpleadoACargo.add(c1);
		listaEmpleadoACargo.add(c2);
		
		c1.setSalario(1000);
		c2.setSalario(1200);
		j.setSalario(2000);
		j.setDespacho("A");
		
		e.setDireccion(new Direccion());
		e.getDireccion().setTipoVia(TipoVia.AVENIDA);
		
		llamarMetodos(listaEmpleado, e, listaEmpleadoACargo);
		
	}
	public static void llamarMetodos(List<Empleado> listaEmpleado, Empresa e, List<Empleado> listaEmpleadoACargo) {
		for (Empleado a : listaEmpleado) {
			if(a instanceof Jefe) {
				System.out.println("El salario del Jefe es : " + a.calcularSueldo());
			}else {
				System.out.println("El salario del currito es : " + a.calcularSueldo());
			}
			
		}
		System.out.println("---------------------------------------------------");
		System.out.println("La cantidad de jefes en la empresa es de: " + e.cuantosJefesEnEmpleados());
		System.out.println("---------------------------------------------------");
		System.out.println("El salario total de todos los empleados de la empresa es de : " + e.calcularSalarioEmpleados());
		System.out.println("---------------------------------------------------");
		System.out.println("Lista de empleados del jefe");
		for (Empleado b : listaEmpleadoACargo) {
			System.out.println(b.toString());
		}
	}

}
