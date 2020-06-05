package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Plato;
import pe.edu.upc.spring.repository.IPlatoRepository;
import pe.edu.upc.spring.service.IPlatoService;

@Service
public class PlatoServiceImpl implements IPlatoService {
	
	@Autowired
	private IPlatoRepository dPlato;
	
	@Override
	@Transactional
	public boolean insertar(Plato plato) {
		Plato objPlato = dPlato.save(plato);
		if( objPlato == null)
		    return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Plato plato) {
		boolean flag = false;
		try {
			dPlato.save(plato);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Ocurrio un error");
		}
		return flag;
   }
	@Override
	@Transactional
	public void eliminar(int idPlato) {
		dPlato.deleteById(idPlato);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Plato> listarId(int idPlato) {
		return dPlato.findById(idPlato);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Plato> listar() {
		
		return dPlato.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Plato> buscarNombre(String nombrePlato) {
		
		return dPlato.buscarNombre(nombrePlato);
	}

	
}
