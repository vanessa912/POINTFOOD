package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Reserva;
import pe.edu.upc.spring.repository.IReservaRepository;
import pe.edu.upc.spring.service.IReservaService;

@Service
public class ReservaServiceImpl implements IReservaService{

	@Autowired
	private IReservaRepository dReserva;
	
	@Override
	@Transactional
	public boolean insertar(Reserva reserva) {
		Reserva objReserva = dReserva.save(reserva);
		if (objReserva!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Reserva reserva) {
		boolean flag = false;
		try {
			dReserva.save(reserva);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReserva) {
		dReserva.deleteById(idReserva);
		
	}

	@Override
	public Optional<Reserva> buscarId(int idReserva) {
		return dReserva.findById(idReserva);
	}

	@Override
	public Optional<Reserva> listarId(int idReserva) {
		return dReserva.findById(idReserva);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Reserva> listar() {
		return dReserva.findAll();
	}

	
	@Override
	@Transactional
	public List<Reserva> buscarNombreMozo(String nombreMozo) {
		return dReserva.buscarNombreMozo(nombreMozo);
	}

	@Override
	@Transactional
	public List<Reserva> buscarZonaMesa(String zona) {
		return dReserva.buscarZonaMesa(zona);
	}

	@Override
	public List<Reserva> buscarNombreCliente(String nombreCliente) {
		return dReserva.buscarNombreCliente(nombreCliente);
	}

	

}
