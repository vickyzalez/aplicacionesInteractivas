package clases;

public class Clase {

	private String horario;
	private Profesor profesor;
	private TipoClase tipo;
	private String dia;
	
	
	
	public Clase(String horario, Profesor profesor, TipoClase tipo, String dia) {
		super();
		this.horario = horario;
		this.profesor = profesor;
		this.tipo = tipo;
		this.dia = dia;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public TipoClase getTipo() {
		return tipo;
	}
	public void setTipo(TipoClase tipo) {
		this.tipo = tipo;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	
}
