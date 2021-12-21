package br.com.naval.batalha.view;

import java.util.Scanner;

import br.com.naval.batalha.domain.Jogador;


public class JogoView {
    Scanner input;
    String nomeJogador;

    //Constructor
    public JogoView() {
        this.input = new Scanner(System.in);
    }
    
    private void bemVindo() {
        System.out.print("########################################");
        System.out.println("");
        System.out.println("");
        System.out.printf("### BEM VINDO AO JOGO BATALHA NAVAL ###");
        System.out.println("");
        System.out.println("");
        System.out.print("########################################");
        System.out.println("\n");
    }

    private void criarJogador(){
        Jogador jogador = new Jogador();
        System.out.print("Insira o nome do jogador:");
        nomeJogador = input.nextLine();
        jogador.setNome(nomeJogador);
        System.out.println("Bem vindo ao jogo "+jogador.getNome());         
    }
    
    public void iniciar() {
        bemVindo();        
        criarJogador();
    }
}
