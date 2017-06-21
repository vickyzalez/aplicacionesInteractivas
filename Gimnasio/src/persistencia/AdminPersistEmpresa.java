package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import modelo.Empresa;

public class AdminPersistEmpresa extends AdministradorPersistencia{
	
	private static AdminPersistEmpresa instancia;
	
	public AdminPersistEmpresa()
	{
		
	}
	
	public static AdminPersistEmpresa getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistEmpresa();
		return instancia;
	}
	
	
	
	public Empresa buscarEmpresa(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Empresa emp = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Empresas where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer cod = result.getInt(1);
				String descrip = result.getString(2);
				
				emp = new Empresa(cod, descrip);
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
			Empresa emp = (Empresa)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Empresas values (?,?)");
			s.setInt(1, emp.getCodigo());
			s.setString(2, emp.getNombre());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la empresa");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
			//no es necesario el update
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
			Empresa emp = (Empresa)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Empresas where codigo = ?");
			s.setInt(1, emp.getCodigo());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar la empresa");
		}
		

		
	}
	
	public Vector<Empresa> selectAll()
	{
		try
		{
		
			Vector <Empresa>rta = new Vector<Empresa>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Empresas";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codigo = result.getInt(1);
				String descrip = result.getString(2);
				
				Empresa emp = new Empresa(codigo, descrip);
				rta.add(emp);
				
			}
			con.close();
			return rta;
		}
		catch(Exception e)
		{
			System.out.println("No se pudo mostrar las empresas");
		}
		return null;
	}

	
	


}

