package Project92.Project92;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ViewportLayout;

public class Table {
	
	
	
	public void criarJanela() {
	JFrame aux= new JFrame();
	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	aux.setLocation(dimension.width / 2 - (220 / 2), dimension.height / 2 - (250 / 2));
	aux.setLayout(new BorderLayout());
//	JPanel p = new JPanel(new BorderLayout());
	String data[][] = {{"PMD","140","18","261","0"},
						{"iPlasma","140","0","279","0"}};
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
