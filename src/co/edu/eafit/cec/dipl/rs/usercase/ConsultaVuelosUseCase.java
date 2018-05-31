package co.edu.eafit.cec.dipl.rs.usercase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.eafit.cec.dipl.rs.dto.ConsultaVueloDto;
import co.edu.eafit.cec.dipl.rs.entidades.Silla;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;

public class ConsultaVuelosUseCase {
	List<Vuelo> listaVuelosQuemada = new ArrayList<Vuelo>();
	List<Silla> listaSillasQuemada = new ArrayList<Silla>();
	
	
		public List<Vuelo> obtenerVuelos(ConsultaVueloDto parametros){
			listaVuelosQuemada.add(new Vuelo("MDE", "BOG", new Date(15267060000l), listaSillasQuemada));
			listaVuelosQuemada.add(new Vuelo("MDE", "PER", new Date(15267060000l), listaSillasQuemada));
			listaVuelosQuemada.add(new Vuelo("MDE", "MTR", new Date(15267060000l), listaSillasQuemada));
			listaVuelosQuemada.add(new Vuelo("BOG", "MDE", new Date(15267060000l), listaSillasQuemada));
			listaVuelosQuemada.add(new Vuelo("AND", "MTR", new Date(15267060000l), listaSillasQuemada));
			listaVuelosQuemada.add(new Vuelo("MDE", "SMR", new Date(15267060000l), listaSillasQuemada));
			
			List<Vuelo> listaVuelosFiltrada = new ArrayList<Vuelo>();

			for(Vuelo vuelo: listaVuelosQuemada) {
				if(parametros.getDestino().equals(vuelo.getDestino()) && parametros.getOrigen().equals(vuelo.getOrigen())  && parametros.getFecha().equals(vuelo.getFecha())) {
					
					listaVuelosFiltrada.add(vuelo);
				}
			}
			return listaVuelosFiltrada;
		}
		
		
		

}
