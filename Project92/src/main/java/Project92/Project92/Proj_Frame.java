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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Proj_Frame {

	private JFrame frame;
	private ArrayList<JLabel> labels = new ArrayList<JLabel>();
	private boolean show = false;

	private boolean ativo_long = false;
	private boolean ativo_feat = false;

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

		// botoes e suas funções do painel up presente no south
		consultarIndicadores(metodos, up);
		abrirExcel(up);
		criarGrafico(up);// por fazer

		// botoes e suas funções do painel down presente no south
		procura_simples(down);
		procura_avançada();

		// adicionar à frame!!!!!!
		frame.add(tools_pane, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
	}

	private void criarGrafico(JPanel up) {
		JButton grafico = new JButton("Comparar ferramentas");
		up.add(grafico);
		// começar ação correspondente ao botão
		grafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proj_Frame.escolherTipoGrafico();
			}
		});
	}

	private static void escolherTipoGrafico() {
		// configurações da frame onde utilizador escolhe o que será utilizado
		JFrame auxiliar = new JFrame("Escolha o tipo de gráfico");
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		auxiliar.setLocation(dimension.width / 2 - (200 / 2), dimension.height / 2 - (200 / 2));
		auxiliar.setVisible(true);
		auxiliar.setLayout(new GridLayout(3, 1));

		// criar titulo
		JLabel titulo = new JLabel("Escolha o gráfico pretendido");
		auxiliar.add(titulo);

		// criar comboBox
		String[] str = new String[] { "Gráfico", "Pie Chart", "Tabela" };
		final JComboBox<String> escolhas = new JComboBox<String>(str);
		escolhas.setPreferredSize(new Dimension(75, escolhas.getPreferredSize().height));
		System.out.println(escolhas.isPreferredSizeSet());
		auxiliar.add(escolhas);

		// criar botão para escolher o tipo de gráfico
		JButton ok = new JButton("Ok");
		auxiliar.add(ok);

		// carregar em "ok" para ler o que foi selecionado na comboBox e devolver
		// tabela/pie/grafico
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) escolhas.getSelectedItem()).equals("Gráfico")) {
					// devolver gráfico
					System.out.println("Teste Gráfico");
				}

				else if (((String) escolhas.getSelectedItem()).equals("Pie Chart")) {
					// devolver pie chart
					System.out.println("Teste Pie Chart");
				}

				else {
					// devolver tabela
					// opcional: mudar else para else if com condição "igual" às anteriores
					System.out.println("Teste Tabela");
				}
			}
		});
		auxiliar.pack();
