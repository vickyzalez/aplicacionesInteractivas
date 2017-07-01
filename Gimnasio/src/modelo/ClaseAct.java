package modelo;

public class ClaseAct {
	private Integer idAct;
	private Integer idClase;
	private Integer horaDesde;
	private Integer horaHasta;
	private Integer dia; 

	public ClaseAct(Integer idAct, Integer idClase, Integer desde, Integer hasta, Integer idDia){
		this.idClase = idClase;
		this.horaDesde = desde;
		this.horaHasta = hasta;
		this.dia = idDia;
		this.idAct = idAct;
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

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getIdClase() {
		return idClase;
	}

	public void setIdClase(Integer idClase) {
		this.idClase = idClase;
	}

	public Integer getIdAct() {
		return idAct;
	}

	public void setIdAct(Integer idAct) {
		this.idAct = idAct;
	}
	

	

}
