package modelo;

public class InscripcionCorporativa extends Inscripcion {
	
	private Empresa empresa;
	
	public InscripcionCorporativa(){
		super();
	}
	
	public InscripcionCorporativa(Empresa empresa){
		super();
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	} 
	
	

}
