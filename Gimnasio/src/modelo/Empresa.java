package modelo;

import java.util.ArrayList;

//Esta clase servirá para cuando tengamos las empresas para la inscripción corporativa

public class Empresa {
	
	private Integer id;
	private String nombre;
	private ArrayList<Socio> socios;

	public Empresa(String nombre){
		this.nombre = nombre;
	}
	
	public boolean agregarSocio(Socio socio){
		return this.socios.add(socio);				
	}
	
	public boolean eliminarSocio(Socio socio){
		return this.socios.remove(socio);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}
	
	

}
