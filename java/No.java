public class No<T> {
  private T objetct;
  private No proximoNo;
  private No noAnterior;

  public No getNoAnterior() {
    return noAnterior;
  }

  public void setNoAnterior(No noAnterior) {
    this.noAnterior = noAnterior;
  }

  public No() {
  }

  public No(T object) {
    this.proximoNo = null;
    this.noAnterior = null;
    this.objetct = object;
  }

  public T getObjetct() {
    return objetct;
  }

  public void setObjetct(T objetct) {
    this.objetct = objetct;
  }

  public No getProximoNo() {
    return proximoNo;
  }

  public void setProximoNo(No refNo) {
    this.proximoNo = refNo;
  }

  @Override
  public String toString() {
    return "" + objetct;
  }
}