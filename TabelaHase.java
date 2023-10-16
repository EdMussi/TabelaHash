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