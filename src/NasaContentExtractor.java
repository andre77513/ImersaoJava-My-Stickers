import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor {

    public List<NasaContents> contentExtractors(String body) {

        // Extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(body);

        List<NasaContents> contents = new ArrayList<>();

        // popular a lista de conteúdos
        for (Map<String, String> attributes : attributeList) {

            String title = attributes.get("title");
            String imageUrl = attributes.get("url");
            var content = new NasaContents(title, imageUrl);

            contents.add(content);
        }

        return contents;
    }

}
