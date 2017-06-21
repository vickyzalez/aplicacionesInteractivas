package modelo;

import java.util.ArrayList;
import java.sql.Date;

public class InscripcionCorporativa extends Inscripcion {
	
	private Integer codEmpresa;
	private Date fecha;
	

	public InscripcionCorporativa(Integer codigo, Integer dniSocio, Integer codAbono, Integer codEmpresa, Date fecha){
		super.actividades = new ArrayList<Actividad>();
		super.codigo = codigo;
		super.dniSocio = dniSocio;
		super.codigoAbono = codAbono;
		this.codEmpresa = codEmpresa;
		this.fecha = fecha;
		
	}

	
	public Integer getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Integer empresa) {
		this.codEmpresa = empresa;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	} 
	
	

}
