package ssh.product.dao;

import java.util.List;

public interface BaseDao<T>{
    public void save(T t);

    public void deleteById(Integer id);

    public void setClazz1(Class clazz);

    public void update(T t);

    public T findById(Integer id);

}
