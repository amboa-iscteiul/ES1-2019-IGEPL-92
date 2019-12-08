package Project92.Project92;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
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
		// setting layout- 2 columns for tools, 4 rows for evaluation (1 for tools)
		frame.setLayout(new BorderLayout());

		JPanel tools_pane = new JPanel();
		JPanel titulos = new JPanel(new GridLayout(1,2));
		
		tools_pane.setLayout(new BorderLayout());
		frame.add(tools_pane, BorderLayout.CENTER);

		JLabel PMD = new JLabel("PMD");
		JLabel iPlasma = new JLabel("iPlasma");

		titulos.add(PMD);
		titulos.add(iPlasma);
		tools_pane.add(titulos, BorderLayout.NORTH);
		
		JPanel metodos = new JPanel(new GridLayout(4,4));
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
					} else {
						label = new JLabel("" + Avaliacao_Ferramentas.dci("iPlasma"));
						label.setVisible(false);
					}
					metodos.add(label);
					labels.add(label);
					break;
				case 2:
					JLabel label1;
					if (j == 0 || j == 2)
						label1 = new JLabel("DII: ");
					else if (j == 1) {
						label1 = new JLabel("" + Avaliacao_Ferramentas.dii("PMD"));
						label1.setVisible(false);
					} else {
						label1 = new JLabel("" + Avaliacao_Ferramentas.dii("iPlasma"));
						label1.setVisible(false);
					}
					metodos.add(label1);
					labels.add(label1);
					break;
				case 3:
					JLabel label2;
					if (j == 0 || j == 2)
						label2 = new JLabel("ADCI: ");
					else if (j == 1) {
						label2 = new JLabel("" + Avaliacao_Ferramentas.adci("PMD"));
						label2.setVisible(false);
					} else {
						label2 = new JLabel("" + Avaliacao_Ferramentas.adci("iPlasma"));
						label2.setVisible(false);
					}
					metodos.add(label2);
					labels.add(label2);
					break;
				case 4:
					JLabel label3;
					if (j == 0 || j == 2)
						label3 = new JLabel("ADII: ");
					else if (j == 1) {
						label3 = new JLabel("" + Avaliacao_Ferramentas.adii("PMD"));
						label3.setVisible(false);
					} else {
						label3 = new JLabel("" + Avaliacao_Ferramentas.adii("iPlasma"));
						label3.setVisible(false);
					}
					metodos.add(label3);
					labels.add(label3);
					break;
				default:
					System.out.println("ALGUMA COISA ERRADA");
					break;
				}
			}
		}
		
		tools_pane.add(metodos, BorderLayout.CENTER);

		// Button to activate values
		JButton activate = new JButton("Calcular indicadores de qualidade");
		activate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!show) {
					show = true;
					for (JLabel aux : labels)
						aux.setVisible(true);
				}
				else {
					show = false;
					for (JLabel aux : labels)
						aux.setVisible(false);
				}
			}
		});

		frame.add(activate, BorderLayout.SOUTH);
	}

	public void init() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dimension.width / 2 - (300 / 2), dimension.height / 2 - (150 / 2));
		frame.setSize(350, 200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Proj_Frame();
	}

}
