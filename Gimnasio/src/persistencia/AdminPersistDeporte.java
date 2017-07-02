package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Actividad;
import modelo.Deporte;

public class AdminPersistDeporte extends AdministradorPersistencia{
	
	private static AdminPersistDeporte instancia;
	
	public AdminPersistDeporte()
	{
		
	}
	
	public static AdminPersistDeporte getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistDeporte();
		return instancia;
	}
	
	
	
	public Deporte buscarDeporte(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Deporte deporte = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Deportes where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String titulo = result.getString(2);
				String descripcion = result.getString(3);
				
				deporte = new Deporte(cod, titulo, descripcion);
			}
			
			con.close();		
			return deporte;
			
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
			Deporte dep = (Deporte)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Deporte values (?,?,?)");
			s.setInt(1, dep.getCodigo());
			s.setString(2, dep.getTitulo());
			s.setString(3,dep.getDescripcion());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar al deporte");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Deporte dep = (Deporte)o;
			PreparedStatement s = con.prepareStatement("update Deportes " +
					"set titulo = ?," +
					"set descripcion =?," +
					"where codigo =?");
			s.setString(1, dep.getTitulo());
			s.setString(2,dep.getDescripcion());
			s.setInt(3, dep.getCodigo());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo actualizar al deporte");
		}
		
	}

	@Override
	public void delete(Object d) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Deporte dep = (Deporte)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Deportes where codigo = ?");
			s.setInt(1, dep.getCodigo());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al deporte");
		}
		

		
	}
	
	public Vector<Deporte> selectAll()
	{
		try
		{
			
	
			Vector <Deporte>rta = new Vector<Deporte>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Deportes";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codigo = result.getInt(1);
				String titulo = result.getString(2);
				String descripcion = result.getString(3);
				
				Deporte dep = new Deporte(codigo, titulo, descripcion);
				
				rta.add(dep);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar los deportes");
		}
		return null;
	}
	
	public Vector<Integer> mostrarActividades(Integer idDep)
	{
		try
		{
			
	
			Vector <Integer>rta = new Vector<Integer>();
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement( "Select * from TPAI.dbo.Deporte_Actividad where codigoDeporte = ?");
			s.setInt(1,idDep);
			ResultSet result = s.executeQuery();
			
			while (result.next())
			{
				Integer codigo = result.getInt(2);
				
				rta.add(codigo);
				
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

