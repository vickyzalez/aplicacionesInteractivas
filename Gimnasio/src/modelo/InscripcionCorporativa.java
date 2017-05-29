package modelo;

import java.util.ArrayList;

public class InscripcionCorporativa extends Inscripcion {
	
	private Empresa empresa;
	
	public InscripcionCorporativa(){
		super();
	}
	
	public InscripcionCorporativa(Empresa empresa){
		super();
		this.empresa = empresa;
	}

	public InscripcionCorporativa(Socio socio, Abono abono, Empresa empresa){
		super.actividades = new ArrayList<Actividad>();
		super.abono = abono;
		super.socio = socio;
		this.empresa = empresa;
	}

	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	} 
	
	

}
