package org.example;

import grupo4.GrafoCompleto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
