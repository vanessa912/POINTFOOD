package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pe.edu.upc.spring.model.DetallePlatoReserva;
import pe.edu.upc.spring.service.IDetallePlatoReservaService;

@Controller
@RequestMapping("/detalleplatoreservacontroller")
public class DetallePlatoReservaController {
	
	   @Autowired 
	   private IDetallePlatoReservaService dPService;
	   
	   @RequestMapping("/bienvenido")
	   public String irPaginaBienvenida(){
		   return "bienvenido";
	   }
	   @RequestMapping("/")
	   public String irPaginaListadoCliente(Map<String, Object>model) {
		   model.put("listaDetallePlatoReserva", dPService.listar());
		   return "listDetallePlatoReserva";
	   }
	   @RequestMapping("/irRegistrar")
	   public String irPaginaRegistrar(Model model) {
		   model.addAttribute("detalleplatoReserva", new DetallePlatoReserva());
		   return "detalleplatoReserva";
	   }
	   
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
			try {
				if(id!=null && id>0)
				{
					dPService.eliminar(id);
					model.put("listaDetallePlatoReserva", dPService.listar());
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				model.put("mensaje", "Ocurrió un error");
				model.put("listaDetallePlatoReserva", dPService.listar());
			}
			return "listDetallePlatoReserva";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaDetallePlatoReserva", dPService.listar());
			return "listDetallePlatoReserva";
		}
		
		@RequestMapping("/listarId")
		public String listarId(Map<String, Object>model, @ModelAttribute DetallePlatoReserva detalleplatoReserva)
		throws ParseException{
			dPService.listarId(detalleplatoReserva.getIddetalleplatoreserva());
			return "listDetallePlatoReserva";
		}
		
		@RequestMapping("/buscar")
		public String buscar(Map<String, Object>model, @ModelAttribute DetallePlatoReserva detalleplatoReserva)
		throws ParseException{
			List<DetallePlatoReserva> listaDetallePlatoReservas;
			detalleplatoReserva.setIddetalleplatoreserva(detalleplatoReserva.getIddetalleplatoreserva());
			listaDetallePlatoReservas = dPService.buscarIdReserva(detalleplatoReserva.getIddetalleplatoreserva());
			
			if(listaDetallePlatoReservas.isEmpty()) {
				model.put("mensaje", "No se encontró");
			}
			model.put("listaDetallePlatoReserva", listaDetallePlatoReservas);
			return "buscar";
		}
		
		@RequestMapping("/irBuscar")
		public String irBuscar(Model model) {
			model.addAttribute("detalleplatoReserva",new DetallePlatoReserva());
			return "buscar";
		}
	   
}
