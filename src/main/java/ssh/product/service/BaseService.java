package ssh.product.service;

public interface BaseService<T> {
    public void save(T t);

    public void update(T t);

    public T findById(Integer id);

    public void deleteById(Integer id);
}
