package one.digitalinovation;

public class ListaEncadeada<T> {


    //NO DE ENTRADA DA LISTA
    No<T> referenciaEntrada;

    //CONSTRUTOR PADRÃO E ESTANCIAR A CLASSE ListaEncadeada
    public ListaEncadeada (){

        this.referenciaEntrada = null;
    }


    //MÉTODO ADD - Vai adicionar um conteudo (no) na nossa lista
    public void add(T conteudo){ //receber um conteudo tipo generico
        No<T> novoNo = new No<>(conteudo); //nomeou o novo conteudo como novoNo
        if(this.isEmpty()){ //Verificando se a lista esta vazia se nao continua
            referenciaEntrada = novoNo;
            return;

        }

        No<T> noAuxiliar = referenciaEntrada; //Recebe a referencia de entrada igual a novoNo
        // corre um for do inicio da lista ate o tamanho dela (-1)
        for (int i = 0; i < this.size()-1; i++){
            noAuxiliar = noAuxiliar.getProximoNo(); // ele corre de no em no na lista pra quando ele
                                                    // chegar no final vai setar o proximo no como um
                                                    // novo no

        }

        noAuxiliar.setProximoNo(novoNo);

    }

    private No<T> getNo (int index){
        validaIndice(index);
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i < this.size()-1; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();

        }
        return noRetorno;

    }


    //MÉTODO SIZE retorna o tamanho da lista
    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (true){
            //TESTANDO SE A REFERENCIAUX É DIFERENTE DE NULO
            if(referenciaAux != null){
                tamanhoLista++; //Incrementando +1 no tamanho da lista para garantir pelo menos 1 incremento
                //TESTE para ReferenciaAux para saber se o proximo no é diferente de nulo
                if(referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();

                }else{
                    break;// CASO NAO TENHA UM NO JA É QUEBRADO
                }

            }else {
                break;

            }
        }
        return tamanhoLista;

    }

    private void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size() -1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice" + index + "desta lista. Esta lista só vai até o indice" + ultimoIndice + '.');

        }

    }

    //MÉTODO IsEmpty retornando se a lista esta vazia ou nao
    public boolean isEmpty(){

        return referenciaEntrada == null ? true : false;

    }

}
