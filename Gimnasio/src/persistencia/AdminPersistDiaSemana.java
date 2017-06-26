package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.DiaSemana;

public class AdminPersistDiaSemana extends AdministradorPersistencia{
	
	private static AdminPersistDiaSemana instancia;
	
	public AdminPersistDiaSemana()
	{
		
	}
	
	public static AdminPersistDiaSemana getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistDiaSemana();
		return instancia;
	}
	
	
	
	public DiaSemana buscarSocio(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			DiaSemana dia = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.DiaSemana where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String nombre = result.getString(2);
				
				dia = new DiaSemana(nombre, cod);
			
			}
			
			con.close();		
			return dia;
			
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
			//no se necesita
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar al socio");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{

			//no se necesita
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

			//no se necesita
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al socio");
		}
		

		
	}
	
	public Vector<DiaSemana> selectAll()
	{
		try
		{
			
	
			Vector <DiaSemana>rta = new Vector<DiaSemana>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.DiaSemana";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String nombre = result.getString(2);
				
				DiaSemana dia = new DiaSemana(nombre, cod);
				rta.add(dia);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar los socios");
		}
		return null;
	}

	
	


}

