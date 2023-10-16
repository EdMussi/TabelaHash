import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TabelaHash tabela = new TabelaHash(3);

        tabela.inserir(10, "Objeto 1");
        tabela.inserir(6, "Objeto 2");
        tabela.inserir(10, "Objeto 3");
        tabela.inserir(20, "Objeto 4");
        tabela.inserir(90, "Objeto 5");

        tabela.imprimirTudo();

        System.out.print("\nDigite a chave que deseja buscar: ");
        int chaveBusca = scanner.nextInt();
        System.out.println("Buscando chave " + chaveBusca + ": " + tabela.buscar(chaveBusca));

        System.out.print("\nDigite a chave que deseja remover: ");
        int chaveRemocao = scanner.nextInt();
        System.out.println("Removendo chave " + chaveRemocao + ": " + tabela.remover(chaveRemocao));

        System.out.println("\nTabela após remoção:");
        tabela.imprimirTabela();

        System.out.println("\nTabela usando Sondagem Linear:");
        tabela.imprimirTabelaSondagem();

        int chaveParaBuscar = 11;
        int numIteracoes = 1000000;
        double diferencaTempo = tabela.testeEficiencia(chaveParaBuscar, numIteracoes);

        System.out.println("\nDiferença de tempo (Encadeamento - Sondagem): " + diferencaTempo + " segundos");

        tabela.doubleSize(); // Redimensiona a tabela
        System.out.println("\nTabela após redimensionamento:");
        tabela.imprimirTabela();
    }
}
