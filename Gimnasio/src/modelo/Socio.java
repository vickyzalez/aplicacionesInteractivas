package modelo;


public class Socio {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private Integer telefono;
	private String mail;
	private AptoMedico am;
	private Inscripcion inscripcion;
	
	
	public Socio(Integer dni, String nombre, String apellido, String domicilio, Integer telefono, String mail) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.am = new AptoMedico();
	
	}
	
	public void agregarAptoMedico(String fechaCertificado, String nombreProfesional, String observaciones){
		this.am.setFechaCertificado(fechaCertificado);
		this.am.setNombreProfesional(nombreProfesional);
		this.am.setObservaciones(observaciones);
	}
	
	//TODO ver cómo poner la inscripcion
	public void definirInscripcion(Inscripcion inscripcion){
		if (inscripcion instanceof InscripcionNormal){
			this.inscripcion = new InscripcionNormal();
			this.inscripcion = inscripcion;
		} else {
			if (inscripcion instanceof InscripcionCorporativa){
				this.inscripcion = new InscripcionCorporativa();
				this.inscripcion = inscripcion;
			}
		}
	}
	
	//Getters & Setters 
	
	public Integer getDni() {
		return this.dni;
	}
	public void setIdCredencial(int dni) {
		this.dni = dni;
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public AptoMedico getAm() {
		return am;
	}
	public void setAm(AptoMedico am) {
		this.am = am;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Inscripcion getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}


	


}
