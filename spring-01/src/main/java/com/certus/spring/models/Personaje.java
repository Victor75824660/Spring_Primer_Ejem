package com.certus.spring.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Personaje {
	
	@NotEmpty(message="Debe indicar su Nombre") //Notacion para que sea requerido, tiene que ser del tipo valid
	private String nombres;
	@Size(min = 5  , message="Debe indicar su Alias | al menos 5 caracteres	")
	private String alias;
	@NotEmpty(message="Debe indicar el Tipo de Fruta")
	private String tipoFruta;
	@NotEmpty(message="Debe indicar su Habilidad")
	private String habilidad;
	@NotEmpty(message="Debe indicar su Tripulación")
	private String tripulacion;
	@NotEmpty(message="Debe indicar la Recompensa")
	private String recompensa;
	
	
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTipoFruta() {
		return tipoFruta;
	}
	public void setTipoFruta(String tipoFruta) {
		this.tipoFruta = tipoFruta;
	}
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}
	public String getTripulacion() {
		return tripulacion;
	}
	public void setTripulacion(String tripulacion) {
		this.tripulacion = tripulacion;
	}
	public String getRecompensa() {
		return recompensa;
	}
	public void setRecompensa(String recompensa) {
		this.recompensa = recompensa;
	}
	
	
	

	
	
}
