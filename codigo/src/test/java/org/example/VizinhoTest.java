package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import grupo4.LeituraDados.Vizinho;

class VizinhoTest {

    @Test
    void testSetAndGetId() {
        Vizinho vizinho = new Vizinho();
        int id = 1;
        vizinho.setId(id);
        assertEquals(id, vizinho.getId());
    }

    @Test
    void testSetAndGetPeso() {
        Vizinho vizinho = new Vizinho();
        int peso = 2;
        vizinho.setPeso(peso);
        assertEquals(peso, vizinho.getPeso());
    }
}