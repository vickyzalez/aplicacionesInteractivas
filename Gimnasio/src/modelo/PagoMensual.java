package modelo;

public class PagoMensual {
private int id;
private long dni;
private float montoAbonado;
private String fechaDePago;


public PagoMensual(int id, long dni, float montoAbonado, String fechaDePago){
	this.id = id;
	this.dni = dni;
	this.montoAbonado = montoAbonado;
	this.fechaDePago = fechaDePago;
}
}

