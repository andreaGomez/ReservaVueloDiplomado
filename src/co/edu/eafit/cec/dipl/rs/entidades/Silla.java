package co.edu.eafit.cec.dipl.rs.entidades;

public class Silla {

	private String id;
	//ojo mala practica
	//disponible = 1
	//no disponible = 2
	private int estado;
	private String categoria;
		
	public Silla() {
		
	}
	
	public Silla(String id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}


	public boolean estaDisponible() {
		return estado == 1;
	}


	public String getId() {
		return id;
	}


	public int getEstado() {
		return estado;
	}


	public String getCategoria() {
		return categoria;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void liberar() {
		this.estado = 1;
		
	}	

}
