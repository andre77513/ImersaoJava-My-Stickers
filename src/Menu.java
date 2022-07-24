import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void menu() throws Exception {
        Scanner scan = new Scanner(System.in);

        int option;
        String url = null;

        do {
            System.out.println("\n Digite 1 para os Top 250 filmes");
            System.out.println(" Digite 2 para API de linguagens");
            System.out.println(" Digite 3 para as séries mais populares");
            System.out.println(" Digite 4 para a API da Nasa");
            System.out.println(" Digite 0 para sair");
            System.out.print(" Escolha uma opção: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    url = MyProperties.getLink("top");
                    imdb(url);
                    break;
                case 2:
                    System.out.println("\n \u001b[37m \u001b[41m Ainda não foi implementado! \u001b[m\n");
                    break;
                case 3:
                    System.out.println("\n \u001b[37m \u001b[41m Ainda não foi implementado! \u001b[m\n");
                    break;
                case 4:
                    url = MyProperties.getLink("nasa");
                    nasa(url);
                    break;
                case 0:
                    System.out.println("\n Saindo......");
                    break;
                default:
                    System.out.println("\n Opção inválida!");
                    break;
            }

        } while (option != 0);

        scan.close();
    }

    public static void imdb(String url) throws Exception {

        var extractor = new ImDbContentExtractor();

        if (url != null) {

            var http = new ClientsHttp();
            var body = http.getData(url);

            // Exibir e manipular os dados
            List<ImdbContents> contents = extractor.contentExtractors(body);

            var generator = new CreateStickers();

            int i;
            for (i = 0; i < 10; i++) {
                ImdbContents content = contents.get(i);

                InputStream inputStream = new URL(content.getImageUrl()).openStream();
                String imageName = content.getTitle() + ".png";

                generator.create(inputStream, imageName);

                System.out.printf("\n Título: %s\n", content.getTitle());
                System.out.printf(" Url da imagem: %s\n", content.getImageUrl());
                System.out.printf("\u001b[37m \u001b[44m Classificação: %s \u001b[m\n", content.getImDbRating());

                Double rating = Double.parseDouble(content.getImDbRating());
                int intRating = rating.intValue();

                for (int x = 1; x < intRating; x++) {
                    if (x == 1) {
                        System.out.print(" ⭐");
                    }
                    System.out.print("⭐");
                }
                System.out.println("\n");

            }

            System.out.printf("\n\u001b[30m \u001b[43m Total de itens da lista: %s\u001b[m\n", i);

        }
    }

    public static void nasa(String url) throws Exception {

        var extractor = new NasaContentExtractor();

        if (url != null) {

            var http = new ClientsHttp();
            var body = http.getData(url);

            // Exibir e manipular os dados
            List<NasaContents> contents = extractor.contentExtractors(body);

            var generator = new CreateStickers();

            int i;
            for (i = 0; i < 3; i++) {
                NasaContents content = contents.get(i);

                InputStream inputStream = new URL(content.getImageUrl()).openStream();
                String imageName = content.getTitle() + ".png";

                generator.create(inputStream, imageName);

                System.out.printf("\n Título: %s\n", content.getTitle());
                System.out.printf(" Url da imagem: %s\n", content.getImageUrl());
            }
            System.out.printf("\n\u001b[30m \u001b[43m Total de itens da lista: %s\u001b[m\n", i);
        }
    }
}