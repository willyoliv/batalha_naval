package br.com.naval.batalha.view;
import java.util.Scanner;

public class InputUtil {
    Scanner input = new Scanner(System.in);
    private final String LINHAS = "abcdefghij";
    private final String COLUNAS = "0123456789";
    private String posicoesUtilizadas = "";

    public int[] askCoord(String tipo){
        switch (tipo){
            case "tiro":
                return askTiro();
            case "posNavio":
                return askNavio();
            default:
                System.out.println("Tipo inválido!");
        }
        return new int[0];
    }

    private int[] askTiro(){
        int[] coordenadas = new int[2];
        System.out.println("Qual a posição do tiro? (Ex: a0 ou A0)");
        String entrada = input.next().toLowerCase();
        if (entrada.length() != 2){
            System.out.println("Entrada Inválida, Tente Novamente! (O tiro deve apenas ter linha e coluna)");
            askTiro();
        }else if(!LINHAS.contains(Character.toString(entrada.charAt(0)))
                || !COLUNAS.contains(Character.toString(entrada.charAt(1)))){
            System.out.printf("Entrada Inválida, Tente novamente! " +
                    "(Linha deve ser uma letra de (a-j) e a coluna um valor numérico de (0-9)!)%n");
            askTiro();
        }
        else {
            if (posicoesUtilizadas.contains(entrada)){
                System.out.println("Tiro ja executado, Tente novamente!");
                askTiro();
            }else{
                posicoesUtilizadas += entrada;
                coordenadas[0] = getLinha(entrada.charAt(0));
                coordenadas[1] = getColuna(entrada.charAt(1));
                return coordenadas;
            }
        }
        return coordenadas;
    }

    private int[] askNavio(){
        int[] coordenadas = new int[2];
        System.out.println("Qual posição deseja colocar o navio? (Ex: a0 ou A0)");
        String entrada = input.next().toLowerCase();
        if (entrada.length() != 2){
            System.out.println("Entrada Inválida, Tente Novamente! (A posição deve apenas ter linha e coluna)");
            askNavio();
        }else if(!LINHAS.contains(Character.toString(entrada.charAt(0)))
                || !COLUNAS.contains(Character.toString(entrada.charAt(1)))){
            System.out.printf("Entrada Inválida, Tente novamente! " +
                    "(Linha deve ser uma letra de (a-j) e a coluna um valor numérico de (0-9)!)%n");
            askNavio();
        }
        else {
            if (posicoesUtilizadas.contains(entrada)){
                System.out.println("Posição ja usada, Tente outra!");
                askNavio();
            }else{
                posicoesUtilizadas += entrada;
                coordenadas[0] = getLinha(entrada.charAt(0));
                coordenadas[1] = getColuna(entrada.charAt(1));
                return coordenadas;
            }
        }
        return coordenadas;
    }

    public int getLinha(char letra){
        return LINHAS.indexOf(letra);
    }
    public int getColuna(char coluna){
        return COLUNAS.indexOf(coluna);
    }
}
