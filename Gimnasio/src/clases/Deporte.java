package clases;

import java.util.ArrayList;

public abstract class Deporte {

	private Integer codigo;
	private String titulo;
	private String descripcion;
	private ArrayList<Actividad> actividades;
	

	
	public Deporte(Integer codigo, String titulo, String descripcion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public ArrayList<Actividad> getClases() {
		return actividades;
	}

	public void setClases(ArrayList<Actividad> clases) {
		this.actividades = clases;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
