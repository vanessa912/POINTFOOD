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

import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.service.IClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

	  @Autowired
	   private IClienteService cService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoCliente(Map<String, Object>model) {
		   model.put("listaCliente", cService.listar());
		   return "listCliente";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("cliente", new Cliente());
		   return "cliente";
	   }
	   
	   @RequestMapping("/registrar")
	   public String registrar(@ModelAttribute @Valid Cliente objCliente, BindingResult binRes, Model model)
	   throws ParseException
	   {
		   if(binRes.hasErrors())
			   return "cliente";
		   else
		   {
			   boolean flag = cService.insertar(objCliente);
			   if(flag) {
				   return "redirect:/cliente/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un error");
				   return "redirect:/cliente/irRegistrar";
			   }
		   }
		 
	   }
	   
	   @RequestMapping("/modificar/{id}")
	   public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	   throws ParseException
	 {
		   Optional<Cliente> objCliente = cService.listarId(id);
		   if(objCliente == null) {
			   objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			   return "redirect:/cliente/listar";
		   }
		   else {
			   model.addAttribute("cliente", objCliente);
			   return "cliente";
		   }
	 }
	   @RequestMapping("/actualizar")
	   public String actualizar(@ModelAttribute @Valid Cliente ObjCliente, BindingResult binRes,Model model, 
		   RedirectAttributes objRedir) 
	   throws ParseException
	   {
		   if (binRes.hasErrors()) {
			   return "redirect:/cliente/listar";
		   }
		   else {
			   boolean flag = cService.modificar(ObjCliente);
			   if(flag) {
				   objRedir.addFlashAttribute("mensaje","Se actualizo correctamente");
				   return "redirect:/cliente/listar";
			   }
			   else {
				   model.addAttribute("mensaje", "Ocurrio un roche");
				   return "redirect:/cliente/irRegistrar";
			   }
		   }
	   }
	   
	   @RequestMapping("/eliminar")
	   public String eliminar (Map<String, Object>model, @RequestParam(value= "id")Integer id) {
		   try {
			   if(id!= null && id>0) {
				   cService.eliminar(id);
				   model.put("listaCliente", cService.listar());
			   }
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   model.put("mensaje","Ocurrio un error");
			   model.put("listaCliente", cService.listar());
		   }
		   return "listCliente";
	   }
	   
	   @RequestMapping("/listar")
	   public String listar(Map<String, Object>model) {
		   model.put("listarCliente",  cService.listar());
		   return "listCliente";
	   }
	   
}
