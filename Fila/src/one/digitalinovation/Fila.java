package one.digitalinovation;

public class Fila<T> {

    private No<T> refNoEntradaFila;
    //Referência de entrada pra fila, entrando pelo final dela

    public Fila() {
        this.refNoEntradaFila = null;
        //Estancio a fila vazia

    }


    //Métodos enqueue, dequeue e isEmpty
    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;

        //Recebi um novo nó, o novo nó entrou na fila, a referencia de novo nó era o antigo ultimo nó da fila
        //Agora ele vai referenciar o penultimo nó e esse novo nó será o ultimo nó da fila

    }

    public T first() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();

                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T dequeue() {
        if (!this.isEmpty()) {
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true) {
                if (primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();

                } else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }


    public boolean isEmpty() {
        return refNoEntradaFila == null ? true : false;
        //Método que analisa saber se a fila esta vazia
        //Se a referencia do (refNoEntradaFila) No for igual a null ela estará vazia.

    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;
        if (refNoEntradaFila != null) {
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }

        return stringRetorno;
    }

}
