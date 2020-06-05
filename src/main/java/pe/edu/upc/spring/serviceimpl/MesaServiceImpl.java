package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Mesa;

import pe.edu.upc.spring.repository.IMesaRepository;
import pe.edu.upc.spring.service.IMesaService;

public class MesaServiceImpl implements IMesaService {
	@Autowired
	private IMesaRepository dMesa;
	
	@Override
	@Transactional
	public boolean insertar(Mesa mesa) {
		Mesa objMesa = dMesa.save(mesa);
		if( objMesa == null)
		    return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Mesa mesa) {
		boolean flag = false;
		try {
			dMesa.save(mesa);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Ocurrio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMesa) {
		dMesa.deleteById(idMesa);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mesa> listarId(int idMesa) {
		return dMesa.findById(idMesa);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mesa> listar() {
		
		return dMesa.findAll();
	}


}
