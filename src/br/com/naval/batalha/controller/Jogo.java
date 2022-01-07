package br.com.naval.batalha.controller;

import br.com.naval.batalha.domain.Coordenadas;
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.print("#############################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("##############$ JOGO INICIADO $##############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("#############################################\n\n\n");
//        tabuleiroComputador.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios(), false);
        int numeroDeRodadas = 0;
        while (true) {
            Coordenadas coordenada = this.jogador.realizarJogada(this.computador.getNumeroNavios());
            boolean acertouNavio = marcarJogadaNoTabuleiro(tabuleiroJogador, tabuleiroComputador, coordenada);
            if (acertouNavio) {
                this.computador.afundarNavio();
            }

            if (numeroDeRodadas >= 10) {
                if (verificarGanhador()) {
                    exibirGanhador(tabuleiroJogador, tabuleiroComputador);
                    break;
                }
            }

            Coordenadas coordenadaComputador = this.computador.realizarJogadaComputador();
            boolean computadorAcertouNavio = marcarJogadaNoTabuleiro(tabuleiroComputador, tabuleiroJogador, coordenadaComputador);
            if (computadorAcertouNavio) {
                this.jogador.afundarNavio();
            }

//            tabuleiroComputador.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios(), false);

            if (numeroDeRodadas >= 10) {
                if (verificarGanhador()) {
                    exibirGanhador(tabuleiroJogador, tabuleiroComputador);
                    break;
                }
            }

            numeroDeRodadas++;
        }
    }

    public boolean marcarJogadaNoTabuleiro(Tabuleiro tabuleiro1, Tabuleiro tabuleiro2, Coordenadas coordenada) {
        String tokenTabuleiro1 = tabuleiro1.getTabuleiro()[coordenada.x][coordenada.y];
        String tokenTabuleiro2 = tabuleiro2.getTabuleiro()[coordenada.x][coordenada.y];
        boolean acertouNavio = false;
        if (tokenTabuleiro2.equals("N") || tokenTabuleiro2.equals("n") || tokenTabuleiro2.equals("X")) {
            tabuleiro2.marcarJogada(coordenada, " ");
            if (tokenTabuleiro1.equals("N")) {
                tabuleiro1.marcarJogada(coordenada, "X");
            } else {
                tabuleiro1.marcarJogada(coordenada, "*");
            }
            acertouNavio = true;
        } else {
            if (tokenTabuleiro1.equals("N") || tokenTabuleiro1.equals("n")) {
                tabuleiro1.marcarJogada(coordenada, "n");
            } else {
                tabuleiro1.marcarJogada(coordenada, "-");
            }

        }
        return acertouNavio;
    }

    private boolean verificarGanhador() {
        return this.computador.getNumeroNavios() == 0 || this.jogador.getNumeroNavios() == 0;
    }

    private void exibirGanhador(Tabuleiro tabuleiroDoJogador, Tabuleiro tabuleiroDoComputador) {
        if (this.computador.getNumeroNavios() == 0) {
            System.out.print("#############################################\n");
            System.out.printf("PARABÉNS %s VOCÊ GANHOU!%n", this.jogador.getName());
            System.out.print("#############################################\n");

        } else {
            System.out.print("#############################################\n");
            System.out.printf("O GANHADOR FOI %s, MAIS SORTE NA PRÓXIMA!%n", this.computador.getName());
            System.out.print("#############################################\n");
        }
        tabuleiroDoJogador.imPrimimirTabuleiro(this.jogador.getName(), this.jogador.getNumeroNavios(), this.computador.getNumeroNavios(), false);
        tabuleiroDoComputador.imPrimimirTabuleiro(this.computador.getName(), this.computador.getNumeroNavios(), this.jogador.getNumeroNavios(), false);
    }
}
