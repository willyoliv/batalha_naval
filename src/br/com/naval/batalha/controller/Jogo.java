package br.com.naval.batalha.controller;

import br.com.naval.batalha.domain.Jogador;
import br.com.naval.batalha.domain.Tabuleiro;

public class Jogo {
    private Jogador jogador;
    private Jogador computador;

    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        this.computador = new Jogador("IA");
    }

    public void IniciarJogo() {
        System.out.println(jogador.getName());
        this.computador.posicionarNaviosAleatoreamente();
        Tabuleiro tabuleiro = this.computador.getTabuleiro();
        tabuleiro.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios());
    }
}
