package co.edu.eafit.cec.dipl.rs.entidades;

import java.util.UUID;

public class Reserva {

	private String id;
	private Vuelo vuelo;
	private Silla silla;
	private String pasajero;
	//ojo mala practica
	//disponible = 0
	//no disponible = 1
	private int estado;
	
	public Reserva() {
		
	}
	
	public Reserva(Vuelo vuelo, Silla silla, String pasajero) {
		super();
		this.id  = UUID.randomUUID().toString();
		this.vuelo = vuelo;
		this.silla = silla;
		this.pasajero = pasajero;
		this.estado = 1;
		
	}


	public Reserva(String id, Vuelo vuelo, Silla silla, String pasajero) {
		super();
		this.id = id;
		this.vuelo = vuelo;
		this.silla = silla;
		this.pasajero = pasajero;
		this.estado = 1;
	}


	public String getId() {
		return id;
	}


	public Vuelo getVuelo() {
		return vuelo;
	}


	public Silla getSilla() {
		return silla;
	}


	public String getPasajero() {
		return pasajero;
	}


	public int getEstado() {
		return estado;
	}


	public void cancelar() {
		this.estado = 0;
		this.silla.liberar();
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public void setSilla(Silla silla) {
		this.silla = silla;
	}

	public void setPasajero(String pasajero) {
		this.pasajero = pasajero;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void modificar(Reserva reservaModificada) {
		if(reservaModificada != null) {
			//una modificacion no cambia el ID, ni el estado, solo los datos del vuelo, silla y/o pasajero
			this.setVuelo(reservaModificada.getVuelo());
			this.setSilla(reservaModificada.getSilla());
			this.pasajero = reservaModificada.getPasajero();
			
		}
		
	}
		
}
