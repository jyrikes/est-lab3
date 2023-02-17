

public interface EstruturaDeDados<T> {
    public boolean insert(T chave);
    public boolean delete(T chave);
    public boolean search(T chave);
    public T minimum();
    public T maximum();
    public T sucessor(T chave);
    public T prodessor(T chave);
}