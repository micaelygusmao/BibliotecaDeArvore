package lib;

import java.util.Comparator;

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(T novoValor) {

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
        return 0;
    }

    @Override
    public int quantidadeNos() {
        return 0;
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
