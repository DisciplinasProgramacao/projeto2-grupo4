package grupo4.LeituraDados;

import java.util.List;

public class Item {
    private int id;
    private List<Vizinho> vizinhos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vizinho> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Vizinho> vizinhos) {
        this.vizinhos = vizinhos;
    }
}
