package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo4.Aresta;
import grupo4.GrafoDirecionado;

public class GrafoDirecionadoTest {

    GrafoDirecionado grafo;

    @BeforeEach
    void setUp() {
        grafo = new GrafoDirecionado("Grafo Teste");
    }

    @Test
    void testAddAresta() {
        grafo.addVertice(1);
        grafo.addVertice(2);

        boolean adicionou = grafo.addAresta(1, 2, 5);

        assertTrue(adicionou);
    }

    @Test
    void testRemoveAresta() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addAresta(1, 2, 5);

        Aresta arestaRemovida = grafo.removeAresta(1, 2);

        assertNotNull(arestaRemovida);
    }

    @Test
    void testAddArestaVerticeInexistente() {
        grafo.addVertice(1);

        boolean adicionou = grafo.addAresta(1, 2, 5);

        assertFalse(adicionou);
    }

    @Test
    void testRemoveArestaVerticeInexistente() {
        grafo.addVertice(1);

        Aresta arestaRemovida = grafo.removeAresta(1, 2);

        assertNull(arestaRemovida);
    }

    @Test
    void testAddArestaExistente() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addAresta(1, 2, 1);

        assertFalse(grafo.addAresta(1, 2, 5));
    }

    @Test
    void testRemoveArestaInexistente() {
        assertNull(grafo.removeAresta(1, 2));
    }
}