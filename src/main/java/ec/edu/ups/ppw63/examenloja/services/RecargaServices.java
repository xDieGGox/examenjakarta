package ec.edu.ups.ppw63.examenloja.services;


import java.util.List;

import ec.edu.ups.ppw63.examenloja.business.GestionRecargas;
import ec.edu.ups.ppw63.examenloja.model.Recarga;
import ec.edu.ups.ppw63.examenloja.model.Recargarecibo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServices {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recargarecibo recargarecibo) {
		try {
			gRecargas.guardarRecargas(recargarecibo); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(cliente).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)//INTERNAL_SERVER_ERROR
					.entity(error)
					.build();
		}
		
		
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Recarga> recargas = gRecargas.getRecargas();
		if(recargas.size()>0)
			return Response.ok(recargas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran recargas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
