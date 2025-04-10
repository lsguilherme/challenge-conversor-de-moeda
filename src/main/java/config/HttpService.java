package config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpService {
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    /**
     * Método que retorna uma requisição
     * @param baseCode
     * @param targetCode
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static String request(String baseCode, String targetCode) throws IOException, InterruptedException {
        var key = System.getenv("KEY");
        return HttpService.makeRequest("https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseCode + "/" + targetCode);
    }

    /**
     * Criação do client e retorno do body
     * @param uri
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    private static String makeRequest(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();

        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


}
