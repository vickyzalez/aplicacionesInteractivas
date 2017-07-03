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
	private Cronograma cronograma;
	private Vector<Deporte> deportes;
	private Vector<Actividad> actividades;
	private Vector<ClaseAct> clases;

	public ControladorDeportes(){
		deportes = AdminPersistDeporte.getInstancia().selectAll();
		cargarActividades();
		actividades = this.actividadesBD();
		cargarClases();
		clases = AdminPersistClase.getInstancia().selectAll();
		cronograma = new Cronograma();
	}

	//Singleton
	public static ControladorDeportes getInstancia(){
		if (instancia == null){
			instancia = new ControladorDeportes();
		}
		return instancia;
	}

	//devuelve todas las actividades dadas de alta en el sist
	private Vector<Actividad> actividadesBD(){
		 Vector<Actividad> actividades = new Vector<Actividad>();
		 actividades.addAll(AdminPersistActividadConP.getInstancia().selectAll());
		 actividades.addAll(AdminPersistActividadSinP.getInstancia().selectAll());
		 return actividades;
	 }
	
	//trae todas las actividades que tiene un deporte
	private void cargarActividades(){
		for (Deporte deporte : this.deportes) {
			
			Vector<Integer> actividades = AdminPersistDeporte.getInstancia().mostrarActividades(deporte.getCodigo());
			
			for (Integer act : actividades) {
				Actividad actDep = buscarActividadBuffer(act);
				deporte.agregarActividad(actDep);
			}			
		}
	}
	
	//trae todas las clases que tiene una actividad
		private void cargarClases(){
			for (Actividad actividad : this.actividades) {
				
				Vector<Integer> clases = AdminPersistClase.getInstancia().mostrarClases(actividad.getIdActividad());
				
				for (Integer claseA : clases) {
					ClaseAct clase = buscarClaseBuffer(claseA);
					actividad.agregarClase(clase);
			}			
		}
	}			

	
	//buscadores
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
	
	public void agregarActividadSinProfe(Integer idDep, Integer id, String desc){
		Actividad act = buscarActividadBuffer(id);
		if (act == null) {
			
			ActividadSinProfesor acti = new ActividadSinProfesor(idDep, id, desc);
			
			AdminPersistActividadSinP.getInstancia().insert(acti);
			this.actividades.addElement(acti);
			Deporte dep = buscarDeporteBuffer(idDep);
			dep.agregarActividad(acti);
			
		} else {
			System.out.println("La actividad ya esta dada de alta en el sistema");
		}
		
		
	}
	
	public void agregarActividadConProfe(Integer idDep, Integer id, String desc, Integer idProfe){
		Actividad act = buscarActividadBuffer(id);
		if (act == null) {
			
			ActividadConProfesor acti = new ActividadConProfesor(idDep, id, desc, idProfe);
			
			AdminPersistActividadConP.getInstancia().insert(acti);
			this.actividades.addElement(acti);
			Deporte dep = buscarDeporteBuffer(idDep);
			dep.agregarActividad(acti);
			
		} else {
			System.out.println("La actividad ya esta dada de alta en el sistema");
		}
		
		
	}
	
	public void agregarClase(Integer idAct, Integer idClase, Integer desde, Integer hasta, Integer idDia){
		ClaseAct clase = buscarClaseBuffer(idClase);
		if (clase == null) {
			
			ClaseAct classe = new ClaseAct(idAct, idClase, desde, hasta, idDia);
			
			AdminPersistClase.getInstancia().insert(classe);
			this.clases.addElement(classe);
			Actividad act = buscarActividadBuffer(idAct);
			act.agregarClase(classe);
			
		} else {
			System.out.println("La clase ya esta dada de alta en el sistema");
		}
		
		
	}
	
	
		public void modificarDeporte(Integer codigo, String titulo, String descripcion){
			Deporte dep = buscarDeporteBuffer(codigo);
			if (dep == null) {
				System.out.println("El deporte no se encuentra registrado en el sistema");
			} else {
				this.deportes.removeElement(dep);
				dep.setTitulo(titulo);
				dep.setDescripcion(descripcion);
				
				AdminPersistDeporte.getInstancia().update(dep);
				this.deportes.addElement(dep);

				System.out.println("El deporte ha sido modificado");
			}
	}
		
	public void modificarActividadConProfe(Integer id, String desc, Integer idProfe){
		ActividadConProfesor act = (ActividadConProfesor) buscarActividadBuffer(id);
		if (act == null) {
			System.out.println("La actividad no se encuentra registrado en el sistema");
		} else {
			this.actividades.removeElement(act);
			act.setDescripcion(desc);
			act.setProfesor(idProfe);
			
			AdminPersistActividadConP.getInstancia().update(act);
			this.actividades.addElement(act);

			System.out.println("La actividad ha sido modificado");
		}
	}


	public void modificarActividadSinProfe(Integer id, String desc){
		ActividadSinProfesor act = (ActividadSinProfesor) buscarActividadBuffer(id);
		if (act == null) {
			System.out.println("La actividad no se encuentra registrado en el sistema");
		} else {
			this.actividades.removeElement(act);
			act.setDescripcion(desc);
			
			AdminPersistActividadSinP.getInstancia().update(act);
			this.actividades.addElement(act);

			System.out.println("La activadad ha sido modificado");
		}
	}
	

	public void modificarClase(Integer idClase, Integer desde, Integer hasta, Integer idDia){
		ClaseAct claseA = buscarClaseBuffer(idClase);
		if (claseA == null) {
			System.out.println("La clase no se encuentra registrado en el sistema");
		} else {
			this.clases.removeElement(claseA);
			claseA.setHoraDesde(desde);
			claseA.setHoraHasta(hasta);
			claseA.setDia(idDia);
			
			AdminPersistClase.getInstancia().update(claseA);
			this.clases.addElement(claseA);

			System.out.println("La clase ha sido modificado");
		}
	}
		
	
	public void bajaDeporte(Integer id){
		Deporte dep = buscarDeporteBuffer(id);
		if (dep == null) {
			System.out.println("El deporte no se encuentra registrado en el sistema");
		} else {
			AdminPersistDeporte.getInstancia().delete(dep);
			this.deportes.removeElement(dep);
			System.out.println("El deporte "+ id + " ha sido eliminado");
		}
	}
	

	public void bajaActividad(Integer id){
		Actividad act = buscarActividadBuffer(id);
		if (act == null) {
			System.out.println("La actividad no se encuentra registrada en el sistema");
		} else {
			AdminPersistActividadConP.getInstancia().delete(act);
			this.actividades.removeElement(act);
			System.out.println("La actividad "+ id + " ha sido eliminada");
		}
	}
	

	public void bajaClase(Integer id){
		ClaseAct claseA = buscarClaseBuffer(id);
		if (claseA == null) {
			System.out.println("La clase no se encuentra registrada en el sistema");
		} else {
			AdminPersistClase.getInstancia().delete(claseA);
			this.clases.removeElement(claseA);
			System.out.println("La clase "+ id + " ha sido eliminada");
		}
	}
	
	//TODO metodo, para poder generar notificaciones
	public void cancelarClase(){

	}
	
	//TODO ver cronograma
	public void generarCronograma(){
		for (ClaseAct clase : clases) {
			switch (clase.getDia()) {
			case 1:
				this.cronograma.getLunes().addElement(clase);
				break;
				
			case 2:
				this.cronograma.getMartes().addElement(clase);
				break;
				
			case 3:
				this.cronograma.getMiercoles().addElement(clase);
				break;
			
			case 4:
				this.cronograma.getJueves().addElement(clase);
				break;

			case 5:
				this.cronograma.getViernes().addElement(clase);
				break;
			
			case 6:
				this.cronograma.getSabado().addElement(clase);
				break;
				
			default:
				break;
			}
		}
	}
}
