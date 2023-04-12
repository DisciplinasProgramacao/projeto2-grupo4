package grupo4;

import grupo4.LeituraDados.Item;
import java.util.List;
import static java.util.Objects.isNull;

public class GeradorDeGrafos {

    /**
     * Método responsável por gerar um grafo mutável a partir de uma lista de itens e um nome de grafo.
     * @param items Lista de objetos do tipo Item contendo as informações dos vértices e arestas do grafo a ser gerado.
     * @param nomeGrafo String contendo o nome do grafo a ser gerado.
     * @return GrafoMutavel contendo as informações do grafo gerado a partir da lista de itens.
     */
    public static GrafoMutavel gerarGrafoPelosItems(List<Item> items, String nomeGrafo) {
        GrafoMutavel grafo = new GrafoDirecionado(nomeGrafo);
        if (items.isEmpty()) return grafo;

        items.forEach(item -> {
            Vertice verticeInicial = grafo.existeVertice(item.getId());
            if (isNull(verticeInicial)) {
                grafo.addVertice(item.getId());
            }
            item.getVizinhos().forEach(vizinho -> {
                System.out.println(vizinho.getId());
                Vertice verticeVizinho = grafo.existeVertice(vizinho.getId());
                if (isNull(verticeVizinho)) {
                    grafo.addVertice(vizinho.getId());
                }
                grafo.addAresta(item.getId(), vizinho.getId(), vizinho.getPeso());
            });
        });
        return grafo;
    }
}
