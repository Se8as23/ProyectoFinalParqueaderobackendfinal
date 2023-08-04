package servicios;

import java.sql.Date;
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
import modelo.Cliente;
import modelo.Factura;
import negocio.GestionClientes;
import negocio.GestionFactura;

@Path("Factura")
public class GFacturaService {


	@Inject
	private GestionFactura gfactura;
	
	private List<Factura> factura = new ArrayList<>();
	
	
	@POST
    @Path("registrar")
    @Produces("application/json")
   public Response guardarCliente(Factura factura) {
        try {
        	gfactura.guardarFacturas(factura);
            return Response.status(Response.Status.OK).entity(factura).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCodigo(99);
            error.setMensaje("Error al guardar: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(error).build();
        }
    }
	
	@GET
    @Path("listarFactura")
    @Produces("application/json")
    public List<Factura> listarFactura() {
        return gfactura.listarFactura();
    }
	
	
	
	@DELETE
    @Path("eliminar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response eliminarClientes(Factura factura) {
        try {
        	gfactura.delete(factura.getCodigo());
            Error respuesta = new Error();
            respuesta.setCodigo(1);
            respuesta.setMensaje("factura eliminada correctamente.");
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
    public Response getFactura() {
        List<Factura> listado = gfactura.listarFactura();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
	
	@PUT
    @Path("actualizar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response actualizarClientePorCedula(Factura factura) {
        try {
            gfactura.actualizar(factura.getCodigo(), (Date) factura.getFechaFactura(), 
            		factura.getTotal(), factura.getCliente(),factura.getTicket(),factura.getTarifa());

            return Response.status(Response.Status.OK).entity(factura).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error respuesta = new Error();
            respuesta.setCodigo(99);
            respuesta.setMensaje("Error al actualizar: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }
	
}
