package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.model.Mozo;
import pe.edu.upc.spring.model.Mesa;
import pe.edu.upc.spring.model.Reserva;
import pe.edu.upc.spring.service.IClienteService;
import pe.edu.upc.spring.service.IMozoService;
import pe.edu.upc.spring.service.IReservaService;
import pe.edu.upc.spring.service.IMesaService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private IReservaService rService;
	
	@Autowired
	private IClienteService cService;
	
	@Autowired
	private IMozoService mService;
	
	@Autowired
	private IMesaService mesaService;
	
	@RequestMapping("/")
	public String irPaginaListadoReservas(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReservas";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroReservas(Model model) {
		model.addAttribute("listaReservas", rService.listar());
		model.addAttribute("listaClientes", cService.listar());	
		model.addAttribute("listaMesa", mesaService.listar());
		model.addAttribute("listaMozos", mService.listar());	
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("mozo", new Mozo());
		model.addAttribute("mesa", new Mesa());
		return "reserva";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Reserva objReserva, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaReservas", rService.listar());
			model.addAttribute("listaClientes", cService.listar());		
			model.addAttribute("listaMozos", mService.listar());
			model.addAttribute("listaMesa", mesaService.listar());
			return "reserva";
		}
		else
		{
			boolean flag = rService.insertar(objReserva);
			if(flag) {
				return "redirect:/reserva/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/reserva/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<Reserva> objPet = rService.buscarId(id);
		
		if(objPet == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/reserva/listar";
		}
		else 
		{
			model.addAttribute("listaReservas", rService.listar());
			model.addAttribute("listaClientes", cService.listar());
			model.addAttribute("listaMozos", mService.listar());
			model.addAttribute("listaMesa", mesaService.listar());
			
			if (objPet.isPresent())
				objPet.ifPresent(o -> model.addAttribute("reserva", o));
			
			return "reserva";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				rService.eliminar(id);
				model.put("listaReservas", rService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaReservas", rService.listar());
		}
		return "listReservas";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReservas", rService.listar());
		return "listReservas";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Reserva reserva)
	throws ParseException{
		rService.listarId(reserva.getIdReserva());
		return "listReservas";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Cliente cliente)
	throws ParseException{
		List<Cliente> listaClientes;
		cliente.setNombreCliente(cliente.getNombreCliente());
		listaClientes = cService.buscarNombreCliente(cliente.getNombreCliente());
		
		if(listaClientes.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaReservas", listaClientes);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("reserva",new Reserva());
		return "buscar";
	}
	
}
