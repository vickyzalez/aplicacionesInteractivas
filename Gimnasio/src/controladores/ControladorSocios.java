package controladores;

import java.util.ArrayList;

import modelo.Socio;

public class ControladorSocios {
private ArrayList<Socio> socios;


public void ControladorSocios(){
	this.socios = new ArrayList<Socio>(0);
}

public boolean AgregarSocio(Socio s){
	return this.socios.add(s);
}

public boolean EliminarSocio(Socio s){
return this.socios.remove(s);
}
}