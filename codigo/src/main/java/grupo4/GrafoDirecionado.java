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

    /**
     * Adiciona aresta entre origem e destino, nessa ordem, caso origem e destino existam
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @param peso    Peso da aresta
     * @return TRUE se adicionado, FALSE se nao
     */
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

    /**
     * Remove aresta entre origem e destino, nessa ordem, caso origem, destino e a aresta em si existam
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @return Aresta removida ou NULL, caso não exista
     */
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
