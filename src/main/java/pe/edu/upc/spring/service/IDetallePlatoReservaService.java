package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.DetallePlatoReserva;



public interface IDetallePlatoReservaService {


	public boolean insertar(DetallePlatoReserva detalleplatoreserva);
	public boolean modificar(DetallePlatoReserva detalleplatoreserva);
	public void eliminar(int Iddetalleplatoreserva);
	public Optional<DetallePlatoReserva> buscarId(int Iddetalleplatoreserva);
	public Optional<DetallePlatoReserva> listarId(int Iddetalleplatoreserva);
	public List<DetallePlatoReserva> listar();
	
	public List<DetallePlatoReserva> buscarNombrePlato(String nombrePlato);
	public List<DetallePlatoReserva>buscarPrecioPlato(double precioPlato);
	public List<DetallePlatoReserva>buscarIdReserva(int Iddetalleplatoreserva);
	
}
