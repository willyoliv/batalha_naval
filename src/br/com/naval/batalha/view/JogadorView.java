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
        System.out.println("#".repeat(45));
        System.out.println("VAMOS PREENCHER O TABULEIRO");
        this.jogador.posicionarNavios();
        return this.jogador;
    }



}
