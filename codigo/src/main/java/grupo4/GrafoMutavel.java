package grupo4;

public abstract class GrafoMutavel extends Grafo {

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Remove o vértice com o id especificado
     * @param id Id do vértice a ser removido
     * @return O vértice removido ou, em caso do vértice não existir, null
     */
    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo.
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public abstract boolean addAresta(int origem, int destino, int peso);

    public abstract Aresta removeAresta(int origem, int destino);

    public void carregar(String nomeArquivo){
    }

    public void salvar(String nomeArquivo){
        Vertice[] arrayVertice = new Vertice[vertices.size()];
        vertices.allElements(arrayVertice);
        for (Vertice vertice : arrayVertice) {
            System.out.println(vertice.getId());
            System.out.println(vertice.toString());
        }
    }
}
