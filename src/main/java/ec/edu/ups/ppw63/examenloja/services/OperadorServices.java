package ec.edu.ups.ppw63.examenloja.services;

import java.util.List;

import ec.edu.ups.ppw63.examenloja.business.GestionOperador;
import ec.edu.ups.ppw63.examenloja.model.Operador;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("operadores")
public class OperadorServices {
	
	@Inject
	private GestionOperador gOperador;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Operador operador) {
		try {
			gOperador.guardarOperadors(operador); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(operador).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getOperadors(){
		List<Operador> operadores = gOperador.getOperadors();
		if(operadores.size()>0)
			return Response.ok(operadores).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran operadores");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
