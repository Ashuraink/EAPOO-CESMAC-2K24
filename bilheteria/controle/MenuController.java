package bilheteria.controle;

import java.util.Scanner;

import bilheteria.ingresso.IngressoComum;
import bilheteria.ingresso.Ingressos;
import bilheteria.ingresso.IngressosVip;
import bilheteria.modelo.Filme;


public class MenuController {

    static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu() {
        System.out.println(saudacao());
        while (true) {
            System.out.print("Deseja comprar um bilhete para assistir um dos nossos filmes? (sim/não):");
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
        Filme[] filmes = {
                new Filme("Oppenheimer", "Christopher Nolan", "O filme Oppenheimer, relata a história de J. Robert Oppenheimer. \nEle foi o cientista responsável por liderar o Projeto Manhattan, um programa confidencial dos Estados Unidos \ncujo objetivo era desenvolver uma bomba atômica durante a Segunda Guerra Mundial.", "Suspense/Thriller", 180, false),
                new Filme("Matrix Reloaded", "Lana Wachowski, Lilly Wachowski", "O filme matrix reloaded continua a historia de Neo,\nA Matrix está realizando uma grande ofensiva contra Zion, \nonde 250 mil máquinas estão escavando rumo à cidade e podem alcançá-la em poucos dias. \nUma reunião que definirá o contra-ataque humano. \nEntretanto, um recado do Oráculo faz com que a nave leve Neo de volta à Matrix.", "Ficção Científica/Ação", 138, false),
                new Filme("Som da Liberdade", "Alejandro Gómez Monteverde", "Baseado em uma história real, a trama desse filme gira em torno de Tim Ballard (Caviezel), \num ex-agente especial do governo dos Estados Unidos que embarca em uma missão repleta de perigos para resgatar \numa garotinha do tráfico internacional de crianças.", "Crime/Thriller", 135, false),
                new Filme("One piece - Gold", "Miyamoto Hiroaki", "Situado em Gran Tesoro, um país independente fretado pelo Governo Mundial, \nlar da maior cidade de entretenimento do mundo, onde piratas, fuzileiros navais e milionários conhecidos em todo o mundo \nse reúnem em um santuário absoluto que nem o Governo Mundial pode tocar.", "Animação/Aventura", 130, false),
                new Filme("Avatar 2", "James Cameron", "Continuação do épico Avatar, o filme traz novas aventuras no planeta Pandora em 3D.", "Aventura/Ficção Científica", 150, true)
        };

        for (int i = 0; i < filmes.length; i++) {
            Filme filmeAtual = filmes[i];
            System.out.println((i + 1) + ". " + filmeAtual.getNome());
            System.out.println("   Direção: " + filmeAtual.getDiretor());
            System.out.println("   Descrição: " + filmeAtual.getDescricao());
            System.out.println("   Gênero: " + filmeAtual.getGenero());
            System.out.println("   Tempo: " + filmeAtual.getDuracao() + " minutos");
            System.out.println("   3D: " + (filmeAtual.isFilme3D() ? "Sim" : "Não"));
            System.out.println();
        }
    
        System.out.print("Escolha o número do filme desejado: ");
        int escolhaFilme = scanner.nextInt();
        if (escolhaFilme < 1 || escolhaFilme > filmes.length) {
            System.out.println("Número de filme incorreto. Tente novamente.");
            return;
        }
    
        Filme filmeEscolhido = filmes[escolhaFilme - 1];
    
        System.out.print("Deseja comprar um ingresso VIP para o filme? (sim/não): ");
        boolean escolhaIngressoVIP = scanner.next().equalsIgnoreCase("sim");
    
        if (escolhaIngressoVIP) {
            comprarIngressoVIP(filmeEscolhido);
        } else {
            comprarIngresso(filmeEscolhido);
        }
    }

    private static void comprarIngresso(Filme filmeEscolhido) {
        System.out.println("Os horários disponíveis são:");
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
    
        Ingressos ingresso = new IngressoComum(filmeEscolhido, nossosHorarios[escolhaHorario - 1],
            quantidadeInteira, quantidadeMeia);
    
        System.out.println("\nResumo da compra para Ingresso Comum:");
        System.out.println("Ingressos para o filme: " + ingresso.getFilme().getNome());
        System.out.println("Sessão: " + ingresso.getHorario());
        System.out.println("Ingressos Inteiros: " + ingresso.getQuantidadeInteira());
        System.out.println("Ingressos Meia-entrada: " + ingresso.getQuantidadeMeia());
        System.out.printf("Valor total a ser pago: R$%.2f\n", ingresso.calcularValorTotal());
        System.out.println("Bom filme!");
        ingresso.acessoLanchonete();
    }

    private static void comprarIngressoVIP(Filme filmeEscolhido) {
        System.out.println("Os horários disponíveis são:");
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

        IngressosVip ingressoVIP = new IngressosVip(filmeEscolhido, nossosHorarios[escolhaHorario - 1],
                quantidadeInteira, quantidadeMeia);

            System.out.println("\nResumo da compra para Ingresso VIP:");
            System.out.println("Ingressos VIP para o filme: " + ingressoVIP.getFilme().getNome());
            System.out.println("Sessão: " + ingressoVIP.getHorario());
            System.out.println("Ingressos Inteiros VIP: " + ingressoVIP.getQuantidadeInteira());
            System.out.println("Ingressos Meia-entrada VIP: " + ingressoVIP.getQuantidadeMeia());
            System.out.printf("Valor total a ser pago: R$%.2f\n", ingressoVIP.calcularValorTotal());
            System.out.println("Bom filme!");
            ingressoVIP.acessoLanchonete();
    }

    private static String saudacao() {
        return "Bem-vindo ao nosso cinema.";
    }
}