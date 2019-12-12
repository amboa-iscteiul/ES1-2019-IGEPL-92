package Project92.Project92;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ViewportLayout;

public class Table {
	
	public static Avaliacao_Ferramentas Avaliacao_Ferramentas = new Avaliacao_Ferramentas();

	String pmddci =(""+Avaliacao_Ferramentas.dci("PMD"));
	String pmddii =(""+Avaliacao_Ferramentas.dii("PMD"));
	String pmdadci =(""+Avaliacao_Ferramentas.adci("PMD"));
	String pmdadii =(""+Avaliacao_Ferramentas.adii("PMD"));
	String iplasmadci =(""+Avaliacao_Ferramentas.dci("iPlasma"));
	String iplasmadii =(""+Avaliacao_Ferramentas.dii("iPlasma"));
	String iplasmaadci =(""+Avaliacao_Ferramentas.adci("iPlasma"));
	String iplasmaadii =(""+Avaliacao_Ferramentas.adii("iPlasma"));


	public void criarJanela() {
	JFrame aux= new JFrame();
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	aux.setLocation(dimension.width / 2 - (220 / 2), dimension.height / 2 - (250 / 2));
	aux.setLayout(new BorderLayout());
	String data[][] = {{"PMD",pmddci,pmddii,pmdadci,pmdadii},
						{"iPlasma",iplasmadci,iplasmadii,iplasmaadci,iplasmadii}};
	String column[] = {"Description","DCI","DII","ADCI","ADII"};
	JTable tab= new JTable(data,column);
	JScrollPane b= new  JScrollPane(tab);
	aux.add(b, BorderLayout.CENTER);
	aux.setVisible(true);
	aux.pack();
	}
	
	public static void main() {	
		new Table();
	}
}
