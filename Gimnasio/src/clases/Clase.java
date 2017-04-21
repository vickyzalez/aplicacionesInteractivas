package clases;

public class Clase {

	private String dia;
	private Integer horaInicio;
	private Integer horaFin;
	private Profesor profesor;
	private Deporte deporte; //ver cómo ponerlo
	
	public Clase(String dia, Integer horaInicio, Integer horaFin, Profesor profesor) {
		super();
		this.dia = dia;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
		this.profesor = profesor;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Integer horaFin) {
		this.horaFin = horaFin;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
}
