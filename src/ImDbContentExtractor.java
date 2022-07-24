import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImDbContentExtractor {

    public List<ImdbContents> contentExtractors(String body) {

        // Extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(body);

        List<ImdbContents> contents = new ArrayList<>();

        // popular a lista de conteúdos
        for (Map<String, String> attributes : attributeList) {

            String title = attributes.get("title");
            String imageUrl = attributes.get("image").replaceAll("(@)(.*).jpg$", "$1.jpg");
            String imDbRating = attributes.get("imDbRating");

            var content = new ImdbContents(title, imageUrl, imDbRating);

            contents.add(content);
        }

        return contents;
    }

}
