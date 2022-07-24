import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientsHttp {

    public String getData(String url) {

        try {

            URI adress = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(adress).GET().build();
            var response = client.send(request, BodyHandlers.ofString()); // HttpResponse<String>
            var body = response.body(); // String

            return body;

        } catch (IOException | InterruptedException exc) {
            throw new RuntimeException(exc);
        }

    }
}
