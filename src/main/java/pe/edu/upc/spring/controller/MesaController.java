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

import pe.edu.upc.spring.model.Mesa;
import pe.edu.upc.spring.service.IMesaService;


@Controller
@RequestMapping("/mesa")
public class MesaController {
	
	 @Autowired
	   private IMesaService mService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoMesa(Map<String, Object>model) {
		   model.put("listaMesa", mService.listar());
		   return "listMesa";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("mesa", new Mesa());
		   return "mesa";
	   }
	   
	   @RequestMapping("/registrar")
	   public String registrar(@ModelAttribute @Valid Mesa objMesa, BindingResult binRes, Model model)
	   throws ParseException
	   {
		   if(binRes.hasErrors())
			   return "mesa";
		   else
		   {
			   boolean flag = mService.insertar(objMesa);
			   if(flag) {
				   return "redirect:/mesa/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un error");
				   return "redirect:/mesa/irRegistrar";
			   }
		   }
		 
	   }
	   
	   @RequestMapping("/modificar/{id}")
	   public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	   throws ParseException
	 {
		   Optional<Mesa> objMesa = mService.listarId(id);
		   if(objMesa == null) {
			   objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			   return "redirect:/mesa/listar";
		   }
		   else {
			   model.addAttribute("mesa", objMesa);
			   return "mesa";
		   }
	 }
	   @RequestMapping("/actualizar")
	   public String actualizar(@ModelAttribute @Valid Mesa ObjMesa, BindingResult binRes,Model model, 
		   RedirectAttributes objRedir) 
	   throws ParseException
	   {
		   if (binRes.hasErrors()) {
			   return "redirect:/mesa/listar";
		   }
		   else {
			   boolean flag = mService.modificar(ObjMesa);
			   if(flag) {
				   objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				   return "redirect:/mesa/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un roche");
				   return "redirect:/mesa/irRegistrar";
			   }
		   }
	   }
	   
	   @RequestMapping("/eliminar")
	   public String eliminar (Map<String, Object>model, @RequestParam(value= "id")Integer id) {
		   try {
			   if(id!= null && id>0) {
				   mService.eliminar(id);
				   model.put("listaMesa", mService.listar());
			   }
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   model.put("mensaje","Ocurrio un error");
			   model.put("listaMesa", mService.listar());
		   }
		   return "listMesa";
	   }
	   
	   @RequestMapping("/listar")
	   public String listar(Map<String, Object>model) {
		   model.put("listaMesa",  mService.listar());
		   return "listMesa";
	   }
	

}
