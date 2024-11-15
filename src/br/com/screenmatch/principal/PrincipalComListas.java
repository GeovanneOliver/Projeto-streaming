package br.com.screenmatch.principal;

import br.com.screenmatch.modelos.Filme;
import br.com.screenmatch.modelos.Serie;
import br.com.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 2014);
        meuFilme.avalia(6);
        Filme novoFilme = new Filme("Lobo de wall Street", 2013);
        novoFilme.avalia(8);
        Serie lost = new Serie("lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(novoFilme);
        lista.add(meuFilme);
        lista.add(lost);
        for (Titulo item: lista ){//foreach
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificao() >2){
                System.out.println("Classificação " + filme.getClassificao());
            }
        }
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
