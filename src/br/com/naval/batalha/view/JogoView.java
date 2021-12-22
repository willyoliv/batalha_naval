package br.com.naval.batalha.view;

import br.com.naval.batalha.controller.Jogo;
import br.com.naval.batalha.domain.Jogador;

public class JogoView {
    Jogo jogo;
    public void show() {
        System.out.println("Bem vindo!");
    }

    public void iniciarJogo() {
        JogadorView jogadorView = new JogadorView();
        jogadorView.criarJogador();
        Jogador jogador = jogadorView.preencherTabuleiro();
        jogador.getTabuleiro().imPrimimirTabuleiro(jogador.getName());
        jogo = new Jogo(jogador);
        jogo.IniciarJogo();
    }
}
