package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.traducao.ConsultaMyMemory;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Categoria categorias;
    @Column(name = "url_image")
    private String imagem;
    private String sinopse;
    private String atores;
    @Transient
    private List<Episodio> episodio = new ArrayList<>();

    public Serie (DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.parseDouble(dadosSerie.avaliacao())).orElse(0.00);
        this.categorias = Categoria.fromString(dadosSerie.categorias().split(",")[0].trim());
        this.imagem = dadosSerie.imagem();
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();
        this.atores = dadosSerie.atores();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo=" + titulo +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", categorias=" + categorias +
                ", imagem=" + imagem +
                ", sinopse=" + sinopse +
                ", atores=" + atores +
                '}';
    }

    public List<Episodio> getEpisodio() {
        return episodio;
    }

    public void setEpisodio(List<Episodio> episodio) {
        this.episodio = episodio;
    }
}
