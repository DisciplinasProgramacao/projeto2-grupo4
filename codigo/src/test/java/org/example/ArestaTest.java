package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import grupo4.Aresta;

public class ArestaTest {

    @Test
    public void testPeso() {
        Aresta a = new Aresta(10, 2);
        assertEquals(10, a.peso());
    }

    @Test
    public void testDestino() {
        Aresta a = new Aresta(10, 2);
        assertEquals(2, a.destino());
    }

    @Test
    public void testVisitar() {
        Aresta a = new Aresta(10, 2);
        assertFalse(a.visitada());
        a.visitar();
        assertTrue(a.visitada());
    }

    @Test
    public void testLimparVisita() {
        Aresta a = new Aresta(10, 2);
        assertFalse(a.visitada());
        a.visitar();
        assertTrue(a.visitada());
        a.limparVisita();
        assertFalse(a.visitada());
    }

}