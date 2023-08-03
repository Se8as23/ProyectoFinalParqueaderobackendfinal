package negocio;


import java.util.Date;
import java.util.List;
import Dao.ClienteDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import modelo.Cliente;
import modelo.Ticket;
import modelo.Sitio;
import modelo.Tarifa;
@Stateless
public class GestionClientes {
	
	 
	private Sitio s;
	
	
	private Tarifa ta;
	
	
	private Ticket t;
	
	@Inject
	private ClienteDAO daoCliente;
	
	public void guardarClientes(Cliente cliente) throws Exception {
		if(!this.isCedulaValida(cliente.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoCliente.read(cliente.getCodigo()) == null) {
			try {
				daoCliente.insert(cliente);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoCliente.update(cliente);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length()==10;
	}
	public void guardarClientes(String cedula, String nombre, String apellido, String direccion, String telefono) {
	       // Implementa la lógica para guardar un cliente utilizando los parámetros proporcionados
    }
	
	public List<Cliente> listarClientes() {
		return daoCliente.getAll();
	 
	}
	    
    public void delete(int codigo) {
    	daoCliente.delete(codigo);
	    
    }
	    
    public void actualizarClientePorCedula(String cedula, String nombre,
            String direccion, String telefono) throws Exception {
        if (!isCedulaValida(cedula)) {
            throw new Exception("Cedula incorrecta");
        }

        
        Cliente personaExistente = daoCliente.getByCedula(cedula);
        if (personaExistente == null) {
            throw new EntityNotFoundException("No existe una persona con la cédula proporcionada.");
        }

        personaExistente.setNombre(nombre);
        personaExistente.setDireccion(direccion);
        personaExistente.setTelefono(telefono);
        try {
            daoCliente.update(personaExistente);
        } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }
	
	}
	
	
	

