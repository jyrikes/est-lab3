import java.lang.module.FindException;

import javax.lang.model.type.NullType;

public class ListaLigada<T> implements EstruturaDeDados{
  private No<T> noComeco ;
  private No<T> noAtual ;
  private int tamanho ;
  private T maximo;
  private T minimo;

  public ListaLigada() {
    
    this.noComeco = null;
    this.tamanho = 0;
    this.noAtual = null;
  }


  
  @Override
  public boolean insert (Object chave){
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
 @Override 
 public T maximum(){
  return this.maximo; 
 }

 @Override
 public T minimum(){
  return this.minimo;
 }
  @Override
  public boolean delete(Object chave){
    if(!this.isEmpty()){
      if(chave.equals(this.noComeco.getObjetct())){
        No<T> segundoNo = this.noComeco.getProximoNo();
        this.noComeco = segundoNo;
        this.tamanho = this.tamanho -1;
        this.atl_min_max();
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
        
        this.atl_min_max();
        return true;

      }
      
    }
   return false;
  }
@Override
public T sucessor(Object chave){
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
@Override
public T prodessor(Object chave){
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
  private void atl_min_max(){
    Integer max = Integer.MIN_VALUE;
    Integer mim = Integer.MAX_VALUE;
    
    No<T> key = this.noComeco;
    for(int i = 0; i< this.tamanho; i++){
      try {
 
        if((Integer)key.getObjetct()> max){
          this.maximo = key.getObjetct();
          max = (Integer)key.getObjetct();
          
        }
        if ((Integer)key.getObjetct()< mim){
          this.minimo = key.getObjetct();
           mim = (Integer)key.getObjetct();
          
        }
        key = key.getProximoNo();
      
      
        
      } catch (Exception e) {
        System.out.println(e);
      }}

  }
  public No<T> find(Object chave){
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
  @Override
  public boolean search (Object chave){
    
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

public static void main(String[] args) {
  ListaLigada<Integer>  lista = new ListaLigada<>();
  lista.insert(10);
  lista.insert(20);
  lista.insert(30);
  lista.insert(40);
  System.out.println(lista);
  lista.delete(10);
  System.out.println(lista);
  lista.insert(10);
  System.out.println(lista);
  lista.delete(40);
  System.out.println(lista);
  System.out.println(lista.maximum());
  System.out.println(lista.minimum());
}

 
}
