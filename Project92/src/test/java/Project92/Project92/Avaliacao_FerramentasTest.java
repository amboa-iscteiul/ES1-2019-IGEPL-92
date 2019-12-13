package Project92.Project92;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import junit.framework.TestCase;

public class Avaliacao_FerramentasTest extends TestCase {
	
	Avaliacao_Ferramentas avaliacao_ferramentas;
	File file = new File("Long-Method.xlsx");
	static XSSFSheet excel_sheet;
	String ferramenta = new String("");
	boolean aux;
	ArrayList<Boolean> list;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDci() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.dci("iPlasma");
		int output2 = af.dci("pmd");
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
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.dii("iPlasma");
		int output2 = af.dii("pmd");
		assertEquals(0, output1);
		assertNotEquals(0, output2);
	}

	public void testAdci() {
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
		
		
	}

	public void testAdii() {
		Avaliacao_Ferramentas af = new Avaliacao_Ferramentas();
		int output1 = af.adii("iPlasma");
		int output2 = af.adii("pmd");
		assertEquals(0, output1);
		assertEquals(0, output2);
		assertEquals(output1, output2);
		
	}

}