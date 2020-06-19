package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Ingrediente;
import pe.edu.upc.spring.repository.IIngredienteRepository;
import pe.edu.upc.spring.service.IIngredienteService;

@Service
public class IngredienteServiceImpl implements IIngredienteService {

	@Autowired
	private IIngredienteRepository dIngrediente;

	
	@Override
	@Transactional
	public boolean insertar(Ingrediente ingrediente) {
		Ingrediente objIngrediente = dIngrediente.save(ingrediente);
		if( objIngrediente == null)
		    return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Ingrediente ingrediente) {
		boolean flag = false;
		try {
			dIngrediente.save(ingrediente);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Ocurrio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idIngrediente) {
		dIngrediente.deleteById(idIngrediente);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Ingrediente> listarId(int idIngrediente) {
		return dIngrediente.findById(idIngrediente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ingrediente> listar() {
		return dIngrediente.findAll();
	}

	@Override
	@Transactional
	public List<Ingrediente> buscarNombre(String nombreIngrediente) {
		return dIngrediente.buscarNombre(nombreIngrediente);
	}

}
