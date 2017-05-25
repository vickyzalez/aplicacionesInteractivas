package controladores;
import java.util.ArrayList;

import modelo.Abono;
import modelo.PagoMensual;

public class ControladorFinanzas {
	private ArrayList<Abono> abonos;
	private ArrayList<PagoMensual> pagos;
	
	public ControladorFinanzas(){
		abonos = new ArrayList<Abono>(0);
		pagos = new ArrayList<PagoMensual>(0);
	}
	
	public boolean AgregarAbono(Abono a){
		return this.abonos.add(a);
	}
	public boolean EliminarAbono(Abono a){
		return this.abonos.remove(a);
	}
	public boolean AgregarPago(PagoMensual p){
		return this.pagos.add(p);
	}
	public boolean EliminarPago(PagoMensual p){
		return this.pagos.remove(p);
	}
}
