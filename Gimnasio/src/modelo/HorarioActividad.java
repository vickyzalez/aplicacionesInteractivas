package modelo;

public class HorarioActividad {
	private Integer horaDesde;
	private Integer horaHasta;
	private DiaSemana dia;

	public HorarioActividad(Integer desde, Integer hasta, DiaSemana dia){
		this.horaDesde = desde;
		this.horaHasta = hasta;
		this.dia = dia;
	}

	public Integer getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Integer horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Integer getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Integer horaHasta) {
		this.horaHasta = horaHasta;
	}

	public DiaSemana getDia() {
		return dia;
	}

	public void setDia(DiaSemana dia) {
		this.dia = dia;
	}
	

	

}
