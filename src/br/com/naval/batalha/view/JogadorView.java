package br.com.naval.batalha.view;

import br.com.naval.batalha.domain.Jogador;

import java.util.Scanner;

public class JogadorView {
    Jogador jogador = new Jogador();

    public void criarJogador() {
        String nome = askNome();
        this.jogador.setName(nome);
    }

    private String askNome() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("#".repeat(45));
        System.out.println("ANTES DO JOGO INICIAR POR FAVOR INFORME UM NOME DE USUÁRIO!");
        String nome = new Scanner(System.in).nextLine();
        if (nome.isBlank()) {
            return askNome();
        }
        return nome;
    }

    public Jogador preencherTabuleiro() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("#".repeat(45));
        System.out.println("VAMOS PREENCHER O TABULEIRO");
        this.jogador.posicionarNavios();
        return this.jogador;
    }
}