//		auxiliar.setSize(300, 300);

	}

	private void procura_simples(JPanel down) {
		JButton proc = new JButton("Procura Simples");
		down.add(proc);
		proc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ComboBox para símbolos (< ou >) e caixa de texto para inserir thresholds
				JFrame aux = new JFrame("Procura Simples");
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				aux.setLocation(dimension.width / 2 - (200 / 2), dimension.height / 2 - (200 / 2));
				aux.setVisible(true);
				aux.setLayout(new BorderLayout());
				JPanel geral = new JPanel(new GridLayout(2, 1));

				// is_long_method ou feature_envy
				JPanel long_method = new JPanel();
				JPanel feature = new JPanel();

				// mudar layouts dos paineis
				long_method.setLayout(new BorderLayout());
				feature.setLayout(new BorderLayout());

				// geral para ambosos paineis
				ArrayList<JComboBox<String>> combos = new ArrayList<>();
				String[] v_sinais = new String[] { ">", "<", ">=", "<=" }; // RETIRAR SE NECESSÁRIO
				for (int i = 0; i < 4; i++)
					combos.add(new JComboBox<String>(v_sinais));
				ArrayList<JLabel> labels_need = new ArrayList<>();
				for (int i = 0; i < 2; i++)
					labels_need.add(new JLabel("Thresholds e Sinais:"));

				// criar itens usados em long_method
				final JRadioButton long_meth = new JRadioButton("is_long_method");
				final JPanel thresholds_long = new JPanel(new GridLayout(2, 1)); // titulo mais painel
				final JPanel limites_sinais = new JPanel(new GridLayout(2, 3)); // metricas, Combo e Texto
				JLabel metrica1_long = new JLabel("POR METRICA: "); // POR METRICA AQUI
				JLabel metrica2_long = new JLabel("POR METRICA AQUI: "); // POR METRICA AQUI
				JTextField threshold_m1_long = new JTextField("Limite para métrica 1");
				JTextField threshold_m2_long = new JTextField("Limite para métrica 2");

				// adicionar a thresholds_long
				thresholds_long.add(labels_need.get(0));
				thresholds_long.add(limites_sinais);

				// adicionar a limites_sinais, linha 1
				limites_sinais.add(metrica1_long);
				limites_sinais.add(combos.get(0));
				limites_sinais.add(threshold_m1_long);

				// adicionar a limites_sinais, linha 2
				limites_sinais.add(metrica2_long);
				limites_sinais.add(combos.get(1));
				limites_sinais.add(threshold_m2_long);

				limites_sinais.setVisible(false);

				// criar itens usados em feature
				final JRadioButton feature_envy = new JRadioButton("feature_envy");
				final JPanel thresholds_feat = new JPanel(new GridLayout(2, 1)); // titulo mais painel
				final JPanel limites_sinais_feat = new JPanel(new GridLayout(2, 3)); // metricas, Combo e Texto
				JLabel metrica1_feat = new JLabel("POR METRICA AQUI: "); // POR METRICA AQUI
				JLabel metrica2_feat = new JLabel("POR METRICA AQUI: "); // POR METRICA AQUI
				JTextField threshold_m1_feat = new JTextField("Limite para métrica 1");
				JTextField threshold_m2_feat = new JTextField("Limite para métrica 2");

				// adicionar a thresholds_long
				thresholds_feat.add(labels_need.get(1));
				thresholds_feat.add(limites_sinais_feat);

				// adicionar a limites_sinais, linha 1 (feature)
				limites_sinais_feat.add(metrica1_feat);
				limites_sinais_feat.add(combos.get(2));
				limites_sinais_feat.add(threshold_m1_feat);

				// adicionar a limites_sinais, linha 2 (feature)
				limites_sinais_feat.add(metrica2_feat);
				limites_sinais_feat.add(combos.get(3));
				limites_sinais_feat.add(threshold_m2_feat);

				limites_sinais_feat.setVisible(false);

				// adicionar aos paineis
				long_method.add(long_meth, BorderLayout.WEST);
				long_method.add(thresholds_long, BorderLayout.CENTER);
				feature.add(feature_envy, BorderLayout.WEST);
				feature.add(thresholds_feat, BorderLayout.CENTER);

				// ação quando se escolhe long_method
				long_meth.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (long_meth.isSelected() && !ativo_long) {
							feature_envy.setEnabled(false);
							limites_sinais.setVisible(true);
							ativo_long = true;
						} else if (ativo_long) {
							feature_envy.setEnabled(true);
							limites_sinais.setVisible(false);
							ativo_long = false;
						}
					}
				});

				// ação quando se escolhe feature_envy
				feature_envy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (feature_envy.isSelected() && !ativo_feat) {
							long_meth.setEnabled(false);
							limites_sinais_feat.setVisible(true);
							ativo_feat = true;
						} else if (ativo_feat) {
							long_meth.setEnabled(true);
							limites_sinais_feat.setVisible(false);
							ativo_feat = false;
						}
					}
				});
				//fazer e adicionar botões
				JPanel botoes = new JPanel();
				JButton pre_vis = new JButton("Pré-Visualizar");
				JButton finish = new JButton("Ok");

				botoes.add(pre_vis);
				botoes.add(finish);
				
				// adicionar ao painel geral e à frame
				geral.add(long_method);
				geral.add(feature);
				aux.add(geral, BorderLayout.CENTER);
				aux.add(botoes, BorderLayout.SOUTH);

				aux.pack();
			}
		});
	}

	private void procura_avançada() {

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
	
	private void importarExcel() { //PAULO
		
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
		frame.pack();
	}

	public static void main(String[] args) {
		new Proj_Frame();
	}

}
