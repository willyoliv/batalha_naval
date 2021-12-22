package br.com.naval.batalha.controller;

import br.com.naval.batalha.domain.Jogador;

public class Jogo {
    private Jogador jogador;
    private Jogador computador;

    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        this.computador = new Jogador("IA");
    }

    public void IniciarJogo() {
        System.out.println(jogador.getName());
    }
}
