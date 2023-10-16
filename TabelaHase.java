class TabelaHash {
    private int tamanho;
    private int capacidadeMaxima;
    private LinkedList<Elemento>[] tabela;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.capacidadeMaxima = tamanho * 2;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    public void doubleSize() {
        int size = this.tamanho * 2;
        LinkedList<Elemento>[] newTable = (LinkedList[]) new LinkedList[size];

        for (int i = 0; i < this.tamanho; i++) {
            if (this.tabela[i] != null) {
                newTable[i] = this.tabela[i];
            }
        }
        this.tabela = newTable;
        this.tamanho = size;
        this.capacidadeMaxima = size * 2;
    }

    public int hash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int chave, Object objeto) {
        int indice = hash(chave);
        if (tabela[indice].size() >= capacidadeMaxima) {
            doubleSize();
            indice = hash(chave);
        }
        tabela[indice].add(new Elemento(chave, objeto));
    }

    public Object buscar(int chave) {
        int indice = hash(chave);
        for (Elemento elemento : tabela[indice]) {
            if (elemento.getChave() == chave) {
                return elemento.getObjeto();
            }
        }
        return null;
    }

    public Object remover(int chave) {
        int indice = hash(chave);
        for (Elemento elemento : tabela[indice]) {
            if (elemento.getChave() == chave) {
                tabela[indice].remove(elemento);
                return elemento.getObjeto();
            }
        }
        return null;
    }

    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            if (tabela[i] != null) {
                for (Elemento elemento : tabela[i]) {
                    System.out.print("(" + elemento.getChave() + ", " + elemento.getObjeto() + ") ");
                }
            }
            System.out.println();
        }
    }

    class Elemento {
        private int chave;
        private Object objeto;

        public Elemento(int chave, Object objeto) {
            this.chave = chave;
            this.objeto = objeto;
        }

        public int getChave() {
            return chave;
        }

        public Object getObjeto() {
            return objeto;
        }
    }

    public double testeEficiencia(int chave, int numIteracoes) {
        double tempoEncadeamento = testeEncadeamento(chave, numIteracoes);
        double tempoSondagem = testeSondagem(chave, numIteracoes);

        System.out.println("Tempo (em segundos) usando Encadeamento: " + tempoEncadeamento);
        System.out.println("Tempo (em segundos) usando Sondagem Linear: " + tempoSondagem);

        return tempoEncadeamento - tempoSondagem;
    }

    private double testeEncadeamento(int chave, int numIteracoes) {
        long inicio = System.nanoTime();
        for (int i = 0; i < numIteracoes; i++) {
            buscar(chave);
        }
        long fim = System.nanoTime();
        return (fim - inicio) / 1e9;
    }

    private double testeSondagem(int chave, int numIteracoes) {
        long inicio = System.nanoTime();
        for (int i = 0; i < numIteracoes; i++) {
            buscarSondagem(chave);
        }
        long fim = System.nanoTime();
        return (fim - inicio) / 1e9;
    }

    private Object buscarSondagem(int chave) {
        int indice = hash(chave);
        for (int i = 0; i < tamanho; i++) {
            int novoIndice = (indice + i) % tamanho;
            for (Elemento elemento : tabela[novoIndice]) {
                if (elemento.getChave() == chave) {
                    return elemento.getObjeto();
                }
            }
        }
        return null;
    }

    public void imprimirTabelaSondagem() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Elemento elemento : tabela[i]) {
                System.out.print("(" + elemento.getChave() + ", " + elemento.getObjeto() + ") ");
            }
            System.out.println();
        }
    }

    public void imprimirTudo() {
        System.out.println("Tabela usando Encadeamento:");
        imprimirTabela();
        System.out.println("\nTabela usando Sondagem Linear:");
        imprimirTabelaSondagem();
    }
}