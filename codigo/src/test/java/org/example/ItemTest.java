package org.example;
import grupo4.LeituraDados.Item;
import grupo4.LeituraDados.Vizinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ItemTest {

    @Test
    void testSetAndGetId() {
        Item item = new Item();
        int id = 1;
        item.setId(id);
        assertEquals(id, item.getId());
    }

    @Test
    void testSetAndGetVizinhos() {
        Item item = new Item();
        List<Vizinho> vizinhos = new ArrayList<>();
        Vizinho vizinho1 = new Vizinho();
        Vizinho vizinho2 = new Vizinho();
        vizinhos.add(vizinho1);
        vizinhos.add(vizinho2);
        item.setVizinhos(vizinhos);
        assertEquals(vizinhos, item.getVizinhos());
    }
}
