package br.com.naval.batalha.domain;

import br.com.naval.batalha.util.ScreenUtil;

import java.util.Arrays;

public class Tabuleiro {
    private String[][] tabuleiro = new String[10][10];

    public Tabuleiro() {
        limparTabuleiro();
    }

    private void limparTabuleiro() {
        for (String[] linha : this.tabuleiro) {
            Arrays.fill(linha, " ");
        }
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public boolean posicionarNavios(int posicaoX, int posicaoY) {
        boolean isPosicaoValida;
        if (this.tabuleiro[posicaoX][posicaoY].equals(" ")) {
            this.tabuleiro[posicaoX][posicaoY] = "N";
            isPosicaoValida = true;
        } else {
            isPosicaoValida = false;
        }
        return isPosicaoValida;
    }

    public void imPrimimirTabuleiro(String nomeJogador, int quantidadeNaviosDoJogador, int quantidadeNaviosComputador, boolean posicionandoNavios) {
        String[] coordenadas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "j"};
        System.out.println("---------------------------------------------");
        ScreenUtil.printTextLine(nomeJogador, true);
        if (posicionandoNavios) {
            System.out.printf("Navios não posicionados: %d%n", quantidadeNaviosDoJogador);
        } else {
            System.out.printf("Navios restantes: %d%n", quantidadeNaviosDoJogador);
            if (quantidadeNaviosComputador >= 0) {
                System.out.printf("Navios restantes do inimigo: %d%n", quantidadeNaviosComputador);
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("|   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
        System.out.println("---------------------------------------------");
        for (int linha = 0; linha < this.tabuleiro.length; linha++) {
            String coordenada = "| " + coordenadas[linha].concat(" | ");
            String linhaTabuleiro = coordenada.concat(String.join(" | ", this.tabuleiro[linha]) + " |");
            System.out.println(linhaTabuleiro);
            System.out.println("---------------------------------------------");
        }
    }

    public void marcarJogada(Coordenadas coordenada, String token) {
        this.tabuleiro[coordenada.x][coordenada.y] = token;
    }
}
