package co.edu.eafit.cec.dipl.rs.usercase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.eafit.cec.dipl.rs.entidades.Reserva;
import co.edu.eafit.cec.dipl.rs.entidades.Silla;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;

public class ConsultaReservaUseCase {
	List<Reserva> listaReservasQuemada = new ArrayList<Reserva>();	
	
	public Reserva obtenerReserva(String idReserva){
		listaReservasQuemada.add(new Reserva("FHRTWE", new Vuelo("F6909", "BOG", "MED", new Date(), 1), new Silla("A4", "EJECUTIVO"),"C3456"));
		listaReservasQuemada.add(new Reserva("AFOIRW", new Vuelo("G6909", "MDE", "BOG", new Date(), 1), new Silla("B4", "EJECUTIVO"),"C4567"));
		listaReservasQuemada.add(new Reserva("HUFGSW", new Vuelo("F6120", "AND", "MED", new Date(), 1), new Silla("G4", "EJECUTIVO"),"C1234"));
		listaReservasQuemada.add(new Reserva("NLJDJG", new Vuelo("R6209", "CAL", "BOG", new Date(), 1), new Silla("D4", "EJECUTIVO"),"C2345"));
		listaReservasQuemada.add(new Reserva("HRYBCV", new Vuelo("F6909", "BOG", "CAL", new Date(), 1), new Silla("A5", "EJECUTIVO"),"C5678"));
		listaReservasQuemada.add(new Reserva("MFDGWE", new Vuelo("F6909", "MDE", "BOG", new Date(), 1), new Silla("B5", "EJECUTIVO"),"C6789"));
		listaReservasQuemada.add(new Reserva("YURSDE", new Vuelo("F6909", "MDE", "BOG", new Date(), 1), new Silla("B6", "EJECUTIVO"),"C3650"));
		
		
		for(Reserva reserva: listaReservasQuemada) {
			if(idReserva.equalsIgnoreCase(reserva.getId())) {
				
				return reserva;
			}
		}
		return null;
	}

}
