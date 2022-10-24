package com.certus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.certus.spring.models.Personaje;

@Controller  //Se llama al controlador 
@RequestMapping("/app")//Para acceder al controlador debes poner  RUTA
public class HomeController {
	
	@Value("${title.generic}") //Llamamos al valor de Properties y lo seteamos en la clase
	private String titlePage;
	
	@GetMapping({"/home","/"}) //Para acceder al método se 
	public String holaMundo(Model model) { //String se le adihere a la función para que devuelva el tipo de dato
		
		
		//Llamamos a la clase personaje y seteamos sus valores
		Personaje personaje1 = new Personaje();
		personaje1.setNombres("Luffy");
		personaje1.setAlias("Elástico");
		personaje1.setTipoFruta("Manzana");
		personaje1.setHabilidad("Estirarse");
		personaje1.setTripulacion("El Perla Negra");
		personaje1.setRecompensa("40000");
		
		
		//Llamamos a la clase personaje y seteamos sus valores
		Personaje personaje2 = new Personaje();
		personaje2.setNombres("Luffy 2");
		personaje2.setAlias("Elástico 2");
		personaje2.setTipoFruta("Manzana 2");
		personaje2.setHabilidad("Estirarse 2");
		personaje2.setTripulacion("El Perla Negra 2");
		personaje2.setRecompensa("40000999");
		
		
		//Luego creamos listas del tipo PERSONAJE y agregamos los setters
		List<Personaje> listita2 = new ArrayList<>();	
		listita2.add(personaje1);
		listita2.add(personaje2);
		
		List<String> listita = new ArrayList<>();	
		listita.add("Primer Elemento");
		listita.add("Segundo Elemento");
		listita.add("Tercer Elemento");
		listita.add("Cuarto Elemento");
		listita.add("Quinto Elemento");
		listita.add("Cuarto Elemento");
		listita.add("Sexto Elemento");
		
		model.addAttribute("TituloPagina", titlePage); //Inyectar datos a la vista a través del controlador 
		model.addAttribute("listita", listita);
		model.addAttribute("listita2", listita2);
		
		
		return "Home";//Nombre de la página HTML
		
	}
}
