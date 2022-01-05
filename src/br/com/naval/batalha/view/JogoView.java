package br.com.naval.batalha.view;

import br.com.naval.batalha.controller.Jogo;
import br.com.naval.batalha.domain.Jogador;

import java.util.Scanner;

public class JogoView {

    Scanner input;
    Jogo jogo;

    //Constructor
    public JogoView() {
        this.input = new Scanner(System.in);
    }


    public void start() {
        header();
        chooseOptions();
    }


    private void header() {

        /*for (int i = 0; i < 30; i++) {
            System.out.println();
        }*/

        System.out.print("#############################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("##############$ BATALHA NAVAL $##############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("#############################################\n\n\n\n\n\n");

    }


    private void chooseOptions() {
        System.out.print("#######---MENU---#####\n\n");
        System.out.print("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]\n");
        System.out.println("[1] - INICIAR JOGO.");
        System.out.println("[2] - SOBRE O JOGO.");
        System.out.println("[3] - SOBRE O PROJETO.");
        System.out.println("[0] - SAIR.");

        String option;
        option = input.next();

        switch (option) {
            case "1":
                //MÉTODO PARA INICIAR O JOGO AQUI.
                JogadorView jogadorView = new JogadorView();
                jogadorView.criarJogador();
                Jogador jogador = jogadorView.preencherTabuleiro();
                jogo = new Jogo(jogador);
                jogo.IniciarJogo();
                chooseOptions();
                break;

            case "2":
                aboutGame();
                break;

            case "3":
                aboutProject();
                break;
            case "0":
                System.exit(0);
                break;

            default:
                System.out.print("Opção inválida, por favor escolha uma opção válida do menu.\n\n");
                chooseOptions();
        }

    }


    private void aboutGame() {

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.print("#############################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("##############$ SOBRE DO JOGO $##############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("#############################################\n\n\n\n\n\n");

        System.out.print("Batalha naval é um jogo de tabuleiro de dois jogadores, no qual os jogadores têm de\n" +
                "adivinhar em quais quadrados estão os navios do oponente.\n" +
                "Seu objetivo é derrubar os barcos do oponente adversário, ganha quem derrubar todos\n" +
                "os navios adversários primeiro.\n\n");

        System.out.print("O jogo original é jogado em duas grelhas para cada jogador — uma que representa a\n" +
                "disposição dos barcos do jogador, e outra que representa a do oponente. As grelhas são\n" +
                "tipicamente quadradas, estando identificadas na horizontal por números e na vertical por\n" +
                "letras. Em cada grelha o jogador coloca os seus navios e registra os tiros do oponente.\n\n");

        System.out.print("Antes do início do jogo, cada jogador coloca os seus navios nos quadros, alinhados\n" +
                "horizontalmente ou verticalmente. O número de navios permitidos é igual para ambos\n" +
                "jogadores e os navios não podem se sobrepor.\n\n");

        System.out.print("Após os navios terem sido posicionados o jogo continua numa série de turnos.\n" +
                "Em cada turno, um jogador diz um quadrado, o qual é identificado pela letra e número,\n"+
                "na grelha do oponente.\n\n\n");


        System.out.println("Pressione QUALQUER tecla e aperter ENTER para voltar ao Menu. ");

        String option;
        option = input.nextLine();

        switch (option) {
            default:
                start();
        }
    }


    private void aboutProject() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.print("################################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$#################\n");
        System.out.print("##############$ SOBRE DO PROJETO $##############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$#################\n");
        System.out.print("################################################\n\n\n\n\n\n");

        System.out.print("- PROJETO CRIADO PARA PRATICAR OS CONCEITOS BÁSICOS DA LINGUAGEM DE PROGRAMAÇÃO JAVA.\n\n");
        System.out.print("- ESTE PROJETO FAZ PARTE DO CONTEÚDO DIDÁTICO DO PROGRAMA SANTANDER CODERS - UMA PARCERIA DO BANCO SANTANDER COM A ESCOLA DE PROGRAMAÇÃO LET'S CODE.\n\n");
        System.out.print("- DOCENTE: CRISTIANO NEVES.\n\n");
        System.out.print("- DISCENTES:\n");
        System.out.print("RIVAIL ARAÚJO.\n");
        System.out.print("RODRIGO SOUZA.\n");
        System.out.print("WILLY OLIVEIRA.\n\n\n");

        System.out.println("Pressione QUALQUER tecla e aperter ENTER para voltar ao Menu. ");

        String option;
        option = input.nextLine();

        switch (option) {
            default:
                start();
        }
    }

}
