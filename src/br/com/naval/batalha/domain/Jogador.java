package br.com.naval.batalha.domain;

import br.com.naval.batalha.view.InputUtil;
import java.util.Random;

public class Jogador {
    private String name;
    private int numeroNavios;
    private Tabuleiro tabuleiro;
    private InputUtil inputTiros;

    public Jogador() {
        this.tabuleiro = new Tabuleiro();
        this.inputTiros = new InputUtil();
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


    public void posicionarNaviosAleatoreamente() {
        int quantidadeInicialNavios = this.numeroNavios;
        for (int i = 0; i < quantidadeInicialNavios; i++) {
            boolean isPosicaoValida;
            do {
                int linha = gerarNumeroAleatorio();
                int coluna = gerarNumeroAleatorio();
                isPosicaoValida = tabuleiro.posicionarNavios(linha, coluna);
            } while (!isPosicaoValida);
        }
    }

    public void posicionarNavios() {
        int quantidadeInicialNavios = this.numeroNavios;
        InputUtil inputNavios = new InputUtil();
        int[] coords;
        for (int i = 0; i < this.numeroNavios; i++) {
            this.tabuleiro.imPrimimirTabuleiro(this.name, quantidadeInicialNavios, true);
            coords = inputNavios.askCoord("posNavio");
            int x = coords[0];
            int y = coords[1];
            System.out.println("Coord X" + coords[0]);
            System.out.println("Coord Y" + coords[1]);
            this.tabuleiro.posicionarNavios(x, y);
            quantidadeInicialNavios--;
        }
    }

    private int gerarNumeroAleatorio() {
        int valorMinimo = 0;
        int valorMaximo = 9;
        Random ran = new Random();
        int numero = ran.nextInt(valorMaximo) + valorMinimo;
        return numero;
    }

    public Coordenada realizarJogada() {
        this.tabuleiro.imPrimimirTabuleiro(this.name, this.numeroNavios, false);
        int[] coords;
        coords = inputTiros.askCoord("tiro");
        int x = coords[0];
        int y = coords[1];
        Coordenada coordenada = new Coordenada(x, y);
        return coordenada;
    }

    public Coordenada realizarJogadaComputador() {
        int x = gerarNumeroAleatorio();
        int y = gerarNumeroAleatorio();
        Coordenada coordenada = new Coordenada(x, y);
        return coordenada;
    }

    public void afundarNavio() {
        this.numeroNavios--;
    }

}
