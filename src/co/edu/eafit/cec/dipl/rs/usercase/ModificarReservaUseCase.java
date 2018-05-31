package co.edu.eafit.cec.dipl.rs.usercase;

import java.util.ArrayList;
import java.util.List;

import co.edu.eafit.cec.dipl.rs.entidades.Reserva;
import co.edu.eafit.cec.dipl.rs.entidades.Silla;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;

public class ModificarReservaUseCase {
	List<Reserva> listaReservasQuemada = new ArrayList<Reserva>();	
	
	public int ejecutar(String idReserva, Reserva reservaModificada){
		listaReservasQuemada.add(new Reserva("FHRTWE", new Vuelo("F6909"), new Silla("A4", "EJECUTIVO"),"C3456"));
		listaReservasQuemada.add(new Reserva("AFOIRW", new Vuelo("G6909"), new Silla("B4", "EJECUTIVO"),"C4567"));
		listaReservasQuemada.add(new Reserva("HUFGSW", new Vuelo("F6120"), new Silla("G4", "EJECUTIVO"),"C1234"));
		listaReservasQuemada.add(new Reserva("NLJDJG", new Vuelo("R6209"), new Silla("D4", "EJECUTIVO"),"C2345"));
		listaReservasQuemada.add(new Reserva("HRYBCV", new Vuelo("F6909"), new Silla("A5", "EJECUTIVO"),"C5678"));
		listaReservasQuemada.add(new Reserva("MFDGWE", new Vuelo("F6909"), new Silla("B5", "EJECUTIVO"),"C6789"));
		listaReservasQuemada.add(new Reserva("YURSDE", new Vuelo("F6909"), new Silla("B6", "EJECUTIVO"),"C3650"));
		
		
		for(Reserva reserva: listaReservasQuemada) {
			if(idReserva.equalsIgnoreCase(reserva.getId())) {
				reserva.modificar(reservaModificada);
				return reserva.getEstado();
			}
		}
		return -1;
	}

}
