package co.edu.eafit.cec.dipl.rs.dto;

import java.util.Date;

public class ConsultaVueloDto {
	private String destino;
	private String origen;
	private Date fecha;
	
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

}
