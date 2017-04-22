package clases;

public class Actividad {

	private String dia;
	private Integer horaInicio;
	private Integer horaFin;
	
	public Actividad(String dia, Integer horaInicio, Integer horaFin, Profesor profesor) {
		super();
		this.dia = dia;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
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

	
	
}
