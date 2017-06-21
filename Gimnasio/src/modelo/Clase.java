package modelo;

public class Clase {
	private Integer horaDesde;
	private Integer horaHasta;
	private String dia; //para no tener DíaSemana

	public Clase(Integer desde, Integer hasta, String dia){
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

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	

	

}
