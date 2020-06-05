package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Mozo;
import pe.edu.upc.spring.repository.IMozoRepository;
import pe.edu.upc.spring.service.IMozoService;

@Service
public class MozoServiceImpl implements IMozoService {

	@Autowired
	private IMozoRepository dMozo;
	
	@Override
	@Transactional
	public boolean insertar(Mozo mozo) {
		Mozo objMozo = dMozo.save(mozo);
		if( objMozo == null)
		    return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Mozo mozo) {
		boolean flag = false;
		try {
			dMozo.save(mozo);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Ocurrio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMozo) {
		dMozo.deleteById(idMozo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mozo> listarId(int idMozo) {
		return dMozo.findById(idMozo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mozo> listar() {
		
		return dMozo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mozo> buscarNombre(String nombreMozo) {
		
		return dMozo.buscarNombre(nombreMozo);
	}

}
