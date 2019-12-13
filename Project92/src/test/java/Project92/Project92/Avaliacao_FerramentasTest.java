package Project92.Project92;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Avaliacao_FerramentasTest {
	
	Avaliacao_Ferramentas avaliacao_ferramentas;
	File file = new File("Long-Method.xlsx");
	static XSSFSheet excel_sheet;
	String ferramenta = new String("Qualquer texto entre aspas é uma String");


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testDci() {
		assertNotNull(Avaliacao_Ferramentas.dci(ferramenta));
	}

	@Test
	public void testCustomized_dci() {
		fail("Not yet implemented");
	}

	@Test
	public void testCustomized_dii() {
		fail("Not yet implemented");
	}

	@Test
	public void testCustomized_adci() {
		fail("Not yet implemented");
	}

	@Test
	public void testCustomized_adii() {
		fail("Not yet implemented");
	}

	@Test
	public void testNormal_search() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdvance_search() {
		fail("Not yet implemented");
	}

	@Test
	public void testDii() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdci() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdii() {
		fail("Not yet implemented");
	}

}
