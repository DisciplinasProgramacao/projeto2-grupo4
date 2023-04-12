package grupo4;

import grupo4.LeituraDados.Leitura;

public class App {

      
    public static void main(String[] args) throws Exception {
        Grafo g = GeradorDeGrafos.gerarGrafoPelosItems(Leitura.gerarItemsDoJson(), "Grafo teste");
        System.out.println(g.nome);
//
//        g.salvar("");
//
//        Grafo g2 = new Grafo("Grafo 2");
//        Grafo grafoCompleto = g2.grafoCompleto(5, "Grafo completo");
//        System.out.println(grafoCompleto.completo());

        GrafoCompleto grafoCompleto = new GrafoCompleto("Grafo Completo", 5);
        grafoCompleto.salvar(null);

//        GrafoMutavel naoDirecionado = new GrafoNaoDirecionado("naoDirecionado");
//        naoDirecionado.addVertice(1);
//        naoDirecionado.addVertice(2);
//        naoDirecionado.addAresta(1, 2, 1);
//        System.out.println("NAO DIRECIONADO:");
//        System.out.println("1 -> 2: " + naoDirecionado.existeAresta(1, 2));
//        System.out.println("2 -> 1: " + naoDirecionado.existeAresta(2, 1));
//
//        GrafoMutavel direcionado = new GrafoDirecionado("direcionado");
//        direcionado.addVertice(1);
//        direcionado.addVertice(2);
//        direcionado.addAresta(1, 2, 10);
//        System.out.println("DIRECIONADO:");
//        System.out.println("1 -> 2: " + direcionado.existeAresta(1, 2));
//        System.out.println("2 -> 1: " + direcionado.existeAresta(2, 1));
    }
}
