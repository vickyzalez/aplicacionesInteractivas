package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConectorPersist {
	
	private static ConectorPersist pool;
	
	private ConectorPersist()
	{
	
	}
	
	public static ConectorPersist getInstance()
	{
		if (pool== null)
			pool =new ConectorPersist();
		return pool;
	}
	
	private Connection connect()
	{
		try
		{
            String userName = "user";
            String password = "pass";
            String url = "jdbc:sqlserver://bd:1433";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection con = DriverManager.getConnection (url, userName, password);

            return con;
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
            return null;
        }
		
	}
	
	public Connection getConnection(){
		Connection c = connect();
		return c;
	}

//	public void realeaseConnection(Connection c) throws SQLException{
//		c.close();
//	}

}
