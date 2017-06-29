package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Clase;

public class AdminPersistClase extends AdministradorPersistencia{
	
	private static AdminPersistClase instancia;
	
	public AdminPersistClase()
	{
		
	}
	
	public static AdminPersistClase getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistClase();
		return instancia;
	}
	
	
	
	public Clase buscarClase(Integer id)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Clase clase = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Clases where idClase = ?");
			s.setInt(1,id);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer idClase = result.getInt(1);
				Integer horaDesde = result.getInt(2);
				Integer horaHasta = result.getInt(3);
				Integer idDia = result.getInt(4);
				
				clase = new Clase(idClase, horaDesde, horaHasta, idDia);
				
			}
			
			con.close();		
			return clase;
			
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
			Clase clase = (Clase)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Clases values (?,?,?,?)");
			s.setInt(1, clase.getIdClase());
			s.setInt(2, clase.getHoraDesde());
			s.setInt(3, clase.getHoraHasta());
			s.setInt(4, clase.getDia());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la clase");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Clase clase = (Clase)o;
			PreparedStatement s = con.prepareStatement("update Clases " +
					"set horaDesde = ?," +
					"set horaHasta =?," +
					"set idDia =?," +
					"where idClase =?");
			s.setInt(1, clase.getHoraDesde());
			s.setInt(2,clase.getHoraHasta());
			s.setInt(3, clase.getDia());
			s.setInt(4, clase.getIdClase());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo actualizar la clase");
		}
		
	}

	@Override
	public void delete(Object d) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			Clase clase = (Clase)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Clases where idClase = ?");
			s.setInt(1, clase.getIdClase());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar a la clase");
		}
		

		
	}
	
	public Vector<Clase> selectAll()
	{
		try
		{
			
	
			Vector <Clase>rta = new Vector<Clase>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Clases";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer idClase = result.getInt(1);
				Integer horaDesde = result.getInt(2);
				Integer horaHasta = result.getInt(3);
				Integer idDia = result.getInt(4);

				Clase clase = new Clase(idClase, horaDesde, horaHasta, idDia);
				
				rta.add(clase);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar las clases");
		}
		return null;
	}

	
	


}

