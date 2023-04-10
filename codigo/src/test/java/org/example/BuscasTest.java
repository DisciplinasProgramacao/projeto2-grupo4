package org.example;

import grupo4.Grafo;
import grupo4.GrafoNaoDirecionado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuscasTest {
    private GrafoNaoDirecionado grafo = new GrafoNaoDirecionado("grafo para teste");

    @BeforeEach
    public void setUp() {
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addVertice(5);
        grafo.addAresta(1,2,0);
        grafo.addAresta(1,3,0);
        grafo.addAresta(2,4,0);
        grafo.addAresta(3,4,0);
        grafo.addAresta(4,5,0);
    }

    @Test
    public void testBFS() {
        Grafo resultadoBfs = grafo.bfs(1);
        String expectedOutput = "1 -> 2 3 \n" +
                "2 -> 1 4 \n" +
                "3 -> 1 \n" +
                "4 -> 2 5 \n" +
                "5 -> 4 \n";
        assertEquals(expectedOutput, resultadoBfs.imprimirGrafo());
    }

    @Test
    public void testDFS() {
        Grafo resultadoBfs = grafo.dfs(1);
        String expectedOutput = "1 -> 2 3 \n" +
                "2 -> 1 4 \n" +
                "3 -> 1 4 \n" +
                "4 -> 2 3 5 \n" +
                "5 -> 4 \n";
        assertEquals(expectedOutput, resultadoBfs.imprimirGrafo());
    }
}
