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

import pe.edu.upc.spring.model.Ingrediente;
import pe.edu.upc.spring.service.IIngredienteService;

@Controller
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IIngredienteService iService;
	
	@RequestMapping("/bienvenido")
	public String irIngredienteBienvenido() {
		
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irIngrediente(Map<String, Object>model) {
		model.put("listaIngredientes", iService.listar());
		return "listIngrediente";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "ingrediente";
		
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Ingrediente objIngrediente, BindingResult binRes, Model model)
	throws ParseException
	{
		if (binRes.hasErrors())
			return "ingrediente";
		else 
		{
			boolean flag = iService.insertar(objIngrediente);
			if (flag) {
				return "redirect:/ingrediente/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un roche");
				return "redirect:/ingrediente/irRegistrar";
			}
		}
	}
	
	
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
	throws ParseException
	{
		Optional<Ingrediente> objIngrediente = iService.listarId(id);
		if (objIngrediente == null ) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un roche");
			return "redirect:/ingrediente/listar";
		}
		else {
			model.addAttribute("ingrediente", objIngrediente);
			return "ingrediente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id")Integer id) {
		try {
			if(id!=null&&id>0)
			{
				iService.eliminar(id);
				model.put("listaIngredientes", iService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaIngredientes", iService.listar());
		}
		return "listIngrediente";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaIngredientes", iService.listar());
		return "listIngrediente";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Ingrediente Ingrediente)
	throws ParseException{
		iService.listarId(Ingrediente.getIdIngrediente());
		return "listIngrediente";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Ingrediente Ingrediente)
	throws ParseException{
		List<Ingrediente>listaIngredientes;
		Ingrediente.setNombreIngrediente(Ingrediente.getNombreIngrediente());
		listaIngredientes=iService.buscarNombre(Ingrediente.getNombreIngrediente());
		
		if(listaIngredientes.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaIngredientes", listaIngredientes);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("ingrediente",new Ingrediente());
		return "buscar";
	}

}
