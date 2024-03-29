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

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        return null;
    }

    @Override
    public T remover(T valor) {
        return null;
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
