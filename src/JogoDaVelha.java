import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JogoDaVelha extends JFrame {

    private JTextField txt1_1;
    private JTextField txt1_2;
    private JTextField txt1_3;
    private JTextField txt2_1;
    private JTextField txt2_2;
    private JTextField txt2_3;
    private JTextField txt3_1;
    private JTextField txt3_2;
    private JTextField txt3_3;
    private JLabel Status;
    private Tabuleiro tabuleiro;
    private Jogador jogador;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JogoDaVelha frame = new JogoDaVelha();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JogoDaVelha() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        Status = new JLabel("Status: Jogo em andamento");
        Status.setBounds(10, 240, 414, 14);
        getContentPane().add(Status);

        txt1_1 = new JTextField();
        txt1_1.setBounds(10, 11, 86, 50);
        getContentPane().add(txt1_1);
        txt1_1.setColumns(10);
        txt1_1.setHorizontalAlignment(SwingConstants.CENTER);
        txt1_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt1_2 = new JTextField();
        txt1_2.setBounds(106, 11, 86, 50);
        getContentPane().add(txt1_2);
        txt1_2.setColumns(10);
        txt1_2.setHorizontalAlignment(SwingConstants.CENTER);
        txt1_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt1_3 = new JTextField();
        txt1_3.setBounds(202, 11, 86, 50);
        getContentPane().add(txt1_3);
        txt1_3.setColumns(10);
        txt1_3.setHorizontalAlignment(SwingConstants.CENTER);
        txt1_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt2_1 = new JTextField();
        txt2_1.setBounds(10, 72, 86, 50);
        getContentPane().add(txt2_1);
        txt2_1.setColumns(10);
        txt2_1.setHorizontalAlignment(SwingConstants.CENTER);
        txt2_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt2_2 = new JTextField();
        txt2_2.setBounds(106, 72, 86, 50);
        getContentPane().add(txt2_2);
        txt2_2.setColumns(10);
        txt2_2.setHorizontalAlignment(SwingConstants.CENTER);
        txt2_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt2_3 = new JTextField();
        txt2_3.setBounds(202, 72, 86, 50);
        getContentPane().add(txt2_3);
        txt2_3.setColumns(10);
        txt2_3.setHorizontalAlignment(SwingConstants.CENTER);
        txt2_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt3_1 = new JTextField();
        txt3_1.setBounds(10, 133, 86, 50);
        getContentPane().add(txt3_1);
        txt3_1.setColumns(10);
        txt3_1.setHorizontalAlignment(SwingConstants.CENTER);
        txt3_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt3_2 = new JTextField();
        txt3_2.setBounds(106, 133, 86, 50);
        getContentPane().add(txt3_2);
        txt3_2.setColumns(10);
        txt3_2.setHorizontalAlignment(SwingConstants.CENTER);
        txt3_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));

        txt3_3 = new JTextField();
        txt3_3.setBounds(202, 133, 86, 50);
        getContentPane().add(txt3_3);
        txt3_3.setColumns(10);
        txt3_3.setHorizontalAlignment(SwingConstants.CENTER);
        txt3_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));


        JTextField[][] camposTexto = {
            { txt1_1, txt1_2, txt1_3 },
            { txt2_1, txt2_2, txt2_3 },
            { txt3_1, txt3_2, txt3_3 }
        };

        tabuleiro = new Tabuleiro(camposTexto);
        jogador = new Jogador();

        txt1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(0, 0, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(0, 1, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(0, 2, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt2_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(1, 0, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt2_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(1, 1, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt2_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(1, 2, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt3_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(2, 0, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt3_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(2, 1, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        txt3_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tabuleiro.fazerJogada(2, 2, jogador.getSimboloAtual(), Status)) {
                    if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
                        tabuleiro.exibirTabuleiro();
                        return;
                    }
                    jogador.alternarJogador();
                    tabuleiro.exibirTabuleiro();
                }
            }
        });

        JButton btVolta = new JButton("Desfazer Jogada");
        btVolta.setBounds(300, 11, 124, 50);
        btVolta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tabuleiro.desfazerJogada()) {
                    Status.setText("Status: Jogada desfeita.");
                    jogador.alternarJogador();  // Alterna o jogador após desfazer
                    tabuleiro.exibirTabuleiro();
                } else {
                    Status.setText("Status: Nenhuma jogada para desfazer.");
                }
            }
        });
        getContentPane().add(btVolta);

        JButton btReneciar = new JButton("Reiniciar Jogo");
        btReneciar.setBounds(300, 72, 124, 50);
        btReneciar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tabuleiro.reiniciarJogo(Status);
                txt1_1.setText(" ");
                txt1_2.setText(" ");
                txt1_3.setText(" ");
                txt2_1.setText(" ");
                txt2_2.setText(" ");
                txt2_3.setText(" ");
                txt3_1.setText(" ");
                txt3_2.setText(" ");
                txt3_3.setText(" ");
            }
        });
        getContentPane().add(btReneciar);
    }
}
