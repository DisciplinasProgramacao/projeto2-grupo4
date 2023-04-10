package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import grupo4.Aresta;
import grupo4.GrafoDirecionado;

public class GrafoDirecionadoTest {

    @Test
    void testAddAresta() {
        GrafoDirecionado grafo = new GrafoDirecionado("Grafo Teste");
        grafo.addVertice(1);
        grafo.addVertice(2);

        boolean adicionou = grafo.addAresta(1, 2, 5);

        Assertions.assertTrue(adicionou);
    }

    @Test
    void testRemoveAresta() {
        GrafoDirecionado grafo = new GrafoDirecionado("Grafo Teste");
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addAresta(1, 2, 5);

        Aresta arestaRemovida = grafo.removeAresta(1, 2);

        Assertions.assertNotNull(arestaRemovida);
    }

    @Test
    void testAddArestaVerticeInexistente() {
        GrafoDirecionado grafo = new GrafoDirecionado("Grafo Teste");
        grafo.addVertice(1);

        boolean adicionou = grafo.addAresta(1, 2, 5);

        Assertions.assertFalse(adicionou);
    }

    @Test
    void testRemoveArestaVerticeInexistente() {
        GrafoDirecionado grafo = new GrafoDirecionado("Grafo Teste");
        grafo.addVertice(1);

        Aresta arestaRemovida = grafo.removeAresta(1, 2);

        Assertions.assertNull(arestaRemovida);
    }
}