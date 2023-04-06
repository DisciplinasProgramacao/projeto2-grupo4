package grupo4;

public class GrafoNaoDirecionado extends GrafoMutavel {
    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoNaoDirecionado(String nome) {
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if(saida != null && chegada != null){
            adicionou = (saida.addAresta(destino, peso) && chegada.addAresta(origem, peso));
        }

        return adicionou;
    }

    @Override
    public Aresta removeAresta(int origem, int destino){
        Aresta aresta1 = null;
        Aresta aresta2 = null;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if(saida != null && chegada != null){
            aresta1 = saida.removeAresta(destino);
            aresta2 = chegada.removeAresta(origem);
        }

        return aresta1 != null ? aresta1 : aresta2;
    }
}
