package repository;

public interface IRepository<T> {
    boolean register(T t);

    T search(String keyword);

    void edit(T t);

    String toString();
}
