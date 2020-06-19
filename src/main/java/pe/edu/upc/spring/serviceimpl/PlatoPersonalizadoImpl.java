package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.PlatoPersonalizado;
import pe.edu.upc.spring.repository.IPlatoPersonalizadoRepository;
import pe.edu.upc.spring.service.IPlatoPersonalizadoService;

@Service
public class PlatoPersonalizadoImpl implements IPlatoPersonalizadoService {

	@Autowired
	private IPlatoPersonalizadoRepository dPlatoPersonalizado;
	
	@Override
	@Transactional
	public boolean insertar(PlatoPersonalizado platopersonalizado) {
		PlatoPersonalizado objPlatoPersonalizado = dPlatoPersonalizado.save(platopersonalizado);
		if (objPlatoPersonalizado !=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(PlatoPersonalizado platopersonalizado) {
		boolean flag = false;
		try {
			dPlatoPersonalizado.save(platopersonalizado);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPlatoPersonalizado) {
		dPlatoPersonalizado.deleteById(idPlatoPersonalizado);
	}

	@Override
	public Optional<PlatoPersonalizado> buscarId(int idPlatoPersonalizado) {
		return dPlatoPersonalizado.findById(idPlatoPersonalizado);
		}
	@Override
	@Transactional(readOnly=true)
	public List<PlatoPersonalizado> listar() {
		return dPlatoPersonalizado.findAll();
	}
	
	@Override
	@Transactional
	public List<PlatoPersonalizado> buscarNombrePlato(String nombrePlato) {
		return dPlatoPersonalizado.buscarNombrePlato(nombrePlato);
	}

	@Override
	@Transactional
	public List<PlatoPersonalizado> buscarIngrediente(String nombreIngrediente) {
		return dPlatoPersonalizado.buscarIngrediente(nombreIngrediente);
	}

	@Override
	@Transactional
	public List<PlatoPersonalizado> buscarPrecioIngrediente(double precioIngrediente) {
		return dPlatoPersonalizado.buscarPrecioIngrediente(precioIngrediente);
	}

}
