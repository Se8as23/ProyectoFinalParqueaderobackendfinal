package negocio;

import java.sql.Date;
import java.util.List;

import Dao.FacturaDAO;
import Dao.VehiculoDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import modelo.Cliente;
import modelo.Factura;
import modelo.Tarifa;
import modelo.Ticket;
import modelo.Vehiculo;

@Stateless
public class GestionFactura {

	
	@Inject
	private FacturaDAO daoFactura;
	
	public void guardarFacturas(Factura factura) throws Exception {
		
		
		if(daoFactura.read(factura.getCodigo()) == null) {
			try {
				daoFactura.insert(factura);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoFactura.update(factura);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	
	
	
	public List<Factura> listarFactura() {
		return daoFactura.getAll();
	 
	}
	    
    public void delete(int codigo) {
    	daoFactura.delete(codigo);
	    
    }
	    
    public void actualizar(int codigo ,Date fechaFactura, float total,
            Cliente cliente, Ticket ticket, Tarifa tarifa) throws Exception {
        

        
    	Factura facturaExistente = daoFactura.getByCodigo(codigo);
        if (facturaExistente == null) {
            throw new EntityNotFoundException("No existe una persona con la cédula proporcionada.");
        }

        facturaExistente.setCodigo(codigo);
        facturaExistente.setFechaFactura(fechaFactura);
        facturaExistente.setCliente(cliente);
        facturaExistente.setTicket(ticket);
        facturaExistente.setTotal(total);
        facturaExistente.setTarifa(tarifa);
        try {
            daoFactura.update(facturaExistente);
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }
}
