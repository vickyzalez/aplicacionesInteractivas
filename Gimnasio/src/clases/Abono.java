package clases;

import java.util.Calendar;

public class Abono {

	
	private Integer codigo;
	private String nombre;
	private Float precio;
	private Calendar vigencia; //Se tiene en cuenta que ésta es la fecha de vencimiento

	
		
	public Abono(Integer codigo, String nombre, Float precio, Calendar vigencia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.vigencia = vigencia;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Calendar getVigencia() {
		return vigencia;
	}
	public void setVigencia(Calendar vigencia) {
		this.vigencia = vigencia;
	}

}
