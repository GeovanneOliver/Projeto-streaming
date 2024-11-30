package br.com.screenmatch.principal;

import br.com.screenmatch.excecao.ErroDeConversaoAnoException;
import br.com.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaFilme {
    public TituloOmdb BuscarFilme(String filme) {
        BuscaConfig buscaConfig = new BuscaConfig();
        String apiKey = buscaConfig.getApiKey();
        URI endereco = URI.create("https://www.omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey="+apiKey);
        System.out.println(endereco);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TituloOmdb.class);

        }catch (NumberFormatException | IOException | InterruptedException e) {
            throw new NumberFormatException(e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (ErroDeConversaoAnoException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
