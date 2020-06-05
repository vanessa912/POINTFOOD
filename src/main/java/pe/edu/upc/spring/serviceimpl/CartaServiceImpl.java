package pe.edu.upc.spring.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Carta;
import pe.edu.upc.spring.repository.ICartaRepository;
import pe.edu.upc.spring.service.ICartaService;

@Service
public class CartaServiceImpl implements ICartaService {
	
	@Autowired
	private ICartaRepository dCarta;
	
	@Override
	@Transactional
	public boolean insertar(Carta carta) {
		Carta objCarta = dCarta.save(carta);
		if( objCarta == null)
		    return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Carta carta) {
		boolean flag = false;
		try {
			dCarta.save(carta);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Ocurrio un error");
		}
		return flag;
   }
	@Override
	@Transactional
	public void eliminar(int idCarta) {
		dCarta.deleteById(idCarta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Carta> listarId(int idCarta) {
		return dCarta.findById(idCarta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carta> listar() {
		
		return dCarta.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Carta> buscarFecha(Date fechaCarta) {
		
		return dCarta.buscarFecha(fechaCarta);
	}

	
}
