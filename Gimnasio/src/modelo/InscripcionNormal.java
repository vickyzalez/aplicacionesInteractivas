package modelo;

import java.util.ArrayList;

public class InscripcionNormal extends Inscripcion {

	public InscripcionNormal(){
		super();
	}
	
	public void InscripcionCorporativa(Socio socio, Abono abono){
		super.actividades = new ArrayList<Actividad>();
		super.abono = abono;
		super.socio = socio;
	}
}
