package modelo;

import java.sql.Date;

public class Abono {

	
	private Integer codigo;
	private String nombre;
	private Float precio;
	private Date vigencia; 

	
		
	public Abono(Integer codigo, String nombre, Float precio, Date vigencia) {
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
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

}