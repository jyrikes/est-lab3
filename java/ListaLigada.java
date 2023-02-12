import javax.lang.model.type.NullType;

public class ListaLigada implements EstruturaDeDados{
    
    private No<T> noComeco ;
    private No<T> noAtual ;
    private int tamanho ;
    private T maximo;
    private T minimo;
  
    public ListaEnca() {
      
      this.noComeco = null;
      this.tamanho = 0;
      this.noAtual = null;
    }
  
  
    
  
    public boolean insert (T chave){
      try {
        No novoNo = new No(chave);
      if(this.isEmpty()){
        this.noComeco = novoNo;
        this.tamanho = this.tamanho+1;
        this.noAtual = noComeco;
        this.maximo=  noComeco.getObjetct();
        this.minimo = noComeco.getObjetct();
        return true;
      }
      No<T> noAgora = noAtual;
      No<T> noAuxiliarAnterior = noAgora;
      noAgora.setProximoNo(novoNo);
      noAgora = novoNo;
      noAgora.setNoAnterior(noAuxiliarAnterior);
      this.noAtual = noAgora;
      this.tamanho = this.tamanho +1;
  
  try {
    Integer key = (Integer)chave;
    Integer max = (Integer) maximo;
    Integer mim = (Integer) minimo;
    if(key> max){
      this.maximo = (T)key;
    }
    if (key < mim){
      this.minimo = (T)key;
    }
  
  
    
  } catch (Exception e) {
    return true;
  }
       
      
      return true;
  
      } catch (Exception e) {
        return false;
      }
    
  
    }
   private boolean verificaTipo(String tipo){
    boolean verifica =this.getClass().getTypeName().equals(tipo);
    return verifica;
  }
    
   public T maximum(){
    return this.maximo; 
   }
  
   public T minimum(){
    return this.minimo;
   }
    public boolean delete(T chave){
      if(!this.isEmpty()){
        if(chave.equals(this.noComeco.getObjetct())){
          No<T> segundoNo = this.noComeco.getProximoNo();
          this.noComeco = segundoNo;
          this.tamanho = this.tamanho -1;
          return true;
        }
        No<T> noParaDeletar = this.find(chave);
        if(noParaDeletar != null){
          
          if (noParaDeletar.getProximoNo() !=null){
            No<T> anterior = noParaDeletar.getNoAnterior();
            No<T> proximo = noParaDeletar.getProximoNo();
            anterior.setProximoNo(proximo);
            proximo.setNoAnterior(anterior);
            this.tamanho = this.tamanho -1;
          }
          else{
            No<T> anterior = noParaDeletar.getNoAnterior();
            anterior.setProximoNo(null);
            noParaDeletar.setNoAnterior(null);
  
          }
          
  
        return true;
  
        }
        
      }
     return false;
    }
  public T sucessor(T chave){
    try {
      if(!isEmpty()){
        No<T> noChave = this.find(chave);
        if(noChave.getProximoNo()!=null){
          No<T> proximoNo = noChave.getProximoNo();
          return (T) proximoNo.getObjetct();
        }
        return null;
        
      }
    
      return null;
      
    } catch (Exception e) {
      return null;
    }
  
  }
  public T predecessor(T chave){
    try {
      if(!isEmpty()){
        No<T> noChave = this.find(chave);
        if(noChave.getNoAnterior()!=null){
          No<T> anterior = noChave.getNoAnterior();
          return (T) anterior.getObjetct();
        }
        return null;
      }
    }
    catch (Exception e) {
      return null;
    }
    return null;
  
  }
    public No<T> find(T chave){
      if(chave.equals(this.noComeco.getObjetct())){
   
        return noComeco;
      }
      No<T> referencia = this.noComeco;
      No<T> referenciaProximo = referencia.getProximoNo();
      if (!this.isEmpty()){
        for(int i = 0 ; i< this.tamanho -1; i++){
          if(referenciaProximo.getObjetct().equals(chave)){
            if(referencia.getProximoNo() == null){
              return referencia;
            }
            return referencia.getProximoNo();
          }
          if(referenciaProximo.getObjetct() == (null)){
            return null;
          }
          referencia = referenciaProximo;
          referenciaProximo = referencia.getProximoNo();
          
        }
  
      }
      return referencia;
    }
    public boolean search (T chave){
      
      if(!this.isEmpty()){
        if(chave.equals(this.noComeco.getObjetct())){
        
          return true;
        }
        No<T> referencia = this.noComeco;
        No<T> referenciaProximo = referencia.getProximoNo();
        for(int i = 0 ; i< this.tamanho-1; i++){
          if(referenciaProximo.getObjetct().equals(chave)){
            
            return true;
          }
          if(referenciaProximo.getObjetct() == (null)){
            return false;
          }
          referencia = referenciaProximo;
          referenciaProximo = referencia.getProximoNo();
          
        }
      } 
      return false;
    }
  
    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = noComeco;
        for(int i = 0; i < this.tamanho; i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getObjetct() +"}]--->";
            noAuxiliar = noAuxiliar.getProximoNo();
            if (noAuxiliar == null){
              break;
            }
        }
        strRetorno += "null";
        return strRetorno;
    }
  
    public boolean isEmpty(){
      return this.noComeco == null ? true : false;
  }
  }
  