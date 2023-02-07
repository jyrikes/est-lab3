

public interface EstruturaDeDados {
    public boolean insert(int chave);
    public boolean delete(int chave);
    public boolean search(int chave);
    public int minimum();
    public int maximum();
    public int sucessor(int chave);
    public int prodessor(int chave);
}