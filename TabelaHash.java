package Tabela;

public class TabelaHash {

    public static class TabelaEntrada {
        String chave;
        int valor;

        public TabelaEntrada(String chave, int valor) { // construtor
            this.chave = chave;
            this.valor = valor;
        }
    }

    public TabelaEntrada[] tabela;

    public TabelaHash(int capacidade) {
        tabela = new TabelaEntrada[capacidade];
    }

    public void put(String chave, int valor) {
        int hash = Math.abs(chave.hashCode());
        int indice = hash % tabela.length;

        // Encontrar a chave ou o próximo vazio
        TabelaEntrada entrada = tabela[indice];
        while (entrada != null) {
            if (entrada.chave.equals(chave))
                break;

            indice++;
            entrada = tabela[indice];
        }

        tabela[indice] = new TabelaEntrada(chave, valor);
    }

    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < tabela.length; i++) {
            TabelaEntrada entrada = tabela[i];

            System.out.println(i + ": " + (entrada == null ? "null" : entrada.chave + " --> " + entrada.valor));
        }
    }

    public int size() {
        int tamanho = 0;

        for (int i = 0 ; i < tabela.length ; i++) {
            if(tabela[i]!= null){
                tamanho++;
            }
        }

        return tamanho;
    }

    public void clear() {
        if (TabelaEntrada == 0) {
            tabelaEntrada = null;
        }

    }

}
