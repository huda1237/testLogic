package co.id.test.sales.Dao;

import java.util.List;

public interface PerentInterfaceDao {
    public <T> T insert( Object[] data, Class<T> tClass);
    public <T> T get( Object[] data, Class<T> tClass);

    public <T> List<T> getAll( Class<T> tClass);
    public <T> T update( Object[] data );
    public <T> T delete( Object[] data);
}
