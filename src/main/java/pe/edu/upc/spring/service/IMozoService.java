package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Mozo;

public interface IMozoService {
	public boolean insertar(Mozo mozo);
	public boolean modificar(Mozo mozo);
	public void eliminar(int idMozo);
	public Optional<Mozo> listarId(int idMozo);
	List<Mozo> listar();
	List<Mozo> buscarNombre(String nombreMozo);

}
