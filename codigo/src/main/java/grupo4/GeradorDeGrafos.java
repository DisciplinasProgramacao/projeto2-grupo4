package grupo4;

import grupo4.LeituraDados.Item;
import java.util.List;
import static java.util.Objects.isNull;

public class GeradorDeGrafos {

    public static Grafo gerarGrafoPelosItems(List<Item> items, String nomeGrafo) {
        Grafo grafo = new Grafo(nomeGrafo);
        items.forEach(item -> {
            Vertice verticeInicial = grafo.existeVertice(item.getId());
            if (isNull(verticeInicial)) {
                grafo.addVertice(item.getId());
            }
            item.getVizinhos().forEach(vizinho -> {
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
