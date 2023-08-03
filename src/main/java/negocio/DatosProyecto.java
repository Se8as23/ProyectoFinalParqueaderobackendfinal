package negocio;

import java.util.Date;
import java.util.List;

import Dao.ClienteDAO;
import Dao.FacturaDAO;
import Dao.SitioDAO;
import Dao.TarifaDAO;
import Dao.TicketDAO;
import Dao.VehiculoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.Factura;
import modelo.Sitio;
import modelo.Tarifa;
import modelo.Ticket;
import modelo.Vehiculo;

@Singleton
@Startup
public class DatosProyecto {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private TarifaDAO daoTarifa;
	
	@Inject
	private SitioDAO daoSitio;
	
	@Inject
	private TicketDAO daoTicket;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@PostConstruct
	public void init() {
		
		
		/*
		
		List<Cliente> clientes = daoCliente.getAll();
		for(Cliente cli: clientes){
			System.out.println(cli);
		}

		List<Vehiculo> vehiculos = daoVehiculo.getAll();
		for(Vehiculo veh: vehiculos){
			System.out.println(veh);
		}
		
		List<Sitio> sitio = daoSitio.getAll();
		for(Sitio sit: sitio){
			System.out.println(sit);
		}
		
		List<Ticket> tickets= daoTicket.getAll();
		for(Ticket tic: tickets){
			System.out.println(tic);
		}
		
		List<Tarifa> tarifa = daoTarifa.getAll();
		for(Tarifa tar: tarifa){
			System.out.println(tar);
		}
		
		List<Factura> factura = daoFactura.getAll();
		for(Factura fac: factura){
			System.out.println(fac);
		}
		*/
	}
}
