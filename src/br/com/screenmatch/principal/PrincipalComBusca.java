package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Titulo;
import br.com.screenmatch.modelos.TituloOmdb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o filme para pesquisar: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            ConsultaFilme consultaFilme = new ConsultaFilme();

            try {
                TituloOmdb meuTituloOmdb = consultaFilme.BuscarFilme(busca);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        GeracaoArquivo geracaoArquivo = new GeracaoArquivo();
        geracaoArquivo.GravarArquivo(titulos);
    }
}
