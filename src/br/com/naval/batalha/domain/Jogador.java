package br.com.naval.batalha.domain;

import br.com.naval.batalha.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogador {
    private String name;
    private int numeroNavios;
    private Tabuleiro tabuleiro;
    private InputUtil inputTiros;
    private List<Coordenadas> jogadasDisponíveisParaComputador;

    public Jogador() {
        this.tabuleiro = new Tabuleiro();
        this.inputTiros = new InputUtil();
        this.numeroNavios = 10;
    }

    public Jogador(String name) {
        this.name = name;
        this.tabuleiro = new Tabuleiro();
        this.numeroNavios = 10;
        this.jogadasDisponíveisParaComputador = new ArrayList<>();
        gerarTodasAsJogadasPossiveisParaComputador();
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
                int linha = gerarNumeroAleatorio(9);
                int coluna = gerarNumeroAleatorio(9);
                isPosicaoValida = tabuleiro.posicionarNavios(linha, coluna);
            } while (!isPosicaoValida);
        }
    }

    public void posicionarNavios() {
        int quantidadeInicialNavios = this.numeroNavios;
        InputUtil inputNavios = new InputUtil();
        int[] coords;
        for (int i = 0; i < this.numeroNavios; i++) {
            this.tabuleiro.imPrimimirTabuleiro(this.name, quantidadeInicialNavios, -1, true);
            coords = inputNavios.askCoord("posNavio");
            int x = coords[0];
            int y = coords[1];
            this.tabuleiro.posicionarNavios(x, y);
            quantidadeInicialNavios--;
        }
    }

    private int gerarNumeroAleatorio(int valor) {
        int valorMinimo = 0;
        int valorMaximo = valor;
        Random ran = new Random();
        int numero = ran.nextInt(valorMaximo) + valorMinimo;
        return numero;
    }

    public Coordenadas realizarJogada(int quantidadeNaviosDoInimigo) {
        this.tabuleiro.imPrimimirTabuleiro(this.name, this.numeroNavios, quantidadeNaviosDoInimigo, false);
        int[] coords;
        coords = inputTiros.askCoord("tiro");
        int x = coords[0];
        int y = coords[1];
        Coordenadas coordenada = new Coordenadas(x, y);
        return coordenada;
    }

    public Coordenadas realizarJogadaComputador() {
        int jogadaAleatoriaDoPc = gerarNumeroAleatorio(this.jogadasDisponíveisParaComputador.size()-1);
        Coordenadas coordenada = this.jogadasDisponíveisParaComputador.get(jogadaAleatoriaDoPc);
        this.jogadasDisponíveisParaComputador.remove(jogadaAleatoriaDoPc);
        return coordenada;
    }

    private void gerarTodasAsJogadasPossiveisParaComputador() {
        for (int linha = 0; linha < this.tabuleiro.getTabuleiro().length; linha ++) {
            for (int coluna = 0; coluna < this.tabuleiro.getTabuleiro()[0].length; coluna ++) {
                Coordenadas coordenadas = new Coordenadas(linha, coluna);
                this.jogadasDisponíveisParaComputador.add(coordenadas);
            }
        }
    }

    public void afundarNavio() {
        this.numeroNavios--;
    }

}
