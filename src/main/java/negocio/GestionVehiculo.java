package negocio;

import java.util.List;

import Dao.VehiculoDAO;
import Dao.VehiculoDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import modelo.Vehiculo;
import modelo.Sitio;
import modelo.Tarifa;
import modelo.Ticket;

@Stateless
public class GestionVehiculo {

private Sitio s;
	
	
	private Tarifa ta;
	
	
	private Ticket t;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void guardarVehiculos(Vehiculo vehiculo) throws Exception {
		
		
		if(daoVehiculo.read(vehiculo.getCodigo()) == null) {
			try {
				daoVehiculo.insert(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoVehiculo.update(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	
	
	
	public List<Vehiculo> listarVehiculos() {
		return daoVehiculo.getAll();
	 
	}
	    
    public void delete(int codigo) {
    	daoVehiculo.delete(codigo);
	    
    }
	    
    public void actualizarVehiculoPorCedula(int codigo ,String placa, String modelo,
            String marca) throws Exception {
        

        
        Vehiculo vehiculoExistente = daoVehiculo.getByCodigo(codigo);
        if (vehiculoExistente == null) {
            throw new EntityNotFoundException("No existe una persona con la cédula proporcionada.");
        }

        vehiculoExistente.setPlaca(placa);
        vehiculoExistente.setModelo(modelo);
        vehiculoExistente.setMarca(marca);
        try {
            daoVehiculo.update(vehiculoExistente);
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }
	
	}
