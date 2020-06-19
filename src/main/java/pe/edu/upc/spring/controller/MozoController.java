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

import pe.edu.upc.spring.model.Mozo;
import pe.edu.upc.spring.service.IMozoService;


@Controller
@RequestMapping("/mozo")
public class MozoController {

	  @Autowired
	   private IMozoService mService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoCliente(Map<String, Object>model) {
		   model.put("listaMozo", mService.listar());
		   return "listMozo";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("mozo", new Mozo());
		   return "mozo";
	   }
	   
	   @RequestMapping("/registrar")
	   public String registrar(@ModelAttribute @Valid Mozo objMozo, BindingResult binRes, Model model)
	   throws ParseException
	   {
		   if(binRes.hasErrors())
			   return "mozo";
		   else
		   {
			   boolean flag = mService.insertar(objMozo);
			   if(flag) {
				   return "redirect:/mozo/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un error");
				   return "redirect:/mozo/irRegistrar";
			   }
		   }
		 
	   }
	   
	   @RequestMapping("/modificar/{id}")
	   public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	   throws ParseException
	 {
		   Optional<Mozo> objMozo = mService.listarId(id);
		   if(objMozo == null) {
			   objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			   return "redirect:/mozo/listar";
		   }
		   else {
			   model.addAttribute("mozo", objMozo);
			   return "mozo";
		   }
	 }
	   @RequestMapping("/actualizar")
	   public String actualizar(@ModelAttribute @Valid Mozo ObjMozo, BindingResult binRes,Model model, 
		   RedirectAttributes objRedir) 
	   throws ParseException
	   {
		   if (binRes.hasErrors()) {
			   return "redirect:/mozo/listar";
		   }
		   else {
			   boolean flag = mService.modificar(ObjMozo);
			   if(flag) {
				   objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				   return "redirect:/mozo/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un roche");
				   return "redirect:/mozo/irRegistrar";
			   }
		   }
	   }
	   
	   @RequestMapping("/eliminar")
	   public String eliminar (Map<String, Object>model, @RequestParam(value= "id")Integer id) {
		   try {
			   if(id!= null && id>0) {
				   mService.eliminar(id);
				   model.put("listaMozo", mService.listar());
			   }
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   model.put("mensaje","Ocurrio un error");
			   model.put("listaMozo", mService.listar());
		   }
		   return "listMozo";
	   }
	   
	   @RequestMapping("/listar")
	   public String listar(Map<String, Object>model) {
		   model.put("listarMozo",  mService.listar());
		   return "listMozo";
	   }
	   
}
