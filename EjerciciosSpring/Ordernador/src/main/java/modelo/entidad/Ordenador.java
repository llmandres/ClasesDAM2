package modelo.entidad;

import java.util.ArrayList;

public class Ordenador {
	private double precio;
	private Procesador procesador;
	private TarjetaGrafica tarjetaGrafica;
	private PlacaBase placaBase;
	private RAM RAM;
	private ArrayList<Periferico> listaPerifericos;
	
	public Ordenador() {
		super();
	}

	// Metodos
	
	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", procesador=" + procesador.toString() + ", tarjetaGrafica=" + tarjetaGrafica.toString()
				+ ", placaBase=" + placaBase.toString() + ", listaRAM=" + RAM.toString() + ", listaPerifericos=" + listaPerifericos.toString()
				+ "]";
	}
	

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public TarjetaGrafica getTarjetaGrafica() {
		return tarjetaGrafica;
	}

	public void setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public PlacaBase getPlacaBase() {
		return placaBase;
	}

	public void setPlacaBase(PlacaBase placaBase) {
		this.placaBase = placaBase;
	}

	public RAM getListaRAM() {
		return RAM;
	}

	public void setListaRAM(RAM listaRAM) {
		this.RAM = listaRAM;
	}

	public ArrayList<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}

	public void setListaPerifericos(ArrayList<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}
	
}

