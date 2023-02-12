

public interface EstruturaDeDados {
    public boolean insert(int chave);
    public boolean delete(int chave);
    public boolean search(int chave);
    public T minimum();
    public T maximum();
    public T sucessor(int chave);
    public T prodessor(int chave);
}