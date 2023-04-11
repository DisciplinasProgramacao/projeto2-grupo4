package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import grupo4.Vertice;

public class VerticeTest {

    private Vertice verticeGeral;

    @BeforeEach
    void setUp() throws Exception {
        verticeGeral = new Vertice(1);
    }

    @Test
    void testGetId() {
        assertEquals(1, verticeGeral.getId());
    }

    @Test
    void testGetArestas() {
        assertEquals(0, verticeGeral.getArestas().size());
    }

    @Test
    public void testAddAresta() {
        Vertice vertice = new Vertice(1);
        assertTrue(vertice.addAresta(2, 10));
        assertFalse(vertice.addAresta(2, 5));
    }

    @Test
    public void testExisteAresta() {
        Vertice vertice = new Vertice(1);
        vertice.addAresta(2, 10);
        assertNotNull(vertice.existeAresta(2));
        assertNull(vertice.existeAresta(3));
    }

    @Test
    public void testRemoveAresta() {
        Vertice vertice = new Vertice(1);
        vertice.addAresta(2, 10);
        assertNotNull(vertice.existeAresta(2));
        assertNotNull(vertice.removeAresta(2));
        assertNull(vertice.existeAresta(2));
    }

    @Test
    public void testGetVizinhos() {
        Vertice vertice = new Vertice(1);
        vertice.addAresta(2, 10);
        vertice.addAresta(3, 20);
        assertEquals(2, vertice.getVizinhos().size());
        assertTrue(vertice.getVizinhos().contains(2));
        assertTrue(vertice.getVizinhos().contains(3));
    }

    @Test
    public void testGrau() {
        Vertice vertice = new Vertice(1);
        vertice.addAresta(2, 10);
        vertice.addAresta(3, 20);
        assertEquals(2, vertice.grau());
    }

    @Test
    void testVisitarELimparVisita() {
        Vertice vertice = new Vertice(1);
        assertFalse(vertice.visitado());
        vertice.visitar();
        assertTrue(vertice.visitado());
        vertice.limparVisita();
        assertFalse(vertice.visitado());
    }

    
}