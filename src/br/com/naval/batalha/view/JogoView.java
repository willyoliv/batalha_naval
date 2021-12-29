package br.com.naval.batalha.view;

import java.util.Scanner;

public class JogoView {

    Scanner input;

    //Constructor
    public JogoView() {
        this.input = new Scanner(System.in);
    }

    public void start() {
        headerWelcome();
        chooseOptions();
    }
    
    private void headerWelcome() {
        System.out.print("#############################################\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("##############$ BATALHA NAVAL $##############\n");
        System.out.print("##############$$$$$$$$$$$$$$$$$##############\n");
        System.out.print("#############################################\n\n\n");

    }

    private void chooseOptions() {
        System.out.print("#######---MENU---#####\n");
        System.out.print("[UTILIZE O NÚMERO CORRESPONDENTE A OPÇÃO]\n");
        System.out.println("[1] - SOBRE O JOGO.");
        System.out.println("[2] - INICIAR JOGO.");
        System.out.println("[3] - SOBRE O PROJETO.");

        int option;
        option = Integer.parseInt(input.nextLine());
        switch (option) {
            case 1:
                aboutGame();
                break;

            case 2:
                //método para iniciar o jogo aqui.
                break;

            case 3:
                //método para exibir sobre o projeto aqui.
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
        System.out.print("#############################################\n\n");

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
                         "na grelha do oponente.");
    }

}
