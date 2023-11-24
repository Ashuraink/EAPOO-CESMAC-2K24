package bilheteria.controller; 

import java.util.Scanner;

import bilheteria.model.Filme;
import bilheteria.model.Ingressos;

public class MenuController {

    static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        System.out.println(saudacao());
        while (true) {
            System.out.print("Deseja comprar um bilhete para assistir um dos nossos filmes? (sim/não): ");
            boolean perguntaIngresso = scanner.next().equalsIgnoreCase("sim");
            if (!perguntaIngresso) {
                System.out.println("Volte sempre.");
                break;
            }

            comprarIngresso();
        }
    }

    private static void comprarIngresso() {
        System.out.println("Os filmes em cartaz são os listados a seguir:");
        // Mostrar lista de filmes
        Filme[] filmes = {
                new Filme("Oppenheimer", "Diretor Oppen", "Descrição Oppen", "Drama", 120),
                new Filme("Matrix Reloaded", "Diretor Matrix", "Descrição Matrix", "Ação", 150),
                new Filme("Som da Liberdade", "Diretor Som", "Descrição Som", "Musical", 110),
                new Filme("One piece - Gold", "Diretor One Piece", "Descrição One Piece", "Animação", 130)
        };

        for (int i = 0; i < filmes.length; i++) {
            System.out.println((i + 1) + ". " + filmes[i].getNome());
        }

        System.out.print("Escolha o número do filme desejado: ");
        int escolhaFilme = scanner.nextInt();
        if (escolhaFilme < 1 || escolhaFilme > filmes.length) {
            System.out.println("Número de filme incorreto. Tente novamente.");
            return;
        }

        Filme filmeEscolhido = filmes[escolhaFilme - 1];
        System.out.println("\nInformações do Filme:");
        System.out.println("Nome: " + filmeEscolhido.getNome());
        System.out.println("Diretor: " + filmeEscolhido.getDiretor());
        System.out.println("Descrição: " + filmeEscolhido.getDescricao());
        System.out.println("Gênero: " + filmeEscolhido.getGenero());
        System.out.println("Duração: " + filmeEscolhido.getDuracao() + " minutos");

        System.out.println("Horários disponíveis:");
        String[] nossosHorarios = {"17:00", "18:50", "20:00"};
        for (int i = 0; i < nossosHorarios.length; i++) {
            System.out.println((i + 1) + ". " + nossosHorarios[i]);
        }

        System.out.print("Escolha o horário da sessão desejada: ");
        int escolhaHorario = scanner.nextInt();
        if (escolhaHorario < 1 || escolhaHorario > nossosHorarios.length) {
            System.out.println("Número de horário incorreto. Tente novamente.");
            return;
        }

        System.out.print("Quantidade de bilhetes inteiros desejada: ");
        int quantidadeInteira = scanner.nextInt();
        System.out.print("Quantidade de meia-entrada desejada: ");
        int quantidadeMeia = scanner.nextInt();

        Ingressos ingresso = new Ingressos(filmes[escolhaFilme - 1], nossosHorarios[escolhaHorario - 1],
                quantidadeInteira, quantidadeMeia);

        System.out.println("\nResumo da compra:");
        System.out.println("Ingressos para o filme: " + ingresso.getFilme().getNome());
        System.out.println("Sessão: " + ingresso.getHorario());
        System.out.println("Ingressos Inteiros: " + ingresso.getQuantidadeInteira());
        System.out.println("Ingressos Meia-entrada: " + ingresso.getQuantidadeMeia());
        System.out.printf("Valor total a ser pago: R$%.2f\n", ingresso.calcularValorTotal());
        System.out.println("Bom filme!");
    }

    private static String saudacao() {
        return "Bem-vindo ao nosso cinema.";
    }
}