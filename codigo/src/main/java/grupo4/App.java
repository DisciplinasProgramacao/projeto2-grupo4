package grupo4;

import grupo4.LeituraDados.Leitura;

public class App {

      
    public static void main(String[] args) throws Exception {
        Grafo g = GeradorDeGrafos.gerarGrafoPelosItems(Leitura.gerarItemsDoJson(), "Grafo teste");
        System.out.println(g.nome);

        g.salvar("");
    }
}
