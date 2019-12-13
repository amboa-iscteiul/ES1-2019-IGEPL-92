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
	String ferramenta = new String("Qualquer texto entre aspas é uma String");
	boolean aux;
	ArrayList<Boolean> list;

	public void testDci() {
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.dci(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.dci(ferramenta));
		
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
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.dii(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.dii(ferramenta));
	}

	public void testAdci() {
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.adci(ferramenta));
	}

	public void testAdii() {
		ferramenta = "iPlasma";
		assertNotNull(Avaliacao_Ferramentas.adii(ferramenta));
		ferramenta = "PMD";
		assertNotNull(Avaliacao_Ferramentas.adii(ferramenta));
	}

}