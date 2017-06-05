package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;


public abstract class AdministradorPersistencia 
{
	public abstract void insert (Object o);
	public abstract void update (Object o);
	public abstract void delete (Object d);
	public abstract Vector<Object> select (Object o);
	
	protected Connection con;
	

	
	public void connect()
	{
		try
		{
            String userName = "";
            String password = "";
            String url = "";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection (url, userName, password);
           
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
        }
		
	}


}
