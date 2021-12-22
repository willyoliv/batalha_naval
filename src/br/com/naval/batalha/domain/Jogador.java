package br.com.naval.batalha.domain;

public class Jogador {
    private String name;
    private int numeroNavios;
    private Tabuleiro tabuleiro;

    public Jogador() {
        this.tabuleiro = new Tabuleiro();
        this.numeroNavios = 10;
    }

    public Jogador(String name) {
        this.name = name;
        this.tabuleiro = new Tabuleiro();
        this.numeroNavios = 10;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank()) {
            this.name = name;
        }
    }

    public int getNumeroNavios() {
        return numeroNavios;
    }

    public void setNumeroNavios(int numeroNavios) {
        this.numeroNavios = numeroNavios;
    }
}
