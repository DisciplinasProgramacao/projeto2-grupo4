package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import grupo4.LeituraDados.Item;
import grupo4.LeituraDados.Leitura;

import java.io.IOException;
import java.util.List;

class LeituraTest {

    @Test
    void testGerarItemsDoJson() throws IOException {
        List<Item> items = Leitura.gerarItemsDoJson();
        assertNotNull(items);
        assertFalse(items.isEmpty());
    }
}