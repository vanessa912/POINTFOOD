package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.DetallePlatoReserva;


import pe.edu.upc.spring.repository.IDetallePlatoReservaRepository;
import pe.edu.upc.spring.service.IDetallePlatoReservaService;

@Service
public class DetallePlatoReservaImpl implements IDetallePlatoReservaService{

	@Autowired
	private IDetallePlatoReservaRepository dPlatoReserva;
	
	@Override
	@Transactional
	public boolean insertar(DetallePlatoReserva detalleplatoreserva) {
		DetallePlatoReserva objDetallePlatoReserva = dPlatoReserva.save(detalleplatoreserva);
		if (objDetallePlatoReserva!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(DetallePlatoReserva detalleplatoreserva) {
		boolean flag = false;
		try {
			dPlatoReserva.save(detalleplatoreserva);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int Iddetalleplatoreserva) {
		dPlatoReserva.deleteById(Iddetalleplatoreserva);
		
	}

	@Override
	public Optional<DetallePlatoReserva> buscarId(int Iddetalleplatoreserva) {
		return dPlatoReserva.findById(Iddetalleplatoreserva);
	}

	@Override
	public Optional<DetallePlatoReserva> listarId(int Iddetalleplatoreserva) {
		return dPlatoReserva.findById(Iddetalleplatoreserva);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DetallePlatoReserva> listar() {
		return dPlatoReserva.findAll();
	}

	@Override
	public List<DetallePlatoReserva> buscarNombrePlato(String nombrePlato) {
		return dPlatoReserva.buscarNombrePlato(nombrePlato);
	}

	@Override
	public List<DetallePlatoReserva> buscarPrecioPlato(double precioPlato) {
		return dPlatoReserva.buscarprecioPlato(precioPlato);
	}

	@Override
	public List<DetallePlatoReserva> buscarIdReserva(int Iddetalleplatoreserva) {
		return dPlatoReserva.buscarIdReserva(Iddetalleplatoreserva);
	}



}
