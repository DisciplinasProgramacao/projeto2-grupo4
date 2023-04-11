package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo4.GrafoNaoDirecionado;

public class GrafoNaoDirecionadoTest {
    GrafoNaoDirecionado grafo;

    @BeforeEach
    public void setUp() {
        grafo = new GrafoNaoDirecionado("Grafo Teste");
    }

    @Test
    public void testAdicionarArestaExistente() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addAresta(1, 2, 5);
        assertFalse(grafo.addAresta(2, 1, 3));
    }

    @Test
    public void testAdicionarArestaInexistente() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        assertTrue(grafo.addAresta(1, 2, 5));
    }

    @Test
    public void testAdicionarArestaComVerticesInexistentes() {
        assertFalse(grafo.addAresta(1, 2, 5));
    }

    @Test
    public void testRemoverArestaInexistente() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        assertNull(grafo.removeAresta(1, 2));
    }

    @Test
    public void testRemoverArestaComVerticesInexistentes() {
        assertNull(grafo.removeAresta(1, 2));
    } 
}
