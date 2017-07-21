package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Actividad;
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
				Integer idDep = result.getInt(1);
				Integer cod = result.getInt(2);
				String desc = result.getString(3);
				Integer codProfe = result.getInt(4);
				
				actividad = new ActividadConProfesor(idDep, cod, desc, codProfe);
				
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
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Actividades values (?,?,?,?)");
			s.setInt(1, act.getIdDeporte());
			s.setInt(2, act.getIdActividad());
			s.setString(3, act.getDescripcion());
			s.setInt(4, act.getProfesor());
			s.execute();
			con.close();

			insertDepAct(act.getIdActividad(), act.getIdDeporte());
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la actividad");
		}
		
		
	}

	public void insertDepAct(Integer idAct, Integer idDep) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Deporte_Actividad values (?,?)");
			s.setInt(1, idDep);
			s.setInt(2, idAct);
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
			PreparedStatement s = con.prepareStatement("update TPAI.dbo.Actividades " +
					"set idDep = ?, " +
					"descripcion = ?, " +
					"profesorCodigo = ? " +
					"where codigo = ? ");
			s.setInt(1, act.getIdDeporte());
			s.setString(2, act.getDescripcion());
			s.setInt(3,act.getProfesor());
			s.setInt(4, act.getIdActividad());
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
			Actividad act = (Actividad)d;
			
			deleteDepAct(act.getIdActividad());
			deleteActClase(act.getIdActividad());
			
			Connection con = ConectorPersist.getInstance().getConnection();
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
	
	public void deleteDepAct(Integer idAct) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Deporte_Actividad where codigoActividad = ?");
			s.setInt(1, idAct);
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar a la actividad");
		}
		
	}
	
	public void deleteActClase(Integer idAct) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Actividad_Clase where codigoActividad = ?");
			s.setInt(1, idAct);
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
			String senten = "Select * from TPAI.dbo.Actividades where profesorCodigo <> 0";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codDep = result.getInt(1);
				Integer codigo = result.getInt(2);
				String descripcion = result.getString(3);
				Integer codProfe = result.getInt(4);
				
				ActividadConProfesor act = new ActividadConProfesor(codDep, codigo, descripcion, codProfe);
				
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

