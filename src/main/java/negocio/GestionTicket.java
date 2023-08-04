package negocio;

import java.time.LocalTime;
import java.util.List;

import Dao.TicketDAO;
import Dao.VehiculoDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import modelo.Cliente;
import modelo.Ticket;
import modelo.Vehiculo;

@Stateless
public class GestionTicket {
	@Inject
	private TicketDAO daoTicket;
	
	public void guardarTicket(Ticket ticket) throws Exception {
		
		
		if(daoTicket.read(ticket.getCodigo()) == null) {
			try {
				daoTicket.insert(ticket);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoTicket.update(ticket);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public List<Ticket> listarTickets() {
		return daoTicket.getAll();
	 
	}
	
	public void delete(int codigo) {
		daoTicket.delete(codigo);
	    
    }
	
	public void actualizarTicket(int codigo ,LocalTime horaEntrada, LocalTime horaSalida,
            Cliente cliente, Vehiculo vehiculo) throws Exception {
        

        
        Ticket ticketExistente = daoTicket.getByCodigo(codigo);
        if (ticketExistente == null) {
            throw new EntityNotFoundException("No existe una persona con la cédula proporcionada.");
        }

        ticketExistente.setHoraEntrada(horaEntrada);
        ticketExistente.setHoraSalida(horaSalida);
        ticketExistente.setCliente(cliente);
        ticketExistente.setVehiculo(vehiculo);
        try {
        	daoTicket.update(ticketExistente);
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }
	
	
	
	
}
