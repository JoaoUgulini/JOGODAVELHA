import javax.swing.JLabel;

class Tabuleiro {
    private String[][] tabuleiro;
    private boolean jogoFinalizado; 
    public Tabuleiro() {
        tabuleiro = new String[3][3];
        jogoFinalizado = false; 
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    public boolean verificarVitoria(String jogador, JLabel Status) {
        if (jogoFinalizado) {
            return false; 
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador)) {
                Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
                System.out.println("O Jogador " + jogador + " Ganhou o jogo");
                jogoFinalizado = true; 
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j].equals(jogador) && tabuleiro[1][j].equals(jogador) && tabuleiro[2][j].equals(jogador)) {
                Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
                System.out.println("O Jogador " + jogador + " Ganhou o jogo");
                jogoFinalizado = true;
                return true;
            }
        }

        if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
            Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
            System.out.println("O Jogador " + jogador + " Ganhou o jogo");
            jogoFinalizado = true; 
            return true;
        }

        if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
            Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
            System.out.println("O Jogador " + jogador + " Ganhou o jogo");
            jogoFinalizado = true; 
            return true;
        }

        if (verificarEmpate()) {
            Status.setText("Status: Empate! Ninguém venceu.");
            System.out.println("Empate! Ninguém venceu.");
            jogoFinalizado = true; 
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].equals(" ")) {
                    return false; 
                }
            }
        }
        return true;
    }

    public void exibirTabuleiro() {
        System.out.println("Jogo da velha [3X3]");
        System.out.println("   1  2  3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + tabuleiro[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public boolean verificarJogada(int lin, int col) {
        if (jogoFinalizado) {
            System.out.println("O jogo já acabou! Reinicie para jogar novamente.");
            return false;
        }
        if (tabuleiro[lin][col].equals(" ")) {
            return true;
        } else {
            System.out.println("Posição já ocupada. Faça outra jogada.");
            return false;
        }
    }

    public boolean fazerJogada(int lin, int col, String jogador) {
        if (verificarJogada(lin, col)) {
            tabuleiro[lin][col] = jogador;
            return true;
        }
        return false;
    }

    public void reiniciarJogo(JLabel Status) {
        inicializarTabuleiro();
        jogoFinalizado = false;
        Status.setText("Status: Jogo reiniciado.");
        System.out.println("O jogo foi reiniciado.");
    }
}
