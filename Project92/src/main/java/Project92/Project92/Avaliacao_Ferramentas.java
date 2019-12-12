package Project92.Project92;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Avaliacao_Ferramentas {

	private static File file = new File("Long-Method.xlsx");
	private static XSSFSheet excel_sheet;

//	
//	//main não necessária
//	public static void main(String[] args) {
//		Avaliacao_Ferramentas.getSheet();
//		Avaliacao_Ferramentas.dii("iPlasma");
//	}

	private static void getSheet() {
		try {
			FileInputStream file = new FileInputStream(Avaliacao_Ferramentas.file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			excel_sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int dci(String ferramenta) {
		Avaliacao_Ferramentas.getSheet();
		int dci = 0;
		boolean aux;
		boolean ferr_bool;
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			ferr_bool = excel_sheet.getRow(i).getCell(10).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				if (aux == ferr_bool && aux == true)
					dci++;
			}
			else
				if (aux == ferr_bool && aux == true)
					dci++;;
		}
		System.out.println("DCI da ferramenta " + ferramenta + " é igual a: " + dci);
		return dci;
	}

	public static int dii(String ferramenta) {
		Avaliacao_Ferramentas.getSheet();
		int dii = 0;
		boolean aux;
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				if (aux != excel_sheet.getRow(i).getCell(9).getBooleanCellValue() && aux == false)
					dii++;
			}
			else
				if (aux != excel_sheet.getRow(i).getCell(10).getBooleanCellValue() && aux == false)
					dii++;;
		}
		System.out.println("DII da ferramenta " + ferramenta + " é igual a: " + dii);
		return dii;
	}

	public static int adci(String ferramenta) {
		Avaliacao_Ferramentas.getSheet();
		int adci = 0;
		boolean aux;
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				if (aux == excel_sheet.getRow(i).getCell(9).getBooleanCellValue() && aux == false)
					adci++;
			}
			else
				if (aux == excel_sheet.getRow(i).getCell(10).getBooleanCellValue() && aux == false)
					adci++;;
		}
		System.out.println("ADCI da ferramenta " + ferramenta + " é igual a: " + adci);
		return adci;
	}

	public static int adii(String ferramenta) {
		Avaliacao_Ferramentas.getSheet();
		int adii = 0;
		boolean aux;
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				if (aux != excel_sheet.getRow(i).getCell(9).getBooleanCellValue() && aux == true)
					adii++;
			}
			else
				if (aux != excel_sheet.getRow(i).getCell(10).getBooleanCellValue() && aux == true)
					adii++;;
		}
		System.out.println("ADII da ferramenta " + ferramenta + " é igual a: " + adii);
		return adii;
	}
	
	public ArrayList<Integer>getListOfAllValues(){
		ArrayList<Integer>listOfValues = new ArrayList();
		listOfValues.add(Avaliacao_Ferramentas.dci("PMD"));
		listOfValues.add(Avaliacao_Ferramentas.dci("iPlasma"));
		listOfValues.add(Avaliacao_Ferramentas.dii("PMD"));
		listOfValues.add(Avaliacao_Ferramentas.dii("iPlasma"));
		listOfValues.add(Avaliacao_Ferramentas.adci("PMD"));
		listOfValues.add(Avaliacao_Ferramentas.adci("iPlasma"));
		listOfValues.add(Avaliacao_Ferramentas.adii("PMD"));
		listOfValues.add(Avaliacao_Ferramentas.adii("iPlasma"));
		return listOfValues;
	}
	
	

}
