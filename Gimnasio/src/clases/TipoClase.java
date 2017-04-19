package clases;

public class TipoClase {

	private Integer codigoClase;
	private String nombreClase;
	
	
	public TipoClase(Integer codigoClase, String nombreClase) {
		super();
		this.codigoClase = codigoClase;
		this.nombreClase = nombreClase;
	}
	
	public Integer getCodigoClase() {
		return codigoClase;
	}
	public void setCodigoClase(Integer codigoClase) {
		this.codigoClase = codigoClase;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	
}
