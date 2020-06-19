package pe.edu.upc.spring.controller;

import java.text.ParseException;
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
import pe.edu.upc.spring.model.Plato;
import pe.edu.upc.spring.model.PlatoPersonalizado;
import pe.edu.upc.spring.service.IIngredienteService;
import pe.edu.upc.spring.service.IPlatoPersonalizadoService;
import pe.edu.upc.spring.service.IPlatoService;

@Controller
@RequestMapping("/platopersonalizado")
public class PlatoPersonalizadoController {

	@Autowired
	private IPlatoPersonalizadoService pPService;
	
	@Autowired
	private IIngredienteService dIngrediente;
	
	@Autowired
	private IPlatoService pService;
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroPlatoPersonalizado(Model model) {
		model.addAttribute("listaIngredientes", dIngrediente.listar());	
		model.addAttribute("listaPreciosIngrediente", dIngrediente.listar());	
		model.addAttribute("ingrediente", new Ingrediente());
		model.addAttribute("plato", new Plato());
		model.addAttribute("platopersonalizado", new PlatoPersonalizado());
		return "platopersonalizado";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid PlatoPersonalizado objPlatoPersonalizado, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors()) 
		{
			model.addAttribute("listaIngredientes", dIngrediente.listar());	
			model.addAttribute("listapreciosingrediente", dIngrediente.listar());	
			return "platopersonalizado";
		}
		else
		{
			boolean flag = pPService.insertar(objPlatoPersonalizado);
			if(flag) {
				return "redirect:/platopersonalizado/listar";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un roche");
				return "redirect:/platopersonalizado/irRegistrar";
			}
		}
	}
		
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		
		Optional<PlatoPersonalizado> objPlatoPersonalizado = pPService.buscarId(id);
		
		if(objPlatoPersonalizado == null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/platopersonalizado/listar";
		}
		else 
		{
			model.addAttribute("listaIngredientes", dIngrediente.listar());
			
			if (objPlatoPersonalizado.isPresent())
				objPlatoPersonalizado.ifPresent(o -> model.addAttribute("platopersonalizado", o));
			
			return "platopersonalizado";
		}		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0)
			{
				pPService.eliminar(id);
				model.put("listaPlatosPersonalizados", pPService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaPlatosPersonalizados", pPService.listar());
		}
		return "listpPersonalizados";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPlatosPersonalizados", pPService.listar());
		return "listpPersonalizados";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute PlatoPersonalizado platopersonalizado)
	throws ParseException{
		pService.listarId(platopersonalizado.getPlatoPersonalizado());
		return "listpPersonalizados";
	}
	
}
	
	
	
	
	
	
	
