package modelo;

import java.util.Vector;

public class InscripcionNormal extends Inscripcion {

	
	public InscripcionNormal(Integer cod, Integer dni, Integer codAbono){
		super.codigo = cod;
		super.dniSocio = dni;
		super.codigoAbono = codAbono;
		super.clases = new Vector<ClaseAct>();
		
	}
}
