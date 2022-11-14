package com.certus.spring.models;

import java.util.List;

public class Response<T> { //Se le pone <T> PARA QUE ESTE ESPERE UNA ENTIDAD ES DECIR UNA CLASE ESTA ENTIDAD ES GENERICA
	private boolean estado;
	private String mensaje;
	private List<T> data;
	
	
	
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
