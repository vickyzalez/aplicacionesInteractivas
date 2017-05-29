package modelo;

import java.util.ArrayList;

public class Deporte {

	private Integer codigo;
	private String titulo;
	private String descripcion;
	private ArrayList<Actividad> actividades;
	

	
	public Deporte(Integer codigo, String titulo, String descripcion) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.actividades = new ArrayList<Actividad>();
	}
	
	public boolean agregarActividad(Actividad a){
		return this.actividades.add(a);
	}

	public boolean eliminarActividad(Actividad a){
		return this.actividades.remove(a);
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
	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(ArrayList<Actividad> actividades) {
		this.actividades = actividades;
	}

	
	
}
