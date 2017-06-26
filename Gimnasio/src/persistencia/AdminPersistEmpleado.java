package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Empleado;

public class AdminPersistEmpleado extends AdministradorPersistencia{
	
	private static AdminPersistEmpleado instancia;
	
	public AdminPersistEmpleado()
	{
		
	}
	
	public static AdminPersistEmpleado getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistEmpleado();
		return instancia;
	}
	
	
	
	public Empleado buscarEmpleado(Integer dni)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Empleado emp = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Contratados where dni = ?");
			s.setInt(1,dni);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer deenei = result.getInt(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String domicilio = result.getString(4);
				String mail = result.getString(5);
				Float sueldo = result.getFloat(6);
				Float retencion = result.getFloat(7);
				Float impuesto = result.getFloat(8);
				
				emp = new Empleado(deenei, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
			}
			
			con.close();		
			return emp;
			
		}
		catch (Exception e)
		{
			System.out.println("Error Query: " + e.getMessage());
			return null;
		}
	}

	@Override
	public void insert(Object o) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Empleado emp = (Empleado)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Contratados values (?,?,?,?,?,?,?,?,?,?)");
			s.setInt(1, emp.getDni());
			s.setString(2, emp.getNombre());
			s.setString(3,emp.getApellido());
			s.setString(4, emp.getDomicilio());
			s.setString(5, emp.getMail());
			s.setFloat(6,emp.getSueldo());
			s.setFloat(7, emp.getRetencion());
			s.setFloat(8,emp.getImpuesto());
			s.setString(9, "Empleado");
			s.setFloat(10,0);
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar al empleado");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			//no es necesario
		}
		catch (Exception e)
		{
			System.out.println("No se pudo actualizar al socio");
		}
		
	}

	@Override
	public void delete(Object d) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Empleado emp = (Empleado)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Contratados where dni = ?");
			s.setInt(1, emp.getDni());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al empleado");
		}
		

		
	}
	
	public Vector<Empleado> selectAll()
	{
		try
		{
			
	
			Vector <Empleado>rta = new Vector<Empleado>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Contratados where tipo = 'Empleado'";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer deenei = result.getInt(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String domicilio = result.getString(4);
				String mail = result.getString(5);
				Float sueldo = result.getFloat(6);
				Float retencion = result.getFloat(7);
				Float impuesto = result.getFloat(8);
				
					Empleado emp = new Empleado(deenei, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
					rta.add(emp);			
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar los empleados");
		}
		return null;
	}

	
	


}

