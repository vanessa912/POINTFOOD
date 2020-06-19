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

import pe.edu.upc.spring.model.Carta;
import pe.edu.upc.spring.service.ICartaService;



@Controller
@RequestMapping("/carta")
public class CartaController {
	
	@Autowired
	   private ICartaService cService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoPlato(Map<String, Object>model) {
		   model.put("listaCarta", cService.listar());
		   return "listCarta";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("carta", new Carta());
		   return "carta";
	   }
	   
	   @RequestMapping("/registrar")
	   public String registrar(@ModelAttribute @Valid Carta ObjCarta, BindingResult binRes, Model model)
	   throws ParseException
	   {
		   if(binRes.hasErrors())
			   return "carta";
		   else
		   {
			   boolean flag = cService.insertar(ObjCarta);
			   if(flag) {
				   return "redirect:/carta/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un error");
				   return "redirect:/carta/irRegistrar";
			   }
		   }
		 
	   }
	   
	   @RequestMapping("/modificar/{id}")
	   public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	   throws ParseException
	 {
		   Optional<Carta> ObjCarta = cService.listarId(id);
		   if(ObjCarta == null) {
			   objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			   return "redirect:/carta/listar";
		   }
		   else {
			   model.addAttribute("carta", ObjCarta);
			   return "carta";
		   }
	 }
	   @RequestMapping("/actualizar")
	   public String actualizar(@ModelAttribute @Valid Carta ObjCarta, BindingResult binRes,Model model, 
		   RedirectAttributes objRedir) 
	   throws ParseException
	   {
		   if (binRes.hasErrors()) {
			   return "redirect:/carta/listar";
		   }
		   else {
			   boolean flag = cService.modificar(ObjCarta);
			   if(flag) {
				   objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				   return "redirect:/carta/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un roche");
				   return "redirect:/carta/irRegistrar";
			   }
		   }
	   }
	   
	   @RequestMapping("/eliminar")
	   public String eliminar (Map<String, Object>model, @RequestParam(value= "id")Integer id) {
		   try {
			   if(id!= null && id>0) {
				   cService.eliminar(id);
				   model.put("listaCarta", cService.listar());
			   }
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   model.put("mensaje","Ocurrio un error");
			   model.put("listaCarta", cService.listar());
		   }
		   return "listCarta";
	   }
	   
	   @RequestMapping("/listar")
	   public String listar(Map<String, Object>model) {
		   model.put("listaCarta",  cService.listar());
		   return "listCarta";
	   }

}
