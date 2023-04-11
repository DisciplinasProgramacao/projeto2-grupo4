package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grupo4.GrafoCompleto;

public class GrafoCompletoTest {
    private GrafoCompleto grafoCompleto;

    @BeforeEach
    public void setUp() {
        grafoCompleto = new GrafoCompleto("Grafo Completo", 5);
    }

    @Test
    public void testEhCompleto() {
        assertTrue(grafoCompleto.completo());
    }

/*    @Test
    public void testNaoEhCompleto() {
        // TODO: Adicionar verificação de completo com outro grafo filho da classe Grafo
        // que não seja gerado com a classe GrafoCompleto
    }*/

}
