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

import pe.edu.upc.spring.model.Plato;
import pe.edu.upc.spring.service.IPlatoService;



@Controller
@RequestMapping("/plato")
public class PlatoController {
	
	@Autowired
	   private IPlatoService pService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoPlato(Map<String, Object>model) {
		   model.put("listaPlato", pService.listar());
		   return "listPlato";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("plato", new Plato());
		   return "plato";
	   }
	   
	   @RequestMapping("/registrar")
	   public String registrar(@ModelAttribute @Valid Plato ObjPlato, BindingResult binRes, Model model)
	   throws ParseException
	   {
		   if(binRes.hasErrors())
			   return "plato";
		   else
		   {
			   boolean flag = pService.insertar(ObjPlato);
			   if(flag) {
				   return "redirect:/plato/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un error");
				   return "redirect:/plato/irRegistrar";
			   }
		   }
		 
	   }
	   
	   @RequestMapping("/modificar/{id}")
	   public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	   throws ParseException
	 {
		   Optional<Plato> ObjPlato = pService.listarId(id);
		   if(ObjPlato == null) {
			   objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			   return "redirect:/plato/listar";
		   }
		   else {
			   model.addAttribute("plato", ObjPlato);
			   return "plato";
		   }
	 }
	   @RequestMapping("/actualizar")
	   public String actualizar(@ModelAttribute @Valid Plato ObjPlato, BindingResult binRes,Model model, 
		   RedirectAttributes objRedir) 
	   throws ParseException
	   {
		   if (binRes.hasErrors()) {
			   return "redirect:/plato/listar";
		   }
		   else {
			   boolean flag = pService.modificar(ObjPlato);
			   if(flag) {
				   objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				   return "redirect:/plato/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un roche");
				   return "redirect:/plato/irRegistrar";
			   }
		   }
	   }
	   
	   @RequestMapping("/eliminar")
	   public String eliminar (Map<String, Object>model, @RequestParam(value= "id")Integer id) {
		   try {
			   if(id!= null && id>0) {
				   pService.eliminar(id);
				   model.put("listaPlato", pService.listar());
			   }
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   model.put("mensaje","Ocurrio un error");
			   model.put("listarPlato", pService.listar());
		   }
		   return "listPlato";
	   }
	   
	   @RequestMapping("/listar")
	   public String listar(Map<String, Object>model) {
		   model.put("listarPlato",  pService.listar());
		   return "listPlato";
	   }

}
