package grupo4;

public class GrafoDirecionado extends GrafoMutavel {
    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoDirecionado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if(saida != null && chegada != null){
            adicionou = saida.addAresta(destino, peso);
        }

        return adicionou;
    }

    @Override
    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if(saida != null && chegada != null){
            return saida.removeAresta(destino);
        }

        return null;
    }
}
