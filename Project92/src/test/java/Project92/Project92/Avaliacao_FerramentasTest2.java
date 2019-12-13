package Project92.Project92;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import junit.framework.TestCase;

public class Avaliacao_FerramentasTest2 extends TestCase {

	Avaliacao_Ferramentas avaliacao_ferramentas;
	File file = new File("Long-Method.xlsx");
	static XSSFSheet excel_sheet;
	String ferramenta = new String("Qualquer texto entre aspas é uma String");
	ArrayList<Boolean> list;
	
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMain() {
		fail("Not yet implemented");
	}

	public void testDci() {
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.dci(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.dci(ferramenta));
	}

	public void testCustomized_dci() {
		Avaliacao_Ferramentas.customized_dci(list);
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
