package one.digitalinovation;

public class No<T> {
//refatorando o No, aceitando agora um tipo generico de objeto
    //porem assim que a classe Fila for declarada ela sera amarrada
    //para um so tipo (so strings ou so inteiros)
    private T object;
    private No<T> refNo;

    public No(){

    }
    public No(T object){
        this.refNo = null;
        this.object = object;

    }

    public Object getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "object=" + object +
                '}';
    }
}
