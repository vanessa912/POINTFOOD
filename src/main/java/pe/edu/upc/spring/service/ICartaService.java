package pe.edu.upc.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Carta;

public interface ICartaService {
	public boolean insertar(Carta carta);
	public boolean modificar(Carta carta);
	public void eliminar(int idCarta);
	public Optional<Carta> listarId(int idCarta);
	List<Carta> listar();
	List<Carta> buscarFecha(Date fechaCarta);
}
