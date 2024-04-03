package lib.model;

import lib.interfaces.IArvoreBinaria;

import java.util.Comparator;

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(T novoValor) {
        No<T> novoNo = new No<T>(novoValor);

        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            setPosicaoENovoValor(this.raiz, novoValor);
        }
    }

    public void setPosicaoENovoValor(No<T> no, T novoValor){
        if(comparador.compare(novoValor, no.getValor()) < 0){
            if(no.getFilhoEsquerda() == null){
                no.setFilhoEsquerda(new No<>(novoValor));
            } else {
                setPosicaoENovoValor(no.getFilhoEsquerda(), novoValor);
            }
        } else {
            if(no.getFilhoDireita() == null){
                no.setFilhoDireita(new No<>(novoValor));
            } else {
                setPosicaoENovoValor(no.getFilhoDireita(), novoValor);
            }
        }
    }

    @Override
    public T pesquisar(T valor) {
        return null;
    }

    public void  GetNoDaEsquerda(No<T> no, T valor){}

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        return null;
    }

    @Override
    public T remover(T valor) {
        No<T> noParaRemover = GetNoByValor(this.raiz, valor);

        if(noParaRemover.IsFolha()){
            //o nó que tinha ele como filho passa a apontar para null
            SetAlteracaoPai(noParaRemover, null);
        } else {
            if(noParaRemover.TemApenasUmFilho()){
                //o nó que tinha ele como filho passar ter o filho dele como filho
                if(noParaRemover.TemFilhoADireita()) {
                    SetAlteracaoPai(noParaRemover, noParaRemover.getFilhoDireita());
                    return valor;
                }

                if(noParaRemover.TemFilhoAEsquerda()) {
                    SetAlteracaoPai(noParaRemover, noParaRemover.getFilhoEsquerda());
                    return valor;
                }

                return valor;
            } else {
                //pegar o maior nó da subárvore da esquerda e copiar o valor do substituto para o nó que
                // está sendo removido e então remover o substituto da árvore.
            }
        }
        return null;
    }

    /**
     * Método para alterar o valor do nó filho de um nó pai
     * @param noParaRemover - nó que será removido, cujo valor será verificado.
     * @param novoFilho - nó que será utilizado para ser o novo filho do nó pai, pode ser null.
     */
    public void SetAlteracaoPai(No<T> noParaRemover, No<T> novoFilho){
        No<T> pai = GetNoPaiByFilho(this.raiz, noParaRemover.getValor());

        if(pai.TemFilhoAEsquerda() && IsNoDaBusca(pai.getFilhoEsquerda(), noParaRemover.getValor())){
            pai.setFilhoEsquerda(novoFilho);
        }

        if(pai.TemFilhoADireita() && IsNoDaBusca(pai.getFilhoDireita(), noParaRemover.getValor())){
            pai.setFilhoDireita(novoFilho);
        }
    }

    /**
     * Método para pegar o nó pai a partir de um nó filho
     * @param no - nó cujo valor será verificado.
     * @param valorFilho - valor do filho que está sendo usadno para buscar o pai.
     * @return o nó pai.
     */
    public No<T> GetNoPaiByFilho(No<T> no, T valorFilho) {
        if (no == null) { return null; }

        if(no.TemFilhoADireita() && comparador.compare(no.getFilhoEsquerda().getValor(), valorFilho) == 0){
            return no;
        }

        if(no.TemFilhoAEsquerda() && comparador.compare(no.getFilhoDireita().getValor(), valorFilho) == 0){
            return no;
        }

        No<T> pai = GetNoPaiByFilho(raiz.getFilhoDireita(), valorFilho);

        if (pai == null) {
            pai = GetNoPaiByFilho(raiz.getFilhoEsquerda(), valorFilho);
        }
        return pai;
    }

    /**
     * Método para achar o nó que tem o valor passado como parâmetro
     * @param no - nó cujo valor será verificado.
     * @param valor - valor que será utilizado para verificar o nó.
     * @return o nó que tem o valor passado por parâmetro.
     */
    public No<T> GetNoByValor(No<T> no, T valor){
        if(IsNoDaBusca(no, valor)){ return no;  }

        if(no.TemFilhoADireita() && IsValorNoMaior(no, valor)){ return GetNoByValor(no.getFilhoDireita(), valor); }

        if(no.TemFilhoAEsquerda() && IsValorNoMenor(no, valor)){  return GetNoByValor(no.getFilhoEsquerda(), valor); }

        return null;
    }

    /**
     * Método para verificar se o nó tem um valor maior que o valor passado como parâmetro
     * @param no - nó cujo valor será verificado.
     * @param valor - valor que será utilizado para verificar o nó.
     * @return caso o valor do nó seja maior o retorno é false, se não for retorno é true.
     */
    public boolean IsValorNoMaior(No<T> no, T valor){
        if(comparador.compare(no.getValor(), valor) > 0) { return true; }

        return false;
    }

    /**
     * Método para verificar se o nó tem um valor menor que o valor passado como parâmetro
     * @param no - nó cujo valor será verificado.
     * @param valor - valor que será utilizado para verificar o nó.
     * @return caso o valor do nó seja menor o retorno é false, se não for retorno é true.
     */
    public boolean IsValorNoMenor(No<T> no, T valor){
        if(comparador.compare(no.getValor(), valor) < 0) { return true; }

        return false;
    }

    /**
     * Método para verificar se o nó é o nó procurado
     * @param no - será utilizado para verificar se o nó é o procurado.
     * @return caso não seja o nó procurado o retorno é false, se for retorno é true.
     */
    public boolean IsNoDaBusca(No<T> no, T valor){
        if(no.getValor() != null){
            if(comparador.compare(valor, no.getValor()) == 0){  return true; }
            return false;
        }
        
        return false;
    }

    @Override
    public int altura() {
        int alturaEsquerda = AlturaDaEsquerda(this.raiz, 0);
        int alturaDireita = AlturaDaDireita(this.raiz, 0);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int AlturaDaEsquerda(No<T> no, int contd){
        if(no == null) return -1;

        if(no.getFilhoEsquerda() != null){
            contd = AlturaDaEsquerda(no.getFilhoEsquerda(), contd + 1);
        }

        return contd;
    }

    public int AlturaDaDireita(No<T> no, int contd){
        if(no == null) return -1;

        if(no.getFilhoDireita() != null){
            contd = AlturaDaDireita(no.getFilhoDireita(), contd + 1);
        }

        return contd;
    }


    @Override
    public int quantidadeNos() {
        return percorreTodaArvore(this.raiz);
    }

    private int percorreTodaArvore(No<T> no) {
        if (no == null) {
            return 0;
        }

        return 1 + percorreTodaArvore(no.getFilhoEsquerda()) + percorreTodaArvore(no.getFilhoDireita());
    }

    @Override
    public String caminharEmNivel() {
        return null;
    }

    @Override
    public String caminharEmOrdem() {
        return null;
    }
}
