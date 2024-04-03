package lib.model;

public class No<T> {
    private T valor;
    private No<T> filhoDireita;
    private No<T> filhoEsquerda;


    public No(T valor){
        this.valor = valor;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
    }

    /**
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * @return the filhoDireita
     */
    public No<T> getFilhoDireita() {
        return filhoDireita;
    }

    /**
     * @param filhoDireita the filhoDireita to set
     */
    public void setFilhoDireita(No<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    /**
     * @return the filhoEsquerda
     */
    public No<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    /**
     * @param filhoEsquerda the filhoEsquerda to set
     */
    public void setFilhoEsquerda(No<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    /**
     * Método para verificar se o nó é uma folha
     * @return caso tenha filhos a esquerda e a direita o retorno é false, se não tiver o retorno é true.
     */
     boolean NoIsFolha(){
        if(this.NoTemFilhoAEsquerda() && this.NoTemFilhoADireita()) return true;

        return false;
    }

    /**
     * Método para verificar se o nó tem filho a esquerda
     * @return caso tenha filhos a esquerda o retorno é true, se não tiver o retorno é false.
     */
    boolean NoTemFilhoAEsquerda(){
        if(this.getFilhoEsquerda() != null) return true;

        return false;
    }

    /**
     * Método para verificar se o nó tem filho a direita
     * @return caso tenha filhos a direta o retorno é true, se não tiver o retorno é false.
     */
    boolean NoTemFilhoADireita(){
        if(this.getFilhoDireita() != null) return true;

        return false;
    }

    /**
     * Método para verificar se o nó tem apenas um filho
     * @return caso tenha um filho o retorno é true, se não tiver o retorno é false.
     */
    boolean NoTemApenasUmFilho(){
        if((this.NoTemFilhoAEsquerda() && !this.NoTemFilhoADireita()) ||
                (this.NoTemFilhoADireita() && !this.NoTemFilhoAEsquerda())){
            return true;
        }

        return false;
    }

    No<T> GetNoPaiByFilho() {

        return null;
    }
}
