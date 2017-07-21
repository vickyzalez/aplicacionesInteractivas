package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Abono;

public class AdminPersistAbono extends AdministradorPersistencia{
	
	private static AdminPersistAbono instancia;
	
	public AdminPersistAbono()
	{
		
	}
	
	public static AdminPersistAbono getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistAbono();
		return instancia;
	}
	
	
	
	public Abono buscarAbono(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Abono abono = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Abonos where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String nombre = result.getString(2);
				Float precio = result.getFloat(3);
				String fecha = result.getString(4);
				
				abono = new Abono(cod, nombre, precio, fecha);
			}
			
			con.close();		
			return abono;
			
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
			Abono abono = (Abono)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Abonos values (?,?,?,?)");
			s.setInt(1, abono.getCodigo());
			s.setString(2, abono.getNombre());
			s.setFloat(3, abono.getPrecio());
			s.setString(4, abono.getVigencia());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar al abono");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			//no es neesario
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
			Abono abono = (Abono)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Abonos where codigo = ?");
			s.setInt(1, abono.getCodigo());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al abono");
		}
		

		
	}
	
	public Vector<Abono> selectAll()
	{
		try
		{
			
			Vector <Abono>rta = new Vector<Abono>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Abonos";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codigo = result.getInt(1);
				String nombre = result.getString(2);
				Float precio = result.getFloat(3);
				String fecha = result.getString(4);
				
				Abono abono = new Abono(codigo, nombre, precio, fecha);
				rta.add(abono);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudieron mostrar los abonos");
		}
		return null;
	}

	
	


}

