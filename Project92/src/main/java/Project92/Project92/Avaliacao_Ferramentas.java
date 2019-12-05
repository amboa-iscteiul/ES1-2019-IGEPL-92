package Project92.Project92;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Avaliacao_Ferramentas {

	File file = new File("Long-Method.xlsx");
	XSSFSheet excel_sheet;

	public static void main(String[] args) {
		Avaliacao_Ferramentas ava = new Avaliacao_Ferramentas();
		ava.getSheet();
		ava.dii("iPlasma");
	}

	private void getSheet() {
		try {
			FileInputStream file = new FileInputStream(this.file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			System.out.println("Sheet done");
			excel_sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int dci(String ferramenta) {
		int dci = 0;
		boolean aux;
		boolean ferr_bool;
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			ferr_bool = excel_sheet.getRow(i).getCell(10).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				System.out.println(ferramenta + " " + i);
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

	public int dii(String ferramenta) {
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

	public int adci(String ferramenta) {
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

	public int adii(String ferramenta) {
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

}
