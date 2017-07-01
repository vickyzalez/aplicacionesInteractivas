
package modelo;

import java.util.Vector;

public class Deporte {

	private Integer codigo;
	private String titulo;
	private String descripcion;
	private Vector<Actividad> actividades;
	

	
	public Deporte(Integer codigo, String titulo, String descripcion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.actividades = new Vector<Actividad>();
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



	public Vector<Actividad> getActividades() {
		return actividades;
	}



	public void setActividades(Vector<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
	
	
	
	
}
