package grupo4;

public class GrafoCompleto extends Grafo {

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoCompleto(String nome, int ordem) {
        super(nome);
        grafoCompleto(ordem);
    }

    /**
     * Cria um grafo completo com a ordem e nome especificados.
     *
     * @param ordem A ordem do grafo (número de vértices).
     * @return Um objeto Grafo completo.
     */

    public GrafoCompleto grafoCompleto(int ordem) {

        for (int i = 1; i <= ordem; i++) {
            this.addVertice(i);
        }

        for (int verticeAtual = 1; verticeAtual <= ordem; verticeAtual++) {
            for (int verticeDestino = 1; verticeDestino <= ordem; verticeDestino++) {
                if (verticeAtual != verticeDestino) {
                    this.vertices.find(verticeAtual).addAresta(verticeDestino, 0);
                }
            }
        }
        return this;
    }
}
