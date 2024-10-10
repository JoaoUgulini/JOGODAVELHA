
import java.util.Stack;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Tabuleiro {
    private String[][] tabuleiro;
    private boolean jogoFinalizado;
    private Stack<int[]> historicoJogadas;  // Hist�rico das jogadas
    private JTextField[][] camposTexto;     // Mapeamento dos JTextFields

    public Tabuleiro(JTextField[][] camposTexto) {
        tabuleiro = new String[3][3];
        jogoFinalizado = false;
        historicoJogadas = new Stack<>();    // Inicializa a pilha de jogadas
        this.camposTexto = camposTexto;      // Recebe os JTextFields
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = " ";
            }
        }
    }

    // M�todo para fazer uma jogada
    public boolean fazerJogada(int linha, int coluna, String jogador, JLabel Status) {
        if (tabuleiro[linha][coluna].equals(" ") && !jogoFinalizado) {
            tabuleiro[linha][coluna] = jogador;
            historicoJogadas.push(new int[]{linha, coluna});  // Salva a jogada no hist�rico
            atualizarCamposTexto();  // Atualiza a interface com a jogada
            return true;
        }
        return false;
    }

    // M�todo para desfazer a �ltima jogada
    public boolean desfazerJogada() {
        if (!historicoJogadas.isEmpty()) {
            int[] ultimaJogada = historicoJogadas.pop();  // Remove a �ltima jogada
            int linha = ultimaJogada[0];
            int coluna = ultimaJogada[1];
            tabuleiro[linha][coluna] = " ";              // Limpa a posi��o no tabuleiro
            atualizarCamposTexto();                      // Atualiza os JTextFields visualmente
            jogoFinalizado = false;                      // Reativa o jogo, se necess�rio
            return true;
        }
        return false;  // Se n�o houver jogadas no hist�rico
    }

    // M�todo para atualizar os JTextFields com o conte�do do tabuleiro
    public void atualizarCamposTexto() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                camposTexto[i][j].setText(tabuleiro[i][j]);  // Atualiza cada JTextField com o valor da matriz
            }
        }
    }

    // M�todo de verifica��o de vit�ria (sem mudan�as)
    public boolean verificarVitoria(String jogador, JLabel Status) {
        if (jogoFinalizado) {
            return false;
        }

        // Verifica��o de linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador)) {
                Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
                jogoFinalizado = true;
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j].equals(jogador) && tabuleiro[1][j].equals(jogador) && tabuleiro[2][j].equals(jogador)) {
                Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
                jogoFinalizado = true;
                return true;
            }
        }

        // Verifica��o de diagonais
        if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
            Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
            jogoFinalizado = true;
            return true;
        }

        if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
            Status.setText("Status: O Jogador " + jogador + " Ganhou o jogo");
            jogoFinalizado = true;
            return true;
        }

        return false;
    }

    // Outros m�todos...

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

    public boolean verificarJogada(int lin, int col, JLabel Status) {
        if (jogoFinalizado) {
            System.out.println("O jogo j� acabou! Reinicie para jogar novamente.");
            Status.setText("Status: O jogo j� acabou! Reinicie para jogar novamente.");
            return false;
        }
        if (tabuleiro[lin][col].equals(" ")) {
            return true;
        } else {
            System.out.println("Posi��o j� ocupada. Fa�a outra jogada.");
            Status.setText("Status: Posi��o j� ocupada. Fa�a outra jogada.");
            return false;
        }
    }

    public void reiniciarJogo(JLabel Status) {
        inicializarTabuleiro();
        jogoFinalizado = false;
        Status.setText("Status: Jogo reiniciado.");
        System.out.println("O jogo foi reiniciado.");
    }
}
