package clases;

public class PuestoEmpleado {
	
	private Integer codigoPuesto;
	private String nombrePuesto;
	

	public PuestoEmpleado(Integer codigoPuesto, String nombrePuesto) {
		super();
		this.codigoPuesto = codigoPuesto;
		this.nombrePuesto = nombrePuesto;
	}
	
	
	public Integer getCodigoPuesto() {
		return codigoPuesto;
	}
	public void setCodigoPuesto(Integer codigoPuesto) {
		this.codigoPuesto = codigoPuesto;
	}
	public String getNombrePuesto() {
		return nombrePuesto;
	}
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}
	
	

}
