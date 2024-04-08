import app.comparators.ComparadorAlunoPorMatricula;
import app.comparators.ComparadorAlunoPorNome;
import app.model.Aluno;
import app.service.GeradorDeArvores;
import lib.interfaces.IArvoreBinaria;
import lib.model.ArvoreBinaria;

/**
 *
 * @author micaelygusmao
 *
 * Classe principal do aplicativo a ser utilizado para fazer testes próprios
 * de árvore binária. Favor desconsiderar para avaliação.
 */
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        GeradorDeArvores gerador = new GeradorDeArvores();
        ComparadorAlunoPorMatricula compPorMatricula = new ComparadorAlunoPorMatricula();
        ComparadorAlunoPorNome compPorNome = new ComparadorAlunoPorNome();
        IArvoreBinaria<Aluno> arv;

        arv = new ArvoreBinaria<>(compPorMatricula);

        //gerador.geraArvorePerfeitamenteBalanceada(1,6,arv);

        //System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());

        Aluno al1 = new Aluno(15,"Aluno 1");
        Aluno al2 = new Aluno(8,"Aluno 2");
        Aluno al3 = new Aluno(17,"Aluno 3");
        Aluno al4 = new Aluno(6,"Aluno 4");
        Aluno al5 = new Aluno(9,"Aluno 5");
        Aluno al6 = new Aluno(10,"Aluno 6");
        Aluno al7 = new Aluno(5,"Aluno 7");
        Aluno al8 = new Aluno(7,"Aluno 8");

        arv.adicionar(al1);
        arv.adicionar(al2);
        arv.adicionar(al3);
        arv.adicionar(al4);
        arv.adicionar(al5);
        arv.adicionar(al6);
        arv.adicionar(al7);
        arv.adicionar(al8);

        System.out.println(arv.caminharEmNivel());

        //System.out.println(arv.caminharEmOrdem());
//
//        System.out.println("Árvore Perfeitamente Balanceada Criada");
//        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
//
//        System.out.println("Valor encontrado:" + arv.pesquisar(al5).getMatricula());
//        System.out.println("Valor encontrado:" + arv.pesquisar(al1, compPorNome).getMatricula());



    }
}