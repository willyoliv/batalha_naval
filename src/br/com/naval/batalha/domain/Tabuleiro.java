package br.com.naval.batalha.domain;

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
        boolean isPosicaoValida = false;
        if (this.tabuleiro[posicaoX][posicaoY].equals(" ")) {
            this.tabuleiro[posicaoX][posicaoY] = "N";
            isPosicaoValida = true;
        } else {
            System.out.println("Posição informada já utilizada, tente posicionar o navio em outro local!");
            isPosicaoValida = false;
        }
        return isPosicaoValida;
    }

    public void imPrimimirTabuleiro(String nomeJogador) {
        String[] coordenadas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "j"};
        System.out.println("---------------------------------------------");
        System.out.println(nomeJogador);
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
}
