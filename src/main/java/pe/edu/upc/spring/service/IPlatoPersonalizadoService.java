package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.PlatoPersonalizado;

public interface IPlatoPersonalizadoService {

	public boolean insertar(PlatoPersonalizado platopersonalizado);
	public boolean modificar(PlatoPersonalizado platopersonalizado);
	public void eliminar(int idPlatoPersonalizado);
	public Optional<PlatoPersonalizado> buscarId(int idPlatoPersonalizado);
	public List<PlatoPersonalizado> listar();
	public List<PlatoPersonalizado> buscarNombrePlato(String nombrePlato);
	public List<PlatoPersonalizado> buscarIngrediente(String nombreIngrediente);
	public List<PlatoPersonalizado> buscarPrecioIngrediente(double precioIngrediente);
}
