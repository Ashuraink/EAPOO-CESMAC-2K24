package bilheteria.model;

public class Ingressos {

    private Filme filme;
    private String horario;
    private int quantidadeInteira;
    private int quantidadeMeia;
    private static final double VALOR_INTEIRA = 24.0;
    private static final double VALOR_MEIA = 12.0;

    public Ingressos(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        this.filme = filme;
        this.horario = horario;
        this.quantidadeInteira = quantidadeInteira;
        this.quantidadeMeia = quantidadeMeia;
    }

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

    public double calcularValorTotal() {
        return (quantidadeInteira * VALOR_INTEIRA) + (quantidadeMeia * VALOR_MEIA);
    }
}
