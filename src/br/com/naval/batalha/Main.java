package br.com.naval.batalha;

import br.com.naval.batalha.view.JogoView;

public class Main {

    public static void main(String[] args) {
        JogoView jogoView = new JogoView();
        jogoView.show();
        jogoView.iniciarJogo();
    }
}
