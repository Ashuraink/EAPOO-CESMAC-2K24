package bilheteria.ingresso;

import bilheteria.modelo.Filme;

public abstract class Ingressos {

    protected Filme filme;
    protected String horario;
    protected int quantidadeInteira;
    protected int quantidadeMeia;

    public Ingressos(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        this.filme = filme;
        this.horario = horario;
        this.quantidadeInteira = quantidadeInteira;
        this.quantidadeMeia = quantidadeMeia;
    }

    public abstract double calcularValorTotal();

    public abstract void acessoLanchonete();

    public Filme getFilme() {
        return filme;
    }

    public String getHorario() {
        return horario;
    }

    public int getQuantidadeInteira() {
        return quantidadeInteira;
    }

    public int getQuantidadeMeia() {
        return quantidadeMeia;
    }
}
