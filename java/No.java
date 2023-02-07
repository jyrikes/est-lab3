public class No{
    private int valor;
    private No proximo;

    public No(int valor) {
        this.valor = valor;
        proximo = null;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No novo) {
        proximo = novo;
    }

    public int getValor() {
        return valor;
    }
}