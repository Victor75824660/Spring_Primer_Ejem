package com.certus.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.certus.spring.models.Personaje;
import com.certus.spring.service.IPersonajeService;

@Controller // Se llama al controlador
@RequestMapping("/app") // Para acceder al controlador debes poner RUTA
public class HomeController {

	@Value("${title.generic}") // Llamamos al valor de Properties y lo seteamos en la clase
	private String titlePage;

	@Autowired
	@Qualifier("Servicio1") // Con esta connotacion se hace referencia a los alias de servicios en las
							// interfaces
	private IPersonajeService InterfacePersonaje1;

	@Autowired
	@Qualifier("Servicio2") // Con esta connotacion se hace referencia a los alias de servicios en las
							// interfaces
	private IPersonajeService InterfacePersonaje2;

//	@Autowired //Se le dice al programa que vaya al contenedor que busque el nombre del objeto
//	private PersonajeService personaje = new PersonajeService();

	@GetMapping({ "/home", "/" }) // Para acceder al método se
	public String holaMundo(Model model) { // String se le adihere a la función para que devuelva el tipo de dato

		model.addAttribute("TituloPagina", titlePage); // Inyectar datos a la vista a través del controlador

//		List<Personaje> listasUnidas = new ArrayList<>();

		if (InterfacePersonaje1.añadirPersonaje().getEstado()) {// Si es que es true, se enviará la data
			model.addAttribute("listita2", InterfacePersonaje1.añadirPersonaje().getData());// Enviamos la data desde la
																							// clase personaje, luego al
																							// servicio, y luego con su
																							// get la traemos nuevamente

		}

//		listasUnidas.addAll(InterfacePersonaje1.añadirPersonaje().getData());
//		listasUnidas.addAll(InterfacePersonaje2.añadirPersonaje().getData());	AQUI UNIMOS LAS 2 LISTAS XD
//
//		model.addAttribute("listita2", listasUnidas);

		model.addAttribute("Estado", InterfacePersonaje1.añadirPersonaje().getMensaje());// Este sale fuera del IF
																							// debido a que de todos
																							// modos se enviará un
																							// mensaje

		Personaje personaje = new Personaje();

		String respuesta = InterfacePersonaje2.demoMetodo(personaje);

		model.addAttribute("respuesta", respuesta);

		return "Home";// Nombre de la página HTML

	}

	@GetMapping("/Form")
	public String Form(Model model) {

		model.addAttribute("titulo", "Formulario con Bootstrap | Crear Personaje");	
		Personaje person = new Personaje();//Se envia esto porque siempre se debe tener un personaje en blanco
		model.addAttribute("person", person);//Es lo que espera la page


		return "Form";
	}

	@GetMapping("/Integrantes")
	public String Yoxd(Model model) {

		return "Integrantes";
	}

	@PostMapping("/formulario") 
			public String crearPersonaje(@Valid Personaje person, BindingResult result  , Model model) { //Notación Valid para validar, se hace ref en el Pom y luego se pone antes del objeto se valida en la clase Personaje
																										//BindingResult es para mapear los errores y enviarlos a otra interfaz
//		@RequestParam String nombres, @RequestParam String alias,
//		@RequestParam String tipoFruta, @RequestParam String habilidad, @RequestParam String tripulacion,
//		@RequestParam String recompensa
//		Personaje person = new Personaje();
//		person.setNombres(nombres);
//		person.setAlias(alias);					PODEMOS MAPEAR CADA INPUT CON SU NOMBRE O LLAMANDO
//		person.setHabilidad(tipoFruta);			A UN OBJETO DE LA CLASE
//		person.setTipoFruta(habilidad);
//		person.setRecompensa(tripulacion);
//		person.setTripulacion(recompensa);
		
		if(result.hasErrors()) { //Si es que se encuentra algun error se redireccionará a otra page, se le debe inyectar info
			
			Map<String, String> errorPersonaje = new HashMap<>(); //Instanciamos el mapa
			result.getFieldErrors().forEach(e ->{//Hacemos un listado de todos los errores y luego se itera y se agrega una variable auxiliar y se inserta con el put
				errorPersonaje.put(e.getField(), e.getDefaultMessage());
				
				model.addAttribute("titulo", "Formulario con Bootstrap | Personaje creado");
				model.addAttribute("error", errorPersonaje);//Se envia al Formulario
				model.addAttribute("person", person);
			});
//			model.addAttribute("tituloPage", "Error pipipi"); Inyectar algo, porque sale vacio
			return "Form";
		}

		model.addAttribute("titulo", "Formulario con Bootstrap | Personaje creado");
		model.addAttribute("person", person);
		

		return "Form";// vista

	}

}
