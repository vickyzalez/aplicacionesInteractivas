package modelo;

public class Actividad {
	private int id;
	private String nombre;
	private String dia;
	private Integer horaInicio;
	private Integer horaFin;
	
	public Actividad(int id, String nombre, String dia, Integer horaInicio, Integer horaFin) {
		super();
		this.id = id;
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
