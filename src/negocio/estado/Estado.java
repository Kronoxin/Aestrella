/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.estado;

public class Estado 
{
	private boolean estaAbierto;
	private Nodo nodoActual;
	private Nodo nodoPadre;
	private double distanciaOrigen;
	private double distanciaDestino;
	private double distanciaTotal;
	
	
	
	public Estado(boolean estaAbierto, Nodo nodoActual, Nodo nodoPadre,
			double distanciaOrigen, double distanciaDestino,
			double distanciaTotal) {
		super();
		this.estaAbierto = estaAbierto;
		this.nodoActual = nodoActual;
		this.nodoPadre = nodoPadre;
		this.distanciaOrigen = distanciaOrigen;
		this.distanciaDestino = distanciaDestino;
		this.distanciaTotal = distanciaTotal;
	}
	
	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}

	public boolean isEstaAbierto() {
		return estaAbierto;
	}
	public void setEstaAbierto(boolean estaAbierto) {
		this.estaAbierto = estaAbierto;
	}
	public Nodo getNodoActual() {
		return nodoActual;
	}
	public void setNodoActual(Nodo nodoActual) {
		this.nodoActual = nodoActual;
	}
	public Nodo getNodoPadre() {
		return nodoPadre;
	}
	public void setNodoPadre(Nodo nodoPadre) {
		this.nodoPadre = nodoPadre;
	}
	public double getDistanciaOrigen() {
		return distanciaOrigen;
	}
	public void setDistanciaOrigen(double distanciaOrigen) {
		this.distanciaOrigen = distanciaOrigen;
	}
	public double getDistanciaDestino() {
		return distanciaDestino;
	}
	public void setDistanciaDestino(double distanciaDestino) {
		this.distanciaDestino = distanciaDestino;
	}
	
}