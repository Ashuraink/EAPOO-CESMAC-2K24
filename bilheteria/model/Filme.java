package bilheteria.model;

public class Filme {

    private String nome;
    private String diretor;
    private String descricao;
    private String genero;
    private int duracao;

    public Filme(String nome, String diretor, String descricao, String genero, int duracao) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.genero = genero;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }


    public String getDiretor() {
        return diretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

}
