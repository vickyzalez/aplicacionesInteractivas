package modelo;

public class Empleado {

	protected Integer dni;
	protected String nombre;
	protected String apellido;
	protected String domicilio;
	protected String mail;
	private PuestoEmpleado puesto;
	private Float sueldo; //????
	
	
	public Empleado(){
		
	}
	public Empleado(int dni, String nombre,String apellido, String domicilio, String mail,
			PuestoEmpleado puesto, float sueldo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
