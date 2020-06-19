package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Reserva;

public interface IReservaService {

	public boolean insertar(Reserva reserva);
	public boolean modificar(Reserva reserva);
	public void eliminar(int idReserva);
	public Optional<Reserva> buscarId(int idReserva);
	public Optional<Reserva> listarId(int idReserva);
	public List<Reserva> listar();
	
	public List<Reserva>buscarNombreCliente(String cliente);
	public List<Reserva>buscarNombreMozo(String nombreMozo);
	public List<Reserva>buscarZonaMesa(String zona);
	
	
}
