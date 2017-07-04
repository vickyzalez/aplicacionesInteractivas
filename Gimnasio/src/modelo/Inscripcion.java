package modelo;

import java.util.Vector;

public abstract class Inscripcion {
	protected Integer codigo;
	protected Integer dniSocio; 
	protected Integer codigoAbono;
	protected Vector<ClaseAct> clases;
	
	
	public void agregarClase(ClaseAct clase){
		this.clases.addElement(clase);
	}
	
	public void eliminarClase(Integer clase){
		this.clases.remove(clase);
	}
	
	public Integer getDniSocio() {
		return dniSocio;
	}

	public void setDniSocio(Integer dniSocio) {
		this.dniSocio = dniSocio;
	}


	public Integer getCodigoAbono() {
		return codigoAbono;
	}

	public void setCodigoAbono(Integer abono) {
		this.codigoAbono = abono;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Vector<ClaseAct> getClases() {
		return clases;
	}
	
	

}
