package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import modelo.Socio;

public class AdminPersistSocio extends AdministradorPersistencia{
	
	private static AdminPersistSocio instancia;
	
	public AdminPersistSocio()
	{
		
	}
	
	public static AdminPersistSocio getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistSocio();
		return instancia;
	}
	
	
	
	public Socio buscarSocio(Integer dni)
	{
		try
		{			
			connect();
			Socio soc = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Socios where dni = ?");
			s.setInt(1,dni);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer deenei = result.getInt(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String domicilio = result.getString(4);
				Integer telefono = result.getInt(5);
				String mail = result.getString(6);
				String fechaCertificado = result.getString(7);
				String nombreProfesional = result.getString(8);
				String observaciones = result.getString(9);
				
				soc = new Socio(deenei, nombre, apellido, domicilio, telefono, mail);
				soc.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);
						
			}
			
			return soc;
			
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
			connect();
			Socio soc = (Socio)o;
			PreparedStatement s = con.prepareStatement("insert into Socios values (?,?,?,?,?,?,?,?,?,?)");
			//agregar campos
			s.setInt(1, soc.getDni());
			s.setString(2, soc.getNombre());
			s.setString(3,soc.getApellido());
			s.setString(4, soc.getDomicilio());
			s.setInt(5,soc.getTelefono());
			s.setString(6, soc.getMail());
			s.setString(7,soc.getAm().getFechaCertificado());
			s.setString(8, soc.getAm().getNombreProfesional());
			s.setString(9,soc.getAm().getObservaciones());
			s.setString(10, soc.getAm().getFechaFin());
			s.execute();
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
			connect();
			Socio soc = (Socio)o;
			PreparedStatement s = con.prepareStatement("update Socios " +
					"set nombre = ?," +
					"set apellido = ?," +
					"set domicilio =?," +
					"set telefono =?," +
					"set mail =?," +
					"set aptoFecha =?," +
					"set aptoPrf = ?," +
					"set aptoObs =?," +
					"set aptoFin =?" +
					"where dni =?");
			//agregar campos
			s.setString(1, soc.getNombre());
			s.setString(2,soc.getApellido());
			s.setString(3, soc.getDomicilio());
			s.setInt(4,soc.getTelefono());
			s.setString(5, soc.getMail());
			s.setString(6,soc.getAm().getFechaCertificado());
			s.setString(7, soc.getAm().getNombreProfesional());
			s.setString(8,soc.getAm().getObservaciones());
			s.setString(9, soc.getAm().getFechaFin());
			s.setInt(10, soc.getDni());
			s.execute();
		}
		catch (Exception e)
		{
			System.out.println();
		}
		
	}

	@Override
	public void delete(Object d) {
		try
		{
			connect();
			Socio soc = (Socio)d;
			PreparedStatement s = con.prepareStatement("delete from Socios where codigo = ?");
			s.setInt(1, soc.getDni());
			s.execute();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al socio");
		}
		

		
	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}


}

