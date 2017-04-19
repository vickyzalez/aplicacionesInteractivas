package clases;

public class Empleado {
	
	private String nombre;
	private String domicilio;
	private String mail;
	private Integer dni;
	private PuestoEmpleado puesto;
	private Float sueldo; //????
	
	
	
	public Empleado(String nombre, String domicilio, String mail, Integer dni,
			PuestoEmpleado puesto, Float sueldo) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.mail = mail;
		this.dni = dni;
		this.puesto = puesto;
		this.sueldo = sueldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public PuestoEmpleado getPuesto() {
		return puesto;
	}
	public void setPuesto(PuestoEmpleado puesto) {
		this.puesto = puesto;
	}
	public Float getSueldo() {
		return sueldo;
	}
	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}
	
	

}
