package br.com.screenmatch.principal;

import br.com.screenmatch.calculos.CalculadoraDeTempo;
import br.com.screenmatch.calculos.FiltroRecomendacao;
import br.com.screenmatch.modelos.Episodio;
import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 2014);
        meuFilme.setDuracaoEmMinutos(140);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(10);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: "+ meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(6);
        lost.setEpisodiosPorTemporada(25);
        lost.setMinutosPorEpisodio(50);
        System.out.println(lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        Filme novoFilme = new Filme("Lobo de wall Street", 2013);
        novoFilme.setDuracaoEmMinutos(140);
        novoFilme.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(novoFilme);
        listaDeFilmes.add(meuFilme);
        System.out.println("Tamanho da lista "+listaDeFilmes.size());
        System.out.println("Primeiro filme "+listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);

    }
}
