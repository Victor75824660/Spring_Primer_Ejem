package com.certus.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

@Component("Servicio1")//connotacion implementada aqui y en el controller //Esto es parte del framework de Spring y sirve para decirle al programa que este es un componente- tambien puede ser un servicio


public class PersonajeService implements IPersonajeService{

	public String crearPersonaje() {
		return "Personaje Creado a";
	}

	public Response<Personaje> añadirPersonaje() {//El metodo va a ser del tipo Response con la entidad <Personaje>

		
		Response<Personaje> response = new Response<>(); //Llamamos al objeto de la clase Response para enviarle sus valores
		boolean estadoCreacion = false;
		
		
		List<Personaje> listita2 = new ArrayList<>();
		// Llamamos a la clase personaje y seteamos sus valores
		Personaje personaje1 = new Personaje();
		personaje1.setNombres("Luffy");
		personaje1.setAlias("Elástico");
		personaje1.setTipoFruta("Manzana");
		personaje1.setHabilidad("Estirarse");
		personaje1.setTripulacion("El Perla Negra");
		personaje1.setRecompensa("40000");

		// Llamamos a la clase personaje y seteamos sus valores
		Personaje personaje2 = new Personaje();
		personaje2.setNombres("Luffy 5");
		personaje2.setAlias("Elástico 2");
		personaje2.setTipoFruta("Manzana 2");
		personaje2.setHabilidad("Estirarse 2");
		personaje2.setTripulacion("El Perla Negra 2");
		personaje2.setRecompensa("40000999");

		Personaje personaje3 = new Personaje();
		personaje3.setNombres("Luffy 3");
		personaje3.setAlias("Elástico 3");
		personaje3.setTipoFruta("Manzana 3");
		personaje3.setHabilidad("Estirarse 3");
		personaje3.setTripulacion("El Perla Negra 2");
		personaje3.setRecompensa("40000999");

		listita2.add(personaje1);
		listita2.add(personaje2);
		listita2.add(personaje3);
		
		
		//Validación de lista de personajes
		
		if(listita2.size() > 0) { //Validamos que las lista no este vacia
			estadoCreacion = true; //Si no está vacia es verdadera
			response.setEstado(estadoCreacion);//Enviamos los parámetros a la clase para que las guarde
			response.setMensaje("Creado correctamente");//Enviamos los parámetros a la clase para que las guarde
			response.setData(listita2);//Enviamos la lista a la clase para que las guarde
		}else {
			response.setEstado(estadoCreacion);
			response.setMensaje("Se produjo un error al crear los personajes");
		
		}
		
		
		return response; //Aqui va a retornar el objeto, se coloca aqui, porque antes ya le habiamos enviado valores
	}
	
	public String editarPeronaje() {
		return "Personaje Editado";
	}

	@Override
	public String demoMetodo(Personaje p) {
		
		String Respuesta = "Procesando";
		
		if(p != null) {
			Respuesta = "Todo okeyy";
		}
		return Respuesta;
	}
	
}
