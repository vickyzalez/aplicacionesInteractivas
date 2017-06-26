package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.ProfesorConSueldo;

public class AdminPersistProfesorSueldo extends AdministradorPersistencia{
	
	private static AdminPersistProfesorSueldo instancia;
	
	public AdminPersistProfesorSueldo()
	{
		
	}
	
	public static AdminPersistProfesorSueldo getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistProfesorSueldo();
		return instancia;
	}
	
	
	
	public ProfesorConSueldo buscarProfesorSueldo(Integer dni)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			ProfesorConSueldo prof = null;
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
				
				prof = new ProfesorConSueldo(deenei, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
			}
			
			con.close();		
			return prof;
			
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
			ProfesorConSueldo prof = (ProfesorConSueldo)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Contratados values (?,?,?,?,?,?,?,?,?,?)");
			s.setInt(1, prof.getDni());
			s.setString(2, prof.getNombre());
			s.setString(3,prof.getApellido());
			s.setString(4, prof.getDomicilio());
			s.setString(5, prof.getMail());
			s.setFloat(6,prof.getSueldo());
			s.setFloat(7, prof.getRetencion());
			s.setFloat(8,prof.getImpuesto());
			s.setString(9, "Profesor");
			s.setFloat(10,0);
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar al profesor");
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
			ProfesorConSueldo prof = (ProfesorConSueldo)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Contratados where dni = ?");
			s.setInt(1, prof.getDni());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al profesor");
		}
		

		
	}
	
	public Vector<ProfesorConSueldo> selectAll()
	{
		try
		{
			
	
			Vector <ProfesorConSueldo>rta = new Vector<ProfesorConSueldo>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Contratados where tipo = 'Profesor' and valorHora = 0";
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
				
					ProfesorConSueldo emp = new ProfesorConSueldo(deenei, nombre, apellido, domicilio, mail, sueldo, retencion, impuesto);
					rta.add(emp);			
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar los profesores");
		}
		return null;
	}

	
	


}

