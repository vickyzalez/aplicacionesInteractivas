package modelo;


public class EmpleadoAdminstrativo extends Empleado {
	
	
	private float bruto;
	private float desc;
    
    

	public EmpleadoAdminstrativo(int dni, String nombre,String apellido, String domicilio, String mail,
			                     PuestoEmpleado puesto,float bruto,float desc) {
		super(dni, nombre, apellido, domicilio, mail, puesto, bruto);
		// TODO Auto-generated constructor stub
		this.bruto = bruto;
		this.desc = desc;
	
	}
	
	
	public float calcularSueldo(){
		float neto;
		float aux = ((this.bruto * this.desc)/100);
		neto = (this.bruto - aux);
		return neto;
		
	}


	public float getBruto() {
		return bruto;
	}


	public void setBruto(float bruto) {
		this.bruto = bruto;
	}


	public float getDesc() {
		return desc;
	}


	public void setDesc(float desc) {
		this.desc = desc;
	}


	


	
	
    
}
