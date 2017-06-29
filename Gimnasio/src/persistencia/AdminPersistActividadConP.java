package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.ActividadConProfesor;

public class AdminPersistActividadConP extends AdministradorPersistencia{
	
	private static AdminPersistActividadConP instancia;
	
	public AdminPersistActividadConP()
	{
		
	}
	
	public static AdminPersistActividadConP getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistActividadConP();
		return instancia;
	}
	
	
	
	public ActividadConProfesor buscarActividad(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			ActividadConProfesor actividad = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Actividades where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String desc = result.getString(2);
				Integer codProfe = result.getInt(3);
				
				actividad = new ActividadConProfesor(cod, desc, codProfe);
				
			}
			
			con.close();		
			return actividad;
			
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
			ActividadConProfesor act = (ActividadConProfesor)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Actividades values (?,?,?)");
			s.setInt(1, act.getIdActividad());
			s.setString(2, act.getDescripcion());
			s.setInt(3, act.getProfesor());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la actividad");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			ActividadConProfesor act = (ActividadConProfesor)o;
			PreparedStatement s = con.prepareStatement("update Actividades " +
					"set descripcion = ?," +
					"set profesorCodigo =?," +
					"where codigo =?");
			s.setString(1, act.getDescripcion());
			s.setInt(2,act.getProfesor());
			s.setInt(3, act.getIdActividad());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo actualizar la actividad");
		}
		
	}

	@Override
	public void delete(Object d) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			ActividadConProfesor act = (ActividadConProfesor)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Actividades where codigo = ?");
			s.setInt(1, act.getIdActividad());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar a la actividad");
		}
		

		
	}
	
	public Vector<ActividadConProfesor> selectAll()
	{
		try
		{
			
	
			Vector <ActividadConProfesor>rta = new Vector<ActividadConProfesor>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Actividades where profesorCodigo != 0";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codigo = result.getInt(1);
				String descripcion = result.getString(2);
				Integer codProfe = result.getInt(3);
				
				ActividadConProfesor act = new ActividadConProfesor(codigo, descripcion, codProfe);
				
				rta.add(act);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar las actividades");
		}
		return null;
	}

	
	


}

