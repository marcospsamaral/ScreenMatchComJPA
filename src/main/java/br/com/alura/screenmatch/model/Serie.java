package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria categorias;
    private String imagem;
    private String sinopse;
    private String atores;

    public Serie (DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.parseDouble(dadosSerie.avaliacao())).orElse(0.00);
        this.categorias = Categoria.fromString(dadosSerie.categorias().split(",")[0].trim());
        this.imagem = dadosSerie.imagem();
        this.sinopse = dadosSerie.sinopse();
        this.atores = dadosSerie.atores();
    }

}
