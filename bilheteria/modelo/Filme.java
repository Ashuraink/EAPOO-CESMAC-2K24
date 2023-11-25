package bilheteria.modelo;

public class Filme {

    private String nome;
    private String diretor;
    private String descricao;
    private String genero;
    private int duracao;
    private boolean filme3D;

    public Filme(String nome, String diretor, String descricao, String genero, int duracao, boolean filme3D) {
        this.nome = nome;
        this.diretor = diretor;
        this.descricao = descricao;
        this.genero = genero;
        this.duracao = duracao;
        this.filme3D = filme3D;
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

    public boolean isFilme3D() {
        return filme3D;
    }
}
