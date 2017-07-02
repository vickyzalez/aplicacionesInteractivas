package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.ClaseAct;

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
	
	
	
	public ClaseAct buscarClase(Integer id)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			ClaseAct clase = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Clases where idClase = ?");
			s.setInt(1,id);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer idAct = result.getInt(1);
				Integer idClase = result.getInt(2);
				Integer horaDesde = result.getInt(3);
				Integer horaHasta = result.getInt(4);
				Integer idDia = result.getInt(5);
				
				clase = new ClaseAct(idAct, idClase, horaDesde, horaHasta, idDia);
				
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
			ClaseAct clase = (ClaseAct)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Clases values (?,?,?,?,?)");
			s.setInt(1, clase.getIdAct());
			s.setInt(2, clase.getIdClase());
			s.setInt(3, clase.getHoraDesde());
			s.setInt(4, clase.getHoraHasta());
			s.setInt(5, clase.getDia());
			s.execute();
			con.close();
			
			insertActClas(clase.getIdAct(), clase.getIdClase());
			
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la clase");
		}
		
		
	}

	public void insertActClas(Integer idAct, Integer idClase) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Actividad_Clase values (?,?)");
			s.setInt(1, idAct);
			s.setInt(2, idClase);
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
			ClaseAct clase = (ClaseAct)o;
			PreparedStatement s = con.prepareStatement("update Clases " +
					"set idAct = ?," +
					"set horaDesde = ?," +
					"set horaHasta =?," +
					"set idDia =?," +
					"where idClase =?");
			s.setInt(1, clase.getIdAct());
			s.setInt(2, clase.getHoraDesde());
			s.setInt(3,clase.getHoraHasta());
			s.setInt(4, clase.getDia());
			s.setInt(5, clase.getIdClase());
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
			ClaseAct clase = (ClaseAct)d;
			//Se elimina de Actividad_Clase
			deleteActClase(clase.getIdClase());
			
			Connection con = ConectorPersist.getInstance().getConnection();
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
	
	public void deleteActClase(Integer idClase) {
		try
		{
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Actividad_Clase where codigoClase = ?");
			s.setInt(1, idClase);
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar a la clase");
		}
		
	}
	
	
	public Vector<ClaseAct> selectAll()
	{
		try
		{
			
	
			Vector <ClaseAct>rta = new Vector<ClaseAct>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Clases";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer idAct = result.getInt(1);
				Integer idClase = result.getInt(2);
				Integer horaDesde = result.getInt(3);
				Integer horaHasta = result.getInt(4);
				Integer idDia = result.getInt(5);

				ClaseAct clase = new ClaseAct(idAct, idClase, horaDesde, horaHasta, idDia);
				
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

	
	public Vector<Integer> mostrarClases(Integer idAct)
	{
		try
		{
			
	
			Vector <Integer>rta = new Vector<Integer>();
			Connection con = ConectorPersist.getInstance().getConnection();
			PreparedStatement s = con.prepareStatement( "Select * from TPAI.dbo.Actividad_Clase where codigoActividad = ?");
			s.setInt(1,idAct);
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
			System.out.println("No se pudo mostrar las clases");
		}
		return null;
	}


}

