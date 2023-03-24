package grupo4.LeituraDados;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class Leitura {
    public static List<Item> gerarItemsDoJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new FileInputStream(new File("data.json"));
        TypeReference<List<Item>> typeReference = new TypeReference<List<Item>>() {};
        List<Item> items = mapper.readValue(inputStream, typeReference);
        return items;
    }

}
