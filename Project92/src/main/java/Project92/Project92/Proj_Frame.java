package Project92.Project92;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Proj_Frame {

	private JFrame frame;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private boolean show = false;

	public Proj_Frame() {
		frame = new JFrame("projeto");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.pack();
		init();
	}

	public void addFrameContent() {
		frame.setLayout(new BorderLayout());

		JPanel tools_pane = new JPanel(new BorderLayout());
		JPanel titulos = new JPanel(new GridLayout(1, 2));
		JPanel metodos = new JPanel(new GridLayout(4, 4));
		JLabel PMD = new JLabel("PMD");
		JLabel iPlasma = new JLabel("iPlasma");
		titulos.add(PMD);
		titulos.add(iPlasma);
		tools_pane.add(titulos, BorderLayout.NORTH);
		tools_pane.add(metodos, BorderLayout.CENTER);
		
		// ------------------------------------------------------------------------------------
		// panel which will contain 2 others to sort buttons
		JPanel south = new JPanel(new GridLayout(2, 1));
		// panels belonging to south panel
		JPanel up = new JPanel(); // graph, calculate dci, dii, etc and excel button
		JPanel down = new JPanel(); // simple and advanced search
		// -----------------------------------------------------------------------------------
		south.add(up);
		south.add(down);
		
		//botoes e suas funções do painel up presente no south
		consultarIndicadores(metodos, up);
		abrirExcel(up);
		criarGrafico(up);//por fazer
			
		//adicionar à frame!!!!!!
		frame.add(tools_pane, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
	}
	
	private void criarGrafico(JPanel up) {
		JButton grafico = new JButton("Comparar ferramentas");
		up.add(grafico);
		//começar ação correspondente ao botão
		grafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proj_Frame.escolherTipoGrafico();
			}
		});
	}
	
	private static void escolherTipoGrafico() {
		//configurações da frame onde utilizador escolhe o que será utilizado
		JFrame auxiliar = new JFrame("Escolha o tipo de gráfico");
		auxiliar.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		auxiliar.setLocation(dimension.width / 2 - (200 / 2), dimension.height / 2 - (200 / 2));
		auxiliar.setVisible(true);
		auxiliar.setLayout(new GridLayout(2,1));
		
		//criar titulo
		JLabel titulo = new JLabel("Escolha o gráfico pretendido");
		auxiliar.add(titulo);
		
		//criar comboBox
		JComboBox escolhas = new JComboBox();
		
	}

	private void abrirExcel(JPanel up) {
		JButton open_excel = new JButton("Abrir Excel");
		up.add(open_excel);
		open_excel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(new File("Long-Method.xlsx"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	private void consultarIndicadores(JPanel metodos, JPanel up) {
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				switch (i) {
				case 1:
					JLabel label;
					if (j == 0 || j == 2)
						label = new JLabel("DCI: ");
					else if (j == 1) {
						label = new JLabel("" + Avaliacao_Ferramentas.dci("PMD"));
						label.setVisible(false);
						labels.add(label);
					} else {
						label = new JLabel("" + Avaliacao_Ferramentas.dci("iPlasma"));
						label.setVisible(false);
						labels.add(label);
					}
					metodos.add(label);
					break;
				case 2:
					JLabel label1;
					if (j == 0 || j == 2)
						label1 = new JLabel("DII: ");
					else if (j == 1) {
						label1 = new JLabel("" + Avaliacao_Ferramentas.dii("PMD"));
						label1.setVisible(false);
						labels.add(label1);
					} else {
						label1 = new JLabel("" + Avaliacao_Ferramentas.dii("iPlasma"));
						label1.setVisible(false);
						labels.add(label1);
					}
					metodos.add(label1);
					break;
				case 3:
					JLabel label2;
					if (j == 0 || j == 2)
						label2 = new JLabel("ADCI: ");
					else if (j == 1) {
						label2 = new JLabel("" + Avaliacao_Ferramentas.adci("PMD"));
						label2.setVisible(false);
						labels.add(label2);
					} else {
						label2 = new JLabel("" + Avaliacao_Ferramentas.adci("iPlasma"));
						label2.setVisible(false);
						labels.add(label2);
					}
					metodos.add(label2);
					break;
				case 4:
					JLabel label3;
					if (j == 0 || j == 2)
						label3 = new JLabel("ADII: ");
					else if (j == 1) {
						label3 = new JLabel("" + Avaliacao_Ferramentas.adii("PMD"));
						label3.setVisible(false);
						labels.add(label3);
					} else {
						label3 = new JLabel("" + Avaliacao_Ferramentas.adii("iPlasma"));
						label3.setVisible(false);
						labels.add(label3);
					}
					metodos.add(label3);
					break;
				default:
					System.out.println("ALGUMA COISA ERRADA");
					break;
				}
			}
		}
		// Button to show values
		JButton activate = new JButton("Calcular indicadores");
		activate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!show) {
					show = true;
					for (JLabel aux : labels)
						aux.setVisible(true);
				} else {
					show = false;
					for (JLabel aux : labels) {
						aux.setVisible(false);
					}
				}
			}
		});
		up.add(activate, BorderLayout.SOUTH);
	}

	private void init() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width / 2 - (300 / 2), dimension.height / 2 - (150 / 2));
		frame.setSize(400, 250);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Proj_Frame();
	}

}
