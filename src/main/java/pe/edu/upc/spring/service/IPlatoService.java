package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Plato;

public interface IPlatoService {
	public boolean insertar(Plato plato);
	public boolean modificar(Plato plato);
	public void eliminar(int idPlato);
	public Optional<Plato> listarId(int idPlato);
	List<Plato> listar();
	List<Plato> buscarNombre(String nombrePlato);
}
