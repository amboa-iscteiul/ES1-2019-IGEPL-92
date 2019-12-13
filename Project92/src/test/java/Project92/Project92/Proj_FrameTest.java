package Project92.Project92;

import javax.swing.JButton;
import javax.swing.JPanel;

import junit.framework.TestCase;

public class Proj_FrameTest extends TestCase {

	Proj_Frame frame = new Proj_Frame();

	public void testProj_Frame() {
		assertNotNull(frame.frame);
	}

	public void testCriarGrafico() {
		JPanel up = new JPanel();
		frame.criarGrafico(up);
		((JButton) up.getComponent(0)).doClick();
	}

	public void testProcura() {
		JPanel down = new JPanel();
		frame.procura(down);
		((JButton) down.getComponent(0)).doClick();
		//testar todas as opções de click
			//ligar e desligar long_method
		frame.long_meth.doClick(1000);
		frame.pre_vis.doClick();
		frame.feature_envy.doClick(500);
		frame.long_meth.doClick();
		
			//ligar e desligar feature_envy
		frame.feature_envy.doClick(1000);
		frame.pre_vis.doClick();
		frame.long_meth.doClick(500);
		frame.feature_envy.doClick();
		
			//procura avançada
		frame.isAdvanced.doClick();
		frame.isAdvanced.doClick();
		frame.long_meth.doClick();
		frame.finish.doClick();
			
			//reiniciar frame
		frame.procura(down);
		((JButton) down.getComponent(0)).doClick();
		
		frame.feature_envy.doClick();
		frame.finish.doClick();

	}

	public void testGetLabel() {
		assertNotNull(frame.getLabel("DCI"));
		assertNotNull(frame.getLabel("DII"));
		assertNotNull(frame.getLabel("ADCI"));
		assertNotNull(frame.getLabel("ADII"));
		assertNull(frame.getLabel("String qualquer"));
	}

	public void testAbrirExcel() {
		JPanel up = new JPanel();
		frame.abrirExcel(up);
		((JButton) up.getComponent(0)).doClick();
	}

	public void testImportarExcel() {
		JPanel down = new JPanel();
		frame.importarExcel(down);
		((JButton) down.getComponent(0)).doClick();
	}

	public void testConsultarIndicadores() {
		JPanel metodos = new JPanel();
		JPanel up = new JPanel();
		frame.consultarIndicadores(metodos, up);
		((JButton) up.getComponent(0)).doClick();
		((JButton) up.getComponent(0)).doClick();
	}

	public void testMain() {
		String[] args = new String[] {"ola"};
		frame.main(args);
	}

}
