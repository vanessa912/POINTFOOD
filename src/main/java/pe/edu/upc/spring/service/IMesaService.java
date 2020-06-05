package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Mesa;


public interface IMesaService {
	public boolean insertar(Mesa mesa);
	public boolean modificar(Mesa mesa);
	public void eliminar(int idMesa);
	public Optional<Mesa> listarId(int idMesa);
	List<Mesa> listar();
}
