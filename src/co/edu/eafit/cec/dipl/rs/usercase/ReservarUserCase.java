package co.edu.eafit.cec.dipl.rs.usercase;

import co.edu.eafit.cec.dipl.rs.dto.ReservaDto;
import co.edu.eafit.cec.dipl.rs.entidades.Reserva;
import co.edu.eafit.cec.dipl.rs.entidades.Silla;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;

public class ReservarUserCase {
	//las buenas practicas de diseño dicen que los metodos siempre deben retornar algo, por ello retornaremos el ID de la reserva
	//la idea es que pudieramos mandar la url con el recurso creado para que sea hipermediado
	public String ejecutar(ReservaDto parametros) {
		//TODO: Buscar el vuelo
		//TODO: Buscar si el pasajero existe
		//TODO: Buscar si la silla continua disponible
		Vuelo vuelo = new Vuelo(parametros.getVuelo());
		Silla silla = new Silla(parametros.getSilla(), "TURISTA");
		
		Reserva reserva = new Reserva(vuelo, silla, parametros.getPasajero());
		return reserva.getId();
	}

}
