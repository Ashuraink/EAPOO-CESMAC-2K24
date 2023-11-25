package bilheteria.modelo;

public class IngressosVip extends Ingressos {

    private static final double VALOR_INTEIRA_VIP = 48.0;
    private static final double VALOR_MEIA_VIP = 24.0;

    public IngressosVip(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        super(filme, horario, quantidadeInteira, quantidadeMeia);
    }

    @Override
    public double calcularValorTotal() {
        return (getQuantidadeInteira() * VALOR_INTEIRA_VIP) + (getQuantidadeMeia() * VALOR_MEIA_VIP);
    }

    @Override
    public void acessoLanchonete() {
        System.out.println("Lanchonete do cinema liberada.");
    }
}
