package co.edu.eafit.cec.dipl.rs.dto;

public class ReservaDto {
	private String vuelo;
	private String silla;
	private String pasajero;
	private int estado;
	
	
	
	public ReservaDto(String vuelo, String silla, String pasajero, int estado) {
		super();
		this.vuelo = vuelo;
		this.silla = silla;
		this.pasajero = pasajero;
		this.estado = estado;
	}
	public String getVuelo() {
		return vuelo;
	}
	public void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}
	public String getSilla() {
		return silla;
	}
	public void setSilla(String silla) {
		this.silla = silla;
	}
	public String getPasajero() {
		return pasajero;
	}
	public void setPasajero(String pasajero) {
		this.pasajero = pasajero;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	
}
