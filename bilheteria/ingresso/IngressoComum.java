package bilheteria.ingresso;

import bilheteria.modelo.Filme;

public class IngressoComum extends Ingressos {

    private static final double VALOR_INTEIRA = 24.0;
    private static final double VALOR_MEIA = 12.0;

    public IngressoComum(Filme filme, String horario, int quantidadeInteira, int quantidadeMeia) {
        super(filme, horario, quantidadeInteira, quantidadeMeia);

        if (filme.isFilme3D()) {
            throw new IllegalArgumentException("Ingresso comum não pode ser vinculado a filme 3D.");
        }
    }

    @Override
    public double calcularValorTotal() {
        return (quantidadeInteira * VALOR_INTEIRA) + (quantidadeMeia * VALOR_MEIA);
    }

    @Override
    public void acessoLanchonete() {
        System.out.println("Para acessar a lanchonete, compre um ingresso VIP.");
    }
}
