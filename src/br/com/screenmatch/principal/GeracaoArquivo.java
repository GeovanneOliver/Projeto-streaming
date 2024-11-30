package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeracaoArquivo {
    public void GravarArquivo(List<Titulo> titulo ) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulo));
        escrita.close();

    }
}
