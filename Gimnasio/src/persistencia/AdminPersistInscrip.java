package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;

import modelo.Inscripcion;
import modelo.InscripcionCorporativa;
import modelo.InscripcionNormal;

public class AdminPersistInscrip extends AdministradorPersistencia{
	
	private static AdminPersistInscrip instancia;
	
	public AdminPersistInscrip()
	{
		
	}
	
	public static AdminPersistInscrip getInstancia()
	{
		if (instancia == null)
			instancia = new AdminPersistInscrip();
		return instancia;
	}
	
	
	
	public Inscripcion buscarInscrip(Integer codigo)
	{
		try
		{			
			Connection con = ConectorPersist.getInstance().getConnection();
			Inscripcion insc = null;
			PreparedStatement s = con.prepareStatement("select * from TPAI.dbo.Inscripciones where codigo = ?");
			s.setInt(1,codigo);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				Integer codigoIns = result.getInt(1);
				Integer dniSocio = result.getInt(2);
				Integer codAbono = result.getInt(3);
				Integer codEmpresa = result.getInt(4);
				Date fecha = result.getDate(5);
				
				if (codEmpresa == 0){
					insc = new InscripcionNormal(codigoIns, dniSocio, codAbono);
				} else {
					insc = new InscripcionCorporativa(codigoIns, dniSocio, codAbono, codEmpresa, fecha);
				}
			}
			
			con.close();		
			return insc;
			
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
			Inscripcion inscripcion = (Inscripcion)o;
			PreparedStatement s = con.prepareStatement("insert into TPAI.dbo.Inscripciones values (?,?,?,?)");
			s.setInt(1, inscripcion.getCodigo());
			s.setInt(2, inscripcion.getDniSocio());
			s.setInt(3, inscripcion.getCodigoAbono());
			
			if (inscripcion instanceof InscripcionCorporativa){
				s.setInt(4, ((InscripcionCorporativa) inscripcion).getCodEmpresa());
				s.setDate(5, ((InscripcionCorporativa) inscripcion).getFecha());
			} else {
				s.setInt(3, 0);
			}
			
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo insertar la nueva inscripcion");
		}
		
		
	}

	@Override
	public void update(Object o) {
		try
		{
	//No es necesario en update
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
			Inscripcion insc = (Inscripcion)d;
			PreparedStatement s = con.prepareStatement("delete from TPAI.dbo.Inscripciones where codigo = ?");
			s.setInt(1, insc.getCodigo());
			s.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println("No se pudo eliminar la inscripcion");
		}
		

		
	}
	
	public Vector<Inscripcion> selectAll()
	{
		try
		{
			Vector <Inscripcion>rta = new Vector<Inscripcion>();
			Connection con = ConectorPersist.getInstance().getConnection();
			Statement s = con.createStatement();
			String senten = "Select * from TPAI.dbo.Inscripcion";
			ResultSet result = s.executeQuery(senten);
			while (result.next())
			{
				Integer codigoIns = result.getInt(1);
				Integer dniSocio = result.getInt(2);
				Integer codAbono = result.getInt(3);
				Integer codEmpresa = result.getInt(4);
				Date fecha = result.getDate(5);
				
				if (codEmpresa == 0){
					InscripcionNormal insc = new InscripcionNormal(codigoIns, dniSocio, codAbono);
					rta.add(insc);
				} else {
					InscripcionCorporativa insc = new InscripcionCorporativa(codigoIns, dniSocio, codAbono, codEmpresa, fecha);
					rta.add(insc);
				}
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

