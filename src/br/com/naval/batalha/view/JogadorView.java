package br.com.naval.batalha.view;

import br.com.naval.batalha.domain.Jogador;
import br.com.naval.batalha.domain.Tabuleiro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogadorView {
    Scanner scanner = new Scanner(System.in);
    Jogador jogador = new Jogador();

    public void criarJogador() {
        String nome = askNome();
        this.jogador.setName(nome);
    }

    private String askNome() {
        System.out.println("Informe seu nome!");
        String nome = new Scanner(System.in).nextLine();
        if (nome.isBlank()) {
            return askNome();
        }
        return nome;
    }

    public Jogador preencherTabuleiro() {
        Tabuleiro tabuleiro = jogador.getTabuleiro();
        System.out.println("#".repeat(45));
        System.out.println("VAMOS PREENCHER O TABULEIRO");
        for (int i = 0; i < jogador.getNumeroNavios(); i++) {
            tabuleiro.imPrimimirTabuleiro(jogador.getName());
            boolean isPosicaoValida;
            do {
                int x = askPosicao("Informe a coordenada eixo X");
                int y = askPosicao("Informe a coordenada eixo Y");
                isPosicaoValida = tabuleiro.posicionarNavios(x, y);
                tabuleiro.imPrimimirTabuleiro(jogador.getName());
            } while (!isPosicaoValida);
        }
        return this.jogador;
    }

    private int askPosicao(String mensagem) {
        boolean isNumeroInvalido = true;
        int numero = 0;
        while (isNumeroInvalido) {
            System.out.println(mensagem);
            try {
                numero = new Scanner(System.in).nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
                continue;
            }
            if (numero >= 0 & numero < 10) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tente um valor maior ou igual a ZERO e menor que DEZ!");
            }
        }
        return numero;
    }


}
