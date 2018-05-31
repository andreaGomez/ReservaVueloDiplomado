package co.edu.eafit.cec.dipl.rs;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import co.edu.eafit.cec.dipl.rs.dto.ConsultaVueloDto;
import co.edu.eafit.cec.dipl.rs.dto.ReservaDto;
import co.edu.eafit.cec.dipl.rs.entidades.Reserva;
import co.edu.eafit.cec.dipl.rs.entidades.Vuelo;
import co.edu.eafit.cec.dipl.rs.usercase.CancelarReservaUseCase;
import co.edu.eafit.cec.dipl.rs.usercase.ConsultaReservaUseCase;
import co.edu.eafit.cec.dipl.rs.usercase.ConsultaVuelosUseCase;
import co.edu.eafit.cec.dipl.rs.usercase.ModificarReservaUseCase;
import co.edu.eafit.cec.dipl.rs.usercase.ReservarUserCase;
import sun.misc.BASE64Decoder;

@Path("/rest")
public class ReservaService {

	@Path("/vuelos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vuelo> getVuelos(@Context UriInfo info) {
		MultivaluedMap<String, String> queryString = info.getQueryParameters();
		
		String origen = (String)queryString.getFirst("origen");
		String destino = (String)queryString.getFirst("destino");
		String fecha = (String)queryString.getFirst("fecha");
		
		System.out.println("buscando origen " + origen);
		System.out.println("buscando destino " + destino);
		System.out.println("buscando fecha " + fecha);
		
		ConsultaVueloDto parametros = new ConsultaVueloDto();
		parametros.setDestino(destino);
		parametros.setFecha(new Date(15267060000l));
		parametros.setOrigen(origen);
		
		ConsultaVuelosUseCase consultaVuelosUseCase = new ConsultaVuelosUseCase();
		List<Vuelo> resultado = consultaVuelosUseCase.obtenerVuelos(parametros);
		return resultado;
		//return "{'id':'1'}";
	}
	
	@Path("/vuelos")
	@GET
	@Produces("co.edu.eafit.diplomadoV2+text/plain")//asi lo puedo usar para versionar y en soapUI pongo un parametro
	//de tipo HEADER con la ruta co.edu.eafit.diplomadoV2+text/plain
	public String getVuelos() {
		return "HOLA MUNDO";
	}
	
	@POST
	@Path("/reservas")	
	@Consumes("co.edu.eafit.diplomadoV2+application/json")
	@Produces("co.edu.eafit.diplomadoV2+application/json")
	public Response crearReserva(ReservaDto datos) {
		ReservarUserCase casoUso = new ReservarUserCase();
		String idTransaccion = casoUso.ejecutar(datos);
		URI uri = null;
		try {
			uri = new URI("http://localhost:8080/ReservaVuelos/api/rest/vuelos/"+idTransaccion);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return Response.created(uri).build();	
		
	}
	
	
	//aqui vamos a usar seguridad
	@GET
	@Path("/seguridad")
	@Produces("application/json")
	public Response obtenerReservas(@HeaderParam("Authorization") String authorization) {
		String[] authData = authorization.split(" ");
		String base64 = authData[1];
		
		try {
			byte[] bytes = new BASE64Decoder().decodeBuffer(base64);
//			new BASE64Decoder().decodeBuffer(base64);
			String datos = new String(bytes);
			String[] datosPartidos = datos.split(":");
			
			if(datosPartidos[0].equals("andrgoal") && datosPartidos[1].equals("andrgoal")){
				//TODO: EJECUTAR EL CASO DE USO
			}else {
				Response.status(401).build();
			}		
		}catch(IOException e) {
			e.printStackTrace();
		}
		return Response.ok().build();		
		//return Response.status(401).header("www.Authorization", "Basic\"EAFIT\"").build();
	}
	
	
	@GET
	@Path("/reservas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reserva getReserva(@PathParam("id") String idReserva) {		
		
		System.out.println("buscando idReserva " + idReserva);				
				
		ConsultaReservaUseCase consultaReservasUseCase = new ConsultaReservaUseCase();
		Reserva resultado = consultaReservasUseCase.obtenerReserva(idReserva);
		return resultado;
	}
	
	@PATCH
	@Path("/reservas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelarReserva(@PathParam("id") String idReserva) {		
				
		CancelarReservaUseCase cancelarReservaUseCase = new CancelarReservaUseCase();
		int resultado = cancelarReservaUseCase.ejecutar(idReserva);		
	
		if(resultado >= 0) {
			return Response.ok("Reserva cancelada").build();
		}else {
			return Response.notModified("No se encontro el codigo de reserva a cancelar").build();
		}		
	}
	
	@PUT
	@Path("/reservas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response modificarReserva(@PathParam("id") String idReserva, Reserva reserva) {
						
		ModificarReservaUseCase modificarReservaUseCase = new ModificarReservaUseCase();
		int resultado = modificarReservaUseCase.ejecutar(idReserva, reserva);
		
		if(resultado < 0) {
			return Response.notModified("No se encontro el codigo de reserva a modificar").build();			
		}else {
			return Response.ok("Reserva modificada").build();
		}		
	}
}
