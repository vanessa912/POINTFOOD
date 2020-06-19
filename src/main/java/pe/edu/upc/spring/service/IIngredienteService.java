package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Ingrediente;

public interface IIngredienteService {

	public boolean insertar(Ingrediente ingrediente);
	public boolean modificar(Ingrediente ingrediente);
	public void eliminar(int idIngrediente);
	public Optional<Ingrediente> listarId(int idIngrediente);
	List<Ingrediente> listar();
	List<Ingrediente> buscarNombre(String nombreIngrediente);
}
