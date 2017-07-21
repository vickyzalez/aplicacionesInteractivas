package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			Connection con = ConectorPersist.getInstance().getConnection();
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
				Integer codigoIns = result.getInt(10);
				
				soc = new Socio(deenei, nombre, apellido, domicilio, telefono, mail);
				if (!nombreProfesional.toString().isEmpty()){
				soc.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);}
				soc.inscribirSocio(codigoIns);
			}
			
			con.close();		
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
			Connection con = ConectorPersist.getInstance().getConnection();
			Socio soc = (Socio)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Socios values (?,?,?,?,?,?,?,?,?,?)");
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
			con.close();
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
			Connection con = ConectorPersist.getInstance().getConnection();
			Socio soc = (Socio)o;
			PreparedStatement s = con.prepareStatement("update TPAI.dbo.Socios " +
					"set nombre = ?, " +
					"apellido = ?, " +
					"domicilio = ?, " +
					"telefono = ?, " +
					"mail = ?, " +
					"fechaCertificado = ?, " +
					"nombreProfesional = ?, " +
					"observaciones = ?, " +
					"fechaFin = ? " +
					"where dni = ?");
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
			con.close();
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
			Socio soc = (Socio)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Socios where dni = ?");
			s.setInt(1, soc.getDni());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar al socio");
		}
		

		
	}
	
	public Vector<Socio> selectAll()
	{
		try
		{
			
	
			Vector <Socio>rta = new Vector<Socio>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Socios";
			ResultSet result = s.executeQuery(senten);
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
				
				Socio soc = new Socio(deenei, nombre, apellido, domicilio, telefono, mail);
				if (!fechaCertificado.isEmpty()){
					
				soc.agregarAptoMedico(fechaCertificado, nombreProfesional, observaciones);
				}
				rta.add(soc);
				
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

