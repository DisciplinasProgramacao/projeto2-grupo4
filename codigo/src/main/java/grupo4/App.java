package grupo4;

import grupo4.LeituraDados.Leitura;

public class App {

      
    public static void main(String[] args) throws Exception {
       /* Grafo g = GeradorDeGrafos.gerarGrafoPelosItems(Leitura.gerarItemsDoJson(), "Grafo teste");
        System.out.println(g.nome);

        g.salvar("");

        Grafo g2 = new Grafo("Grafo 2");
        Grafo grafoCompleto = g2.grafoCompleto(5, "Grafo completo");
        System.out.println(grafoCompleto.completo());*/

        GrafoCompleto grafoCompleto = new GrafoCompleto("Grafo Completo", 5);
        System.out.println(grafoCompleto.completo());
    }
}
