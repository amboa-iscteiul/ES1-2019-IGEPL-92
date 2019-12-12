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

	public static void main(String[] args) {
		Avaliacao_Ferramentas.getSheet();
		Avaliacao_Ferramentas.dii("iPlasma");
		//normal_search(">", 5, "<",10 );
		Advance_search("ATFD", ">", 0, "LAA", ">", 0, "AND");
	
	}

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
	public static int customized_dci(ArrayList<Boolean> list) {
		Avaliacao_Ferramentas.getSheet();
		int dci = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(aux == list.get(j) && aux == true) {
				dci++;
			}
		}
		return dci;	
	}
	public static int customized_dii(ArrayList<Boolean> list) {
		Avaliacao_Ferramentas.getSheet();
		int dii = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==true && aux == false) {
				dii++;
			}
		}
		return dii;	
	}
	public static int customized_adci(ArrayList<Boolean> list) {
		Avaliacao_Ferramentas.getSheet();
		int adci = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==false && aux == false) {
				adci++;
			}
		}
		return adci;	
	}
	public static int customized_adii(ArrayList<Boolean> list) {
		Avaliacao_Ferramentas.getSheet();
		int adii = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==false && aux == true) {
				adii++;
			}
		}
		return adii;	
	}
	
	
	
	public static void normal_search(String s_cyclo,double threshold_cyclo,String s_loc,double threshold_loc) {
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		int maxRows = excel_sheet.getLastRowNum();
		double CYCLO;
		double LOC;
			 
			 if(s_cyclo.equals(s_loc) && s_cyclo.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
				 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
				 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 
				 if(CYCLO < threshold_cyclo && LOC < threshold_loc) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			 else if(s_cyclo.equals(s_loc) && s_cyclo.equals(">")) {
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
					 
				 if(CYCLO > threshold_cyclo && LOC > threshold_loc) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
			 }
			 }
			 
			 else if(s_cyclo.equals(">") && s_loc.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 
				 if(CYCLO > threshold_cyclo && LOC < threshold_loc) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 } 
				 
				 } 
			 }
			 else if(s_cyclo.equals("<") && s_loc.equals(">")) {
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 if(CYCLO < threshold_cyclo && LOC > threshold_loc) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 } 
				 }
			 }
		
		//System.out.println(list);
	}
	
	public static void Advance_search(String Metrica_1,String s_Metrica_1,double threshold_Metrica_1,String Metrica_2,String s_Metrica_2,double threshold_Metrica_2,String Ope_Log) {
		int x=0;//numero da cell da metrica 1 escolhida
		int y=0;//numero da cell da metrica 2 escolhida
		int maxRows = excel_sheet.getLastRowNum();
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		
		//ter o numero da cell
		for (int i = 4; i <= 7; i++) {
			if(excel_sheet.getRow(0).getCell(i).getStringCellValue().equals(Metrica_1)) {
				x=i-1;
				System.out.println(excel_sheet.getRow(0).getCell(i).getStringCellValue() + " = " +"Metrica 1 = " +Metrica_1 + " " + "com cell a " +"x = " + x);
}
			if(excel_sheet.getRow(0).getCell(i).getStringCellValue().equals(Metrica_2)) {
				y=i-1;
				System.out.println(excel_sheet.getRow(0).getCell(i).getStringCellValue() + " = " + "Metrica 2 = " +Metrica_2 + " " + "com cell a " + "y = " +y);
			}
		}//fim do for++
		
//----------------------------------------------------------------------------------------------------		
		if(Ope_Log.equals("AND")) {//INICIO DO AND----------------------------------
			//inicio de primeira hipotese, AND e <
			if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 < threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			}//fim de primeira hipotese AND e <
//--------------------------------------------------------------------------------------------------			
			//inicio de segunda hipotese, AND e >
			else if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 > threshold_Metrica_1 && value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			
			
		}//fim de segunda  hipotese AND e >
//-------------------------------------------------------------------------------------------------------
		//inicio de terceira hipotese AND e <,>	
			else if( s_Metrica_1.equals("<") && s_Metrica_2.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 < threshold_Metrica_1 && value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
		}//fim de terceira hipotese AND e <,>		
//--------------------------------------------------------------------------------------------------------			
		//inicio de quarta hipotese AND e >,<	
			else if( s_Metrica_1.equals(">") && s_Metrica_2.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 > threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}	
			}//fim de quarta hipotese AND e >,<
//-------------------------------------------------------------------------------------------------------			
		}//FIM DO AND--------------------------------------------------------------------------------------
		
		else if(Ope_Log.equals("OR")) {//INICIO DO OR--------------------------------------------------------------
			//inicio da quinta hipotese OR e <
			if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 < threshold_Metrica_1 || value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
			}
		}//fim de quinta hipotese OR e <
//------------------------------------------------------------------------------------------------
			//inicio de sexta hipotese, OR e >
			else if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 > threshold_Metrica_1 || value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			
			
		}//fim de sexta hipotese OR e >
//----------------------------------------------------------------------------------------------------
			//inicio de sétima hipotese OR e <,>	
			else if( s_Metrica_1.equals("<") && s_Metrica_2.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 < threshold_Metrica_1 || value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
		}//fim de sétima hipotese OR e <,>	
//------------------------------------------------------------------------------------------------------			
			//inicio de oitava hipotese OR e >,<	
			else if( s_Metrica_1.equals(">") && s_Metrica_2.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					double value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
					if(value_M1 > threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}	
			}//fim de oitava hipotese OR e >,<
		
		}//FIM DO OR
		//System.out.println(list);
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

}