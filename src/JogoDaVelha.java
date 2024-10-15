import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;

public class JogoDaVelha extends JFrame {

    private JTextField[][] camposTexto;
    private JLabel Status;
    private Tabuleiro tabuleiro;
    private Jogador jogador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JogoDaVelha frame = new JogoDaVelha();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public JogoDaVelha() {
        setResizable(false);
        setTitle("Jogo da Velha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        getContentPane().setBackground(new Color(245, 245, 245));

        getContentPane().setLayout(new MigLayout("wrap 3", "[160.00,grow][160.00,grow][160.00,grow]", "[]20[grow][grow][grow]20[]20[][][]"));


        JLabel titulo = new JLabel("Jogo da Velha");
        titulo.setFont(new Font("Dubai", Font.BOLD, 28));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(titulo, "span, align center");

        Font fontCampos = new Font("Modern No. 20", Font.BOLD, 40);
        Color corFundo = new Color(255, 255, 255);

        camposTexto = new JTextField[3][3];

        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                camposTexto[linha][coluna] = criarCampoTexto(fontCampos, corFundo);
                getContentPane().add(camposTexto[linha][coluna], "grow"); 
                adicionarEventosClique(camposTexto[linha][coluna], linha, coluna);
            }
        }

        JButton btReniciar = new JButton("Reiniciar Jogo");
        btReniciar.setFont(new Font("Dubai", Font.BOLD, 16));
        btReniciar.setBackground(new Color(220, 220, 220));
        btReniciar.setBorder(new LineBorder(new Color(160, 160, 160), 2));
        btReniciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabuleiro.reiniciarJogo(Status);
                jogador.setSimboloAtual(jogador.getSimboloAtual());
                limparCamposTexto();
            }
        });
        getContentPane().add(btReniciar, "cell 0 5, grow");

        JButton btVolta = new JButton("Desfazer Jogada");
        btVolta.setFont(new Font("Dubai", Font.BOLD, 16));
        btVolta.setBackground(new Color(220, 220, 220));
        btVolta.setBorder(new LineBorder(new Color(160, 160, 160), 2));
        btVolta.addActionListener(e -> {
            if (tabuleiro.desfazerJogada(jogador)) {
                Status.setText("Status: Jogada desfeita.");
                jogador.alternarJogador();
            } else {
                Status.setText("Status: Nenhuma jogada para desfazer.");
            }
        });
        getContentPane().add(btVolta, "cell 2 5, grow");

        Status = new JLabel("Status: Jogo em andamento");
        Status.setFont(new Font("Dubai", Font.PLAIN, 18));
        Status.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(Status, "span 3, align center");

        tabuleiro = new Tabuleiro(camposTexto);
        jogador = new Jogador();
    }

    private JTextField criarCampoTexto(Font font, Color bg) {
        JTextField campoTexto = new JTextField();
        campoTexto.setEditable(false);
        campoTexto.setHorizontalAlignment(SwingConstants.CENTER);
        campoTexto.setFont(font);
        campoTexto.setBackground(bg);
        campoTexto.setBorder(new LineBorder(new Color(160, 160, 160), 2));
        return campoTexto;
    }

    private void adicionarEventosClique(JTextField campo, int linha, int coluna) {
        campo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(linha, coluna, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.jogadaPc(Status, jogador);
                }
            }
        });
    }

    private void limparCamposTexto() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                camposTexto[linha][coluna].setText(" ");
            }
        }
    }
}
