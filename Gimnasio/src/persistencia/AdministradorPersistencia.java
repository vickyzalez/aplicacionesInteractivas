package persistencia;

public abstract class AdministradorPersistencia 
{
	public abstract void insert (Object o);
	public abstract void update (Object o);
	public abstract void delete (Object d);
//	public abstract Vector<Object> select (Object o);
	

}
