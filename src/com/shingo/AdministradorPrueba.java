package com.shingo;

import org.springframework.beans.factory.annotation.Autowired;

import com.shingo.pojo.Direccion;

public class AdministradorPrueba {
	
	private int idAdmin;
	private String nombre;
	private String apellido;
	
	//@Autowired puede ser colocado tanto en la propiedad(variable) o el setter
	@Autowired
	private Direccion direccion;
	
	public AdministradorPrueba() {
		
	}
	
	public AdministradorPrueba(int idAdmin, String nombre){
		this.idAdmin = idAdmin;
		this.nombre = nombre;
	}

	public void setApellido(String apellido){
		this.apellido = apellido;
	}
	
	
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	

	public void imprimirDireccion(){
		System.out.println("Shingo 1982");
	}
	
	@Override
	public String toString(){
		return "idAdmin: " + idAdmin + ", " + "nombre: " + nombre + " apellido: " + apellido + " Direccion: " + direccion;
	}
}
