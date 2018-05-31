package co.edu.eafit.cec.dipl.rs.entidades;

import java.util.Date;
import java.util.List;

public class Vuelo{
	
	private String id;
	private String destino;
	private String origen;
	private Date fecha;
	private List<Silla> sillas;
	private int estado;
	
	public Vuelo() {
		
	}
	
	public Vuelo(String id) {
		super();
		this.id = id;
	}

	
	public Vuelo(String id, String destino, String origen, Date fecha, int estado) {
		super();
		this.id = id;
		this.destino = destino;
		this.origen = origen;
		this.fecha = fecha;
		this.estado = estado;
	}


	public Vuelo(String destino, String origen, Date fecha, List<Silla> sillas) {
		this.destino = destino;
		this.origen = origen;
		this.fecha = fecha;
		this.sillas = sillas;
	}
	
	
	public boolean estaDisponibleParaReservas() {
		for (Silla silla : sillas) {
			if(silla.estaDisponible()) {
				return true;
			}
		}
		return false;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getId() {
		return id;
	}

	public List<Silla> getSillas() {
		return sillas;
	}

	public int getEstado() {
		return estado;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSillas(List<Silla> sillas) {
		this.sillas = sillas;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
