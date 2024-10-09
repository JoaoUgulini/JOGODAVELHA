import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JogoDaVelha extends JFrame {

	private JPanel contentPane;
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
    private Stack<int[]> jogadasPossiveis;
    private JButton btReneciar;

    private void inicializarJogadasPossiveis() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jogadasPossiveis.push(new int[]{i, j});
            }
        }
    }

    public void iniciarJogo() {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            tabuleiro.exibirTabuleiro();


            System.out.print("Jogador " + jogador.getSimboloAtual() + " - Linha (1-3): ");
            int lin = entrada.nextInt() - 1;
            System.out.print("Jogador " + jogador.getSimboloAtual() + " - Coluna (1-3): ");
            int col = entrada.nextInt() - 1;

            if (tabuleiro.fazerJogada(lin, col, jogador.getSimboloAtual(), Status)) {
                if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(),Status)) {
                    continuar = false;
                    tabuleiro.exibirTabuleiro();
                    break;
                }

                jogador.alternarJogador();


                while (!jogadasPossiveis.isEmpty()) {
                    int[] jogada = jogadasPossiveis.pop();
                    lin = jogada[0];
                    col = jogada[1];

                    if (tabuleiro.fazerJogada(lin, col, jogador.getSimboloAtual(), Status)) {
                        break;
                    }
                }

                if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(),Status)) {
                    continuar = false;
                    tabuleiro.exibirTabuleiro();
                    break;
                }

                jogador.alternarJogador();
            }
        }

        entrada.close();
    }


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
		 	tabuleiro = new Tabuleiro();
	        jogador = new Jogador();
	        jogadasPossiveis = new Stack<>();
	        
	        inicializarJogadasPossiveis();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[60.00,grow][140.00][140.00][140.00][78.00,grow]", "[grow][60.00][60.00][60.00][grow][]"));
		
		
		txt1_1 = new JTextField();
		txt1_1.setEditable(false);
		txt1_1.setToolTipText("");
		txt1_1.setBackground(SystemColor.text);
		txt1_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        if (tabuleiro.fazerJogada(0, 0, jogador.getSimboloAtual(), Status)) {
		            txt1_1.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
		    }
		});
		
		Status = new JLabel("Status: ");
		Status.setFont(new Font("Verdana", Font.PLAIN, 20));
		contentPane.add(Status, "cell 1 0 4 1");
		txt1_1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt1_1, "cell 1 1,grow");
		txt1_1.setColumns(10);
		
		txt1_2 = new JTextField();
		txt1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(0, 1, jogador.getSimboloAtual(), Status)) {
		            txt1_2.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt1_2.setBackground(SystemColor.text);
		txt1_2.setHorizontalAlignment(SwingConstants.CENTER);
		txt1_2.setEditable(false);
		txt1_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt1_2, "cell 2 1,grow");
		txt1_2.setColumns(10);
		
		txt1_3 = new JTextField();
		txt1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(0, 2, jogador.getSimboloAtual(), Status)) {
		            txt1_3.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt1_3.setBackground(SystemColor.text);
		txt1_3.setHorizontalAlignment(SwingConstants.CENTER);
		txt1_3.setEditable(false);
		txt1_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt1_3, "cell 3 1,grow");
		txt1_3.setColumns(10);
		
		txt2_1 = new JTextField();
		txt2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(1, 0, jogador.getSimboloAtual(), Status)) {
		            txt2_1.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt2_1.setBackground(SystemColor.text);
		txt2_1.setHorizontalAlignment(SwingConstants.CENTER);
		txt2_1.setEditable(false);
		txt2_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt2_1, "cell 1 2,grow");
		txt2_1.setColumns(10);
		
		txt2_2 = new JTextField();
		txt2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(1, 1, jogador.getSimboloAtual(), Status)) {
		            txt2_2.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt2_2.setBackground(SystemColor.text);
		txt2_2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2_2.setEditable(false);
		txt2_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt2_2, "cell 2 2,grow");
		txt2_2.setColumns(10);
		
		txt2_3 = new JTextField();
		txt2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(1, 2, jogador.getSimboloAtual(), Status)) {
		            txt2_3.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt2_3.setBackground(SystemColor.text);
		txt2_3.setHorizontalAlignment(SwingConstants.CENTER);
		txt2_3.setEditable(false);
		txt2_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt2_3, "cell 3 2,grow");
		txt2_3.setColumns(10);
		
		txt3_1 = new JTextField();
		txt3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(2, 0, jogador.getSimboloAtual(), Status)) {
		            txt3_1.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt3_1.setBackground(SystemColor.text);
		txt3_1.setHorizontalAlignment(SwingConstants.CENTER);
		txt3_1.setEditable(false);
		txt3_1.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt3_1, "cell 1 3,grow");
		txt3_1.setColumns(10);
		
		txt3_2 = new JTextField();
		txt3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(2, 1, jogador.getSimboloAtual(), Status)) {
		            txt3_2.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt3_2.setBackground(SystemColor.text);
		txt3_2.setHorizontalAlignment(SwingConstants.CENTER);
		txt3_2.setEditable(false);
		txt3_2.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt3_2, "cell 2 3,grow");
		txt3_2.setColumns(10);
		
		txt3_3 = new JTextField();
		txt3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tabuleiro.fazerJogada(2, 2, jogador.getSimboloAtual(), Status)) {
		            txt3_3.setText(jogador.getSimboloAtual());  

		            if (tabuleiro.verificarVitoria(jogador.getSimboloAtual(), Status)) {
		                tabuleiro.exibirTabuleiro();  
		                return;  
		            }

		            jogador.alternarJogador();  
		            tabuleiro.exibirTabuleiro();  
		        }
			}
		});
		txt3_3.setBackground(SystemColor.text);
		txt3_3.setHorizontalAlignment(SwingConstants.CENTER);
		txt3_3.setEditable(false);
		txt3_3.setFont(new Font("OCR A Extended", Font.BOLD, 35));
		contentPane.add(txt3_3, "cell 3 3,grow");
		txt3_3.setColumns(10);
		
		JButton btVolta = new JButton("Desfazer Jogada");
		btVolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(btVolta, "cell 1 5,growx");
		
		btReneciar = new JButton("Reniciar Jogo\r\n");
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
		contentPane.add(btReneciar, "cell 3 5,growx");
	}

}
