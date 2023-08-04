package servicios;

import java.util.ArrayList;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import modelo.Ticket;
import modelo.Vehiculo;
import negocio.GestionTicket;
import negocio.GestionVehiculo;

@Path("tickets")
public class GTicketService {

	@Inject
	private GestionTicket gtickets;
	
	private List<Ticket> tickets = new ArrayList<>();
	
	@POST
    @Path("registrar")
    @Produces("application/json")
   public Response guardarTickets(Ticket ticket) {
        try {
        	gtickets.guardarTicket(ticket);
            return Response.status(Response.Status.OK).entity(ticket).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCodigo(99);
            error.setMensaje("Error al guardar: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(error).build();
        }
    }
	
	@GET
    @Path("listar")
    @Produces("application/json")
    public List<Ticket> listarTickets(){
        return gtickets.listarTickets();
    }
	
	@DELETE
    @Path("eliminar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response eliminarVehiculos(Ticket ticket) {
        try {
        	gtickets.delete(ticket.getCodigo());
            Error respuesta = new Error();
            respuesta.setCodigo(1);
            respuesta.setMensaje("Ticket eliminada correctamente.");
            return Response.status(Response.Status.OK).entity(respuesta).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error respuesta = new Error();
            respuesta.setCodigo(99);
            respuesta.setMensaje("Error al eliminar: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }
	
	@GET
    @Path("all")
    @Produces("application/json")
    public Response getTickets() {
        List<Ticket> listado = gtickets.listarTickets();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
	
	@PUT
    @Path("actualizar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response actualizarTicket(Ticket ticket) {
        try {
        	gtickets.actualizarTicket(ticket.getCodigo(), ticket.getHoraEntrada(), 
ticket.getHoraSalida(), ticket.getCliente(), ticket.getVehiculo());

            return Response.status(Response.Status.OK).entity(ticket).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error respuesta = new Error();
            respuesta.setCodigo(99);
            respuesta.setMensaje("Error al actualizar: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }
	
	
	
	
}
