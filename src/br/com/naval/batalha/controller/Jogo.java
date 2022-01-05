package br.com.naval.batalha.controller;

import br.com.naval.batalha.domain.Coordenada;
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
        this.computador.posicionarNaviosAleatoreamente();
        Tabuleiro tabuleiroJogador = this.jogador.getTabuleiro();
        Tabuleiro tabuleiroComputador = this.computador.getTabuleiro();
        tabuleiroComputador.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios(), false);
        int numeroDeRodadas = 0;
        while (true) {
            Coordenada coordenada = this.jogador.realizarJogada();
            boolean acertouNavio = marcarJogadaNoTabuleiro(tabuleiroJogador, tabuleiroComputador, coordenada);
            if (acertouNavio) {
                this.computador.afundarNavio();
            }

            if (numeroDeRodadas >= 10) {
                if (verificarGanhador()) {
                    break;
                }
            }

            Coordenada coordenadaComputador = this.computador.realizarJogadaComputador();
            boolean computadorAcertouNavio = marcarJogadaNoTabuleiro(tabuleiroComputador, tabuleiroJogador, coordenadaComputador);
            if (computadorAcertouNavio) {
                this.jogador.afundarNavio();
            }

            tabuleiroJogador.imPrimimirTabuleiro(this.jogador.getName(), this.jogador.getNumeroNavios(), false);
            tabuleiroComputador.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios(), false);

            if (numeroDeRodadas >= 10) {
                if (verificarGanhador()) {
                    break;
                }
            }

            numeroDeRodadas++;
        }
    }

    public boolean marcarJogadaNoTabuleiro(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2, Coordenada coordenada) {
        String tokenTabuleiro1 = tabuleiro1.getTabuleiro()[coordenada.x][coordenada.y];
        String tokenTabuleiro2 = tabuleiro2.getTabuleiro()[coordenada.x][coordenada.y];
        boolean acertou = false;
        if (tokenTabuleiro2.equals("N") || tokenTabuleiro2.equals("n") || tokenTabuleiro2.equals("X")) {
            tabuleiro2.marcarJogada(coordenada, " ");
            if (tokenTabuleiro1.equals("N")) {
                tabuleiro1.marcarJogada(coordenada, "X");
            } else {
                tabuleiro1.marcarJogada(coordenada, "*");
            }
            acertou = true;
        } else {
            if (tokenTabuleiro1.equals("N") || tokenTabuleiro1.equals("n")) {
                tabuleiro1.marcarJogada(coordenada, "n");
            } else {
                tabuleiro1.marcarJogada(coordenada, "-");
            }

        }
        return acertou;
    }

    private boolean verificarGanhador() {
        return this.computador.getNumeroNavios() == 0 || this.jogador.getNumeroNavios() == 0;
    }
}
