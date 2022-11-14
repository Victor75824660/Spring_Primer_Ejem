package com.certus.spring.service;

import org.springframework.stereotype.Service;

import com.certus.spring.models.Personaje;
import com.certus.spring.models.Response;

@Service
public interface IPersonajeService {//No olvidar la palabra interface 
	
	public Response<Personaje> añadirPersonaje();
	public String crearPersonaje();
	public String editarPeronaje();
	
	public String demoMetodo(Personaje p); 
	
	}
