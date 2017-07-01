package controladores;
import java.util.Vector;

import modelo.Actividad;
import modelo.ActividadConProfesor;
import modelo.ActividadSinProfesor;
import modelo.ClaseAct;
import modelo.Cronograma;
import modelo.Deporte;
import persistencia.AdminPersistActividadConP;
import persistencia.AdminPersistActividadSinP;
import persistencia.AdminPersistClase;
import persistencia.AdminPersistDeporte;

public class ControladorDeportes {
	private static ControladorDeportes instancia;
	private Cronograma cronograma; //TODO falta hacer cronograma
	private Vector<Deporte> deportes;
	private Vector<Actividad> actividades;
	private Vector<ClaseAct> clases;

	public ControladorDeportes(){
		deportes = AdminPersistDeporte.getInstancia().selectAll();
	}

	//Singleton
	public static ControladorDeportes getInstancia(){
		if (instancia == null){
			instancia = new ControladorDeportes();
		}
		return instancia;
	}

	Deporte buscarDeporteBuffer (Integer codigo){
		
		for (Deporte deporte : deportes) {
			if (deporte.getCodigo() == codigo) {
				return deporte;
			} else {
				Deporte dep = AdminPersistDeporte.getInstancia().buscarDeporte(codigo);
				if (dep == null){
					return null;
				} else {
					deportes.addElement(dep);
					return dep;
				}
			}
			
		}
		return null;
	}
	
	Actividad buscarActividadBuffer (Integer codigo){
		
		for (Actividad actividad : actividades) {
			if (actividad.getIdActividad() == codigo) {
				return actividad;
			} else {
				ActividadConProfesor act = AdminPersistActividadConP.getInstancia().buscarActividad(codigo);
				if (act == null){
					ActividadSinProfesor act2 = AdminPersistActividadSinP.getInstancia().buscarActividad(codigo);
						
					if (act2 == null){
						return null;
					} else {
						actividades.addElement(act2);
						return act2;
					}
				} else {
					actividades.addElement(act);
					return act;
				}
			}
			
		}
		return null;
	}
	
	
	ClaseAct buscarClaseBuffer (Integer codigo){
			
		for (ClaseAct claseAct : clases) {
			if (claseAct.getIdClase() == codigo) {
				return claseAct;
			} else {
				ClaseAct claseA = AdminPersistClase.getInstancia().buscarClase(codigo);
				if (claseA == null){
					return null;
				} else {
					clases.addElement(claseA);
					return claseA;
				}
			}
			
		}
		return null;
	}
	
	
	public void altaDeporte(Integer codigo, String titulo, String descripcion){
		Deporte dep = buscarDeporteBuffer(codigo);
		if (dep == null) {
			
			Deporte deporte =  new Deporte(codigo, titulo, descripcion);
			
			AdminPersistDeporte.getInstancia().insert(deporte);
			this.deportes.addElement(deporte);
			
		} else {
			System.out.println("El deporte ya esta dado de alta en el sistema");
		}
		
		
	}
	
	public void altaActividadSinProfe(Integer idDep, Integer id, String desc){
		Actividad act = buscarActividadBuffer(id);
		if (act == null) {
			
			ActividadSinProfesor acti = new ActividadSinProfesor(idDep, id, desc);
			
			AdminPersistActividadSinP.getInstancia().insert(acti);
			this.actividades.addElement(acti);
			
		} else {
			System.out.println("La actividad ya esta dada de alta en el sistema");
		}
		
		
	}
	
	public void altaActividadConProfe(Integer idDep, Integer id, String desc, Integer idProfe){
		Actividad act = buscarActividadBuffer(id);
		if (act == null) {
			
			ActividadConProfesor acti = new ActividadConProfesor(idDep, id, desc, idProfe);
			
			AdminPersistActividadConP.getInstancia().insert(acti);
			this.actividades.addElement(acti);
			
		} else {
			System.out.println("La actividad ya esta dada de alta en el sistema");
		}
		
		
	}
	
	public void altaClase(Integer idAct, Integer idClase, Integer desde, Integer hasta, Integer idDia){
		ClaseAct clase = buscarClaseBuffer(idClase);
		if (clase == null) {
			
			ClaseAct classe = new ClaseAct(idAct, idClase, desde, hasta, idDia);
			
			AdminPersistClase.getInstancia().insert(classe);
			this.clases.addElement(classe);
			
		} else {
			System.out.println("La clase ya esta dada de alta en el sistema");
		}
		
		
	}
	
	//TODO método
		public void modificarDeporte(Integer codigo, String titulo, String descripcion){
			Deporte dep = buscarDeporteBuffer(codigo);
			if (dep == null) {
				System.out.println("El deporte no se encuentra registrado en el sistema");
			} else {
				this.deportes.removeElement(dep);
				dep.setCodigo(codigo);
				dep.setTitulo(titulo);
				dep.setDescripcion(descripcion);
				
				AdminPersistDeporte.getInstancia().update(dep);
				this.deportes.addElement(dep);

				System.out.println("El deporte ha sido modificado");
			}
	}
		
	//TODO método
	public void modificarActividadConProfe(){
		
	}

	//TODO método
	public void modificarActividadSinProfe(){
		
	}
	
	//TODO método
	public void modificarClase(){
		
	}
		
	//TODO método
	public void bajaDeporte(){
		
	}
	
	//TODO método
	public void bajaActividad(){
		
	}
	
	//TODO método
	public void bajaClase(){
		
	}
		
	//TODO método
	public void agregarActividad(){
		
	}
	
	//TODO método
	public void agregarClase(){
		
	}
	
	//TODO método, para poder generar notificaciones
	public void cancelarClaseDelDia(){

	}
	
	//TODO método
	public void generarCronograma(){
		
	}
}
