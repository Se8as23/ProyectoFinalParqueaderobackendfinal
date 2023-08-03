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
import modelo.Vehiculo;
import negocio.GestionVehiculo;

@Path("vehiculo")
public class GVehiculoService {

	@Inject
	private GestionVehiculo gvehiculos;
	
	private List<Vehiculo> vehiculos = new ArrayList<>();
	
	
	@POST
    @Path("registrar")
    @Produces("application/json")
   public Response guardarVehiculos(Vehiculo vehiculo) {
        try {
            gvehiculos.guardarVehiculos(vehiculo);
            return Response.status(Response.Status.OK).entity(vehiculo).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCodigo(99);
            error.setMensaje("Error al guardar: " + e.getMessage());
            return Response.status(Response.Status.OK).entity(error).build();
        }
    }
	
	@GET
    @Path("listarVehiculos")
    @Produces("application/json")
    public List<Vehiculo> listarVehiculos() {
        return gvehiculos.listarVehiculos();
    }
	
	
	
	@DELETE
    @Path("eliminarVehiculos")
    @Consumes("application/json")
    @Produces("application/json")
    public Response eliminarVehiculos(Vehiculo vehiculo) {
        try {
            gvehiculos.delete(vehiculo.getCodigo());
            Error respuesta = new Error();
            respuesta.setCodigo(1);
            respuesta.setMensaje("Vehiculo eliminada correctamente.");
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
    public Response getVehiculos() {
        List<Vehiculo> listado = gvehiculos.listarVehiculos();
        
        return Response.status(Response.Status.OK).entity(listado).build();
    }
	
	@PUT
    @Path("actualizar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response actualizarVehiculoPorCedula(Vehiculo vehiculo) {
        try {
            gvehiculos.actualizarVehiculoPorCedula(vehiculo.getCodigo(), vehiculo.getPlaca(), 
            vehiculo.getModelo(), vehiculo.getMarca());

            return Response.status(Response.Status.OK).entity(vehiculo).build();
        } catch (Exception e) {
            e.printStackTrace();
            Error respuesta = new Error();
            respuesta.setCodigo(99);
            respuesta.setMensaje("Error al actualizar: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(respuesta).build();
        }
    }
}
