package clases;

public class Socio {
	
	private Integer idCredencial;
	private String nombre;
	private String domicilio;
	private String telefono;
	private String mail;
	private Abono abono; //Se pone el abono acá o esto irá en la inscripción?
	private Inscripcion inscripcion; //Es necesaria la inscripción como clase cuando en realidad es un validador?
	private Certificado certificado;
	
	
	public Socio(String nombre, String domicilio, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.mail = mail;
		this.certificado = new Certificado();
	}
	
	public Integer getIdCredencial() {
		return idCredencial;
	}
	public void setIdCredencial(Integer idCredencial) {
		this.idCredencial = idCredencial;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Abono getAbono() {
		return abono;
	}
	public void setAbono(Abono abono) {
		this.abono = abono;
	}
	public Inscripcion getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	public Certificado getCerticiado() {
		return certificado;
	}
	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

}
