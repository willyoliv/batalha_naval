package br.com.naval.batalha.domain;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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

//    public void setTabuleiro(Tabuleiro tabuleiro) {
//        this.tabuleiro = tabuleiro;
//    }

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

//    public void setNumeroNavios(int numeroNavios) {
//        this.numeroNavios = numeroNavios;
//    }

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
        for (int i = 0; i < this.numeroNavios; i++) {
            boolean isPosicaoValida;
            do {
                this.tabuleiro.imPrimimirTabuleiro(this.name, quantidadeInicialNavios, true);
                int x = perguntarPosicao("Informe a coordenada eixo X");
                int y = perguntarPosicao("Informe a coordenada eixo Y");
                isPosicaoValida = this.tabuleiro.posicionarNavios(x, y);
                if (isPosicaoValida) {
                    quantidadeInicialNavios--;
                } else {
                    System.out.println("Posição informada já utilizada, tente posicionar o navio em outro local!");
                }
            } while (!isPosicaoValida);
        }
    }

    private int gerarNumeroAleatorio() {
        int valorMinimo = 0;
        int valorMaximo = 9;
        Random ran = new Random();
        int numero = ran.nextInt(valorMaximo) + valorMinimo;
        return numero;
    }

    private int perguntarPosicao(String mensagem) {
        boolean isNumeroInvalido = true;
        int numero = 0;
        while (isNumeroInvalido) {
            System.out.println(mensagem);
            try {
                numero = new Scanner(System.in).nextInt();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Caracter informado não corresponde a um número, tente novamente!");
                continue;
            }
            if (numero >= 0 & numero < 10) {
                isNumeroInvalido = false;
            } else {
                System.out.println("Tente um valor maior ou igual a ZERO e menor que DEZ!");
            }
        }
        return numero;
    }

    public Coordenada realizarJogada() {
        this.tabuleiro.imPrimimirTabuleiro(this.name, this.numeroNavios, false);
        int x = perguntarPosicao("Informe a coordenada eixo X");
        int y = perguntarPosicao("Informe a coordenada eixo Y");
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
