package br.com.naval.batalha;

import br.com.naval.batalha.view.InputUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        InputUtil tiro = new InputUtil();
        InputUtil navioPlayer = new InputUtil();
        int[] coords = new int[2];
        coords = navioPlayer.askCoord("posNavio");
        System.out.printf("Posição do Navio: %d%d%n",coords[0],coords[1]);
        coords = tiro.askCoord("tiro");
        System.out.printf("Posição do Tiro: %d%d%n",coords[0],coords[1]);
    }
}
