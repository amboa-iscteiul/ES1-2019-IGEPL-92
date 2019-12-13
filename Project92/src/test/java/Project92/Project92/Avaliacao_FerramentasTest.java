package Project92.Project92;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class Avaliacao_FerramentasTest extends TestCase {

	public void testDci() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.dci("iPlasma");
		int output2 = af.dci("PWD");
		assertNotEquals(0, output1);
		assertNotEquals(0, output2);
		
	}

	public void testCustomized_dci() {
		fail("Not yet implemented");
	}

	public void testCustomized_dii() {
		fail("Not yet implemented");
	}

	public void testCustomized_adci() {
		fail("Not yet implemented");
	}

	public void testCustomized_adii() {
		fail("Not yet implemented");
	}

	public void testNormal_search() {
		fail("Not yet implemented");
	}

	public void testAdvance_search() {
		fail("Not yet implemented");
	}

	public void testDii() {
		fail("Not yet implemented");
	}

	public void testAdci() {
		fail("Not yet implemented");
	}

	public void testAdii() {
		fail("Not yet implemented");
	}

}
