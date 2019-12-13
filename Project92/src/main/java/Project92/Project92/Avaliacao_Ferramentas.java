package Project92.Project92;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author ES1-2019-IGEPL-92
 *
 */
public class Avaliacao_Ferramentas {

	private static File file = new File("Long-Method.xlsx");
	private static XSSFSheet excel_sheet;

	/**
	 * this method creates a excel sheet 
	 */
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

	/**
	 * this method returns the dci for the iPlasma or the PMD 
	 * @param ferramenta - String to differentiate iPlasma from PMd
	 * @return count of dci
	 */
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
		return dci;
	}
	
	/**
	 * this method returns the dci for the iPlasma or the PMD with the method crated by the user
	 * @param list - list of booleans with the result analysed with the method created by the user
	 * @param met - String to differentiate iPlasma from PMd
	 * @return count of dci
	 */
	public static int customized_dci(ArrayList<Boolean> list,String met) {
		Avaliacao_Ferramentas.getSheet();
		int dci = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		if(met.equals("long")) {
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(aux == list.get(j) && aux == true) {
				dci++;
			}
		}
		}
		else if(met.equals("envy")) {
			for (int i = 1,j=0; i < maxRows; i++,j++) {
				aux = excel_sheet.getRow(i).getCell(11).getBooleanCellValue();
				if(aux == list.get(j) && aux == true) {
					dci++;
				
				}
			}
			
			
			
			
		}
		return dci;	  
	}
	/**
	 * this method returns the dii for the iPlasma or the PMD with the method crated by the user
	 * @param list- list of booleans with the result analysed with the method created by the user
	 * @param met - String to differentiate iPlasma from PMd
	 * @return count of dii
	 */
	public static int customized_dii(ArrayList<Boolean> list,String met) {
		Avaliacao_Ferramentas.getSheet();
		int dii = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		if(met.equals("long")) {
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==true && aux == false) {
				dii++;
			}
		}
		}
		else if(met.equals("envy")) {
			
			for (int i = 1,j=0; i < maxRows; i++,j++) {
				aux = excel_sheet.getRow(i).getCell(11).getBooleanCellValue();
				if(list.get(j)==true && aux == false) {
					dii++;
				}
			}	
		}
		
		
		
		
		return dii;	
	}
	/**
	 * this method returns the adci for the iPlasma or the PMD with the method crated by the user
	 * @param list - list of booleans with the result analysed with the method created by the user
	 * @param met - String to differentiate iPlasma from PMd
	 * @return count of adci
	 */
	public static int customized_adci(ArrayList<Boolean> list,String met) {
		Avaliacao_Ferramentas.getSheet();
		int adci = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		if(met.equals("long")) {
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==false && aux == false) {
				adci++;
			}
		}
		}
		else if(met.equals("envy")) {
			for (int i = 1,j=0; i < maxRows; i++,j++) {
				aux = excel_sheet.getRow(i).getCell(11).getBooleanCellValue();
				if(list.get(j)==false && aux == false) {
					adci++;
				}
			}
		}
		return adci;	
	}
	/**
	 * this method returns the adii for the iPlasma or the PMD with the method crated by the user
	 * @param list - list of booleans with the result analysed with the method created by the user
	 * @param met - String to differentiate iPlasma from PMd
	 * @return - count of adii
	 */
	public static int customized_adii(ArrayList<Boolean> list,String met) {
		Avaliacao_Ferramentas.getSheet();
		int adii = 0;
		int maxRows = excel_sheet.getLastRowNum();
		boolean aux;
		if(met.equals("long")) {
		for (int i = 1,j=0; i < maxRows; i++,j++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if(list.get(j)==false && aux == true) {
				adii++;
			}
		}
		}
		else if(met.equals("envy")) {
			for (int i = 1,j=0; i < maxRows; i++,j++) {
				aux = excel_sheet.getRow(i).getCell(11).getBooleanCellValue();
				if(list.get(j)==false && aux == true) {
					adii++;
				}
			}
			
			
		}
		return adii;	
	}
	
	
	/**
	 * function that alows the user to create his own rules in the is-long_method and is_feature_envy method to detect errors
	 * @param Met - String to differentiate if it's going to compare to the is_Long_Method or the is_feature_envy
	 * @param s1 -  Symbol(lesser than or greater then) chosen by the user for the first metric, cyclo for is_long_method or atfd for is_feature_envy
	 * @param t1 - Limit chosen by the user for the first metric
	 * @param s2 - Symbol(lesser than or greater then) chosen by the user for the first metric, LOC for is_long_method or LAA for is_feature_envy
	 * @param t2 - Limit chosen by the user for the second metric
	 * @return list of booleans in analysing is_long-method or is-feature_envy with the rules the user chose
	 */
	public static ArrayList<Boolean> normal_search(String Met,String s1,double t1,String s2,double t2) {
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		int maxRows = excel_sheet.getLastRowNum();
		
		
		if(Met.equals("long")) {
		double CYCLO;
		double LOC; 
			 if(s1.equals(s2) && s1.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
				 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
				 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 
				 if(CYCLO < t1 && LOC < t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			  if(s1.equals(s2) && s1.equals(">")){
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
					 
				 if(CYCLO > t1 && LOC > t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
			 }
				
			 }
			 
			  if(s1.equals(">") && s2.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 
				 if(CYCLO > t1 && LOC < t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 } 
				 
				 } 
			 }
			  if(s1.equals("<") && s2.equals(">")) {
				 for (int i = 1; i < maxRows; i++) {
					 CYCLO= excel_sheet.getRow(i).getCell(5).getNumericCellValue();
					 LOC= excel_sheet.getRow(i).getCell(4).getNumericCellValue();
				 if(CYCLO < t1 && LOC > t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 } 
				 }
			 }
		}
//----------------------------------------------------------------------------------------------------------------------
		else if(Met.equals("envy")) {
			double ATFD;
			double LAA; 
			
			if(s1.equals(s2) && s1.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
				 ATFD= excel_sheet.getRow(i).getCell(6).getNumericCellValue();
				 
				 if(excel_sheet.getRow(i).getCell(7).getCellType().equals(excel_sheet.getRow(i).getCell(7).getCellType().STRING)) {
					 LAA= Double.parseDouble(excel_sheet.getRow(i).getCell(7).getStringCellValue());
				 }
				 else {
					 LAA= excel_sheet.getRow(i).getCell(7).getNumericCellValue();
				 }
				 if(ATFD < t1 && LAA < t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			if(s1.equals(s2) && s1.equals(">")) {
				 for (int i = 1; i < maxRows; i++) {
				 ATFD= excel_sheet.getRow(i).getCell(6).getNumericCellValue();
				 
				 if(excel_sheet.getRow(i).getCell(7).getCellType().equals(excel_sheet.getRow(i).getCell(7).getCellType().STRING)) {
					 LAA= Double.parseDouble(excel_sheet.getRow(i).getCell(7).getStringCellValue());
				 }
				 else {
					 LAA= excel_sheet.getRow(i).getCell(7).getNumericCellValue();
				 }
				 if(ATFD > t1 && LAA > t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			if(s1.equals(">") && s2.equals("<")) {
				 for (int i = 1; i < maxRows; i++) {
				 ATFD= excel_sheet.getRow(i).getCell(6).getNumericCellValue();
				 
				 if(excel_sheet.getRow(i).getCell(7).getCellType().equals(excel_sheet.getRow(i).getCell(7).getCellType().STRING)) {
					 LAA= Double.parseDouble(excel_sheet.getRow(i).getCell(7).getStringCellValue());
				 }
				 else {
					 LAA= excel_sheet.getRow(i).getCell(7).getNumericCellValue();
				 }
				 if(ATFD > t1 && LAA < t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			
			if(s1.equals("<") && s2.equals(">")) {
				 for (int i = 1; i < maxRows; i++) {
				 ATFD= excel_sheet.getRow(i).getCell(6).getNumericCellValue();
				 
				 if(excel_sheet.getRow(i).getCell(7).getCellType().equals(excel_sheet.getRow(i).getCell(7).getCellType().STRING)) {
					 LAA= Double.parseDouble(excel_sheet.getRow(i).getCell(7).getStringCellValue());
				 }
				 else {
					 LAA= excel_sheet.getRow(i).getCell(7).getNumericCellValue();
				 }
				 if(ATFD < t1 && LAA > t2) {
					 list.add(true);
				 }
				 else {
					 list.add(false);
				 }
				 }
				 
			 }
			
			
		}
		
		//System.out.println(list);
			 return list;
	}
	/**
	 * This function serves for the user can create his/her own method to detect errors, it allows to chose two metrics 
	 * and the symbols,thresholds and logic operator that together it makes a new method to detect error
	 * @param Metrica_1 - First metric chosen by the user
	 * @param s_Metrica_1 - Symbol(lesser than or greater then) chosen by the user for the first metric
	 * @param threshold_Metrica_1 - Limit chosen by the user for the first metric
	 * @param Metrica_2 - Second metric chosen by the user
	 * @param s_Metrica_2 - Symbol(lesser than or greater then) chosen by the user for the  metric
	 * @param threshold_Metrica_2 - Limit chosen by the user for the second metric
	 * @param Ope_Log - logic operator(AND or OR) for the result of the first and second metric
	 * @return List with booleans to compare to either iPlasma or PMD
	 */
	@SuppressWarnings("static-access")
	public static ArrayList<Boolean> Advance_search(String Metrica_1,String s_Metrica_1,double threshold_Metrica_1,String Metrica_2,String s_Metrica_2,double threshold_Metrica_2,String Ope_Log) {
		int x=0;//numero da cell da metrica 1 escolhida
		int y=0;//numero da cell da metrica 2 escolhida
		int maxRows = excel_sheet.getLastRowNum();
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		
		//ter o numero da cell
		for (int i = 4; i <= 7; i++) {
			if(excel_sheet.getRow(0).getCell(i).getStringCellValue().equals(Metrica_1)) {
				x=i;
				System.out.println(excel_sheet.getRow(0).getCell(i).getStringCellValue() + " = " +"Metrica 1 = " +Metrica_1 + " " + "com cell a " +"x = " + x);
}
			if(excel_sheet.getRow(0).getCell(i).getStringCellValue().equals(Metrica_2)) {
				y=i;
				System.out.println(excel_sheet.getRow(0).getCell(i).getStringCellValue() + " = " + "Metrica 2 = " +Metrica_2 + " " + "com cell a " + "y = " +y);
			}
		}//fim do for++
		
//----------------------------------------------------------------------------------------------------		
		if(Ope_Log.equals("AND")) {//INICIO DO AND----------------------------------
			//inicio de primeira hipotese, AND e <
			if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 < threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			}//fim de primeira hipotese AND e <
//--------------------------------------------------------------------------------------------------			
			//inicio de segunda hipotese, AND e >
			 if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 > threshold_Metrica_1 && value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			
			
		}//fim de segunda  hipotese AND e >
//-------------------------------------------------------------------------------------------------------
		//inicio de terceira hipotese AND e <,>	
			 if( s_Metrica_1.equals("<") && s_Metrica_2.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 < threshold_Metrica_1 && value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
		}//fim de terceira hipotese AND e <,>		
//--------------------------------------------------------------------------------------------------------			
		//inicio de quarta hipotese AND e >,<	
			 if( s_Metrica_1.equals(">") && s_Metrica_2.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 > threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}	
			}//fim de quarta hipotese AND e >,<
//-------------------------------------------------------------------------------------------------------			
		}//FIM DO AND--------------------------------------------------------------------------------------
		
		 if(Ope_Log.equals("OR")) {//INICIO DO OR--------------------------------------------------------------
			//inicio da quinta hipotese OR e <
			if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 < threshold_Metrica_1 || value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
			}
		}//fim de quinta hipotese OR e <
//------------------------------------------------------------------------------------------------
			//inicio de sexta hipotese, OR e >
			if(s_Metrica_1.equals(s_Metrica_2) && s_Metrica_1.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 > threshold_Metrica_1 || value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
			
			
		}//fim de sexta hipotese OR e >
//----------------------------------------------------------------------------------------------------
			//inicio de sétima hipotese OR e <,>	
			 if( s_Metrica_1.equals("<") && s_Metrica_2.equals(">")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 < threshold_Metrica_1 || value_M2 > threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}
		}//fim de sétima hipotese OR e <,>	
//------------------------------------------------------------------------------------------------------			
			//inicio de oitava hipotese OR e >,<	
			 if( s_Metrica_1.equals(">") && s_Metrica_2.equals("<")) {
				for (int i = 1; i < maxRows; i++) {
					double value_M1=0;
					double value_M2=0;
					if(excel_sheet.getRow(i).getCell(x).getCellType().equals(excel_sheet.getRow(i).getCell(x).getCellType().STRING)) {
						 value_M1 = Double.parseDouble(excel_sheet.getRow(i).getCell(x).getStringCellValue());
						 System.out.println("value_M2 = " + value_M1);
					}
					else {
						value_M1 = excel_sheet.getRow(i).getCell(x).getNumericCellValue();
					}
					if(excel_sheet.getRow(i).getCell(y).getCellType().equals(excel_sheet.getRow(i).getCell(y).getCellType().STRING)) {
						value_M2 = Double.parseDouble(excel_sheet.getRow(i).getCell(y).getStringCellValue());
						System.out.println("value_M2 = " +value_M2);
					}
					else {
						value_M2= excel_sheet.getRow(i).getCell(y).getNumericCellValue();
						
					}
					if(value_M1 > threshold_Metrica_1 && value_M2 < threshold_Metrica_2) {
						list.add(true);
					}else {list.add(false);}
					
				}	
			}//fim de oitava hipotese OR e >,<
		
		}//FIM DO OR
		//System.out.println(list);
		return list;  
}
	
    /**
     * this method returns the dii for the iPlasma or the PMD 
	 * @param ferramenta - String to differentiate iPlasma from PMd
	 * @return count of dii
     */
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
		return dii;
	}

	 /**
	  * this method returns the adci for the iPlasma or the PMD 
	  * @param ferramenta - String to differentiate iPlasma from PMd
	  * @return count of adci
	  */
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
		return adci;  
	}

	 /**
	  * this method returns the adii for the iPlasma or the PMD 
	  * @param ferramenta - String to differentiate iPlasma from PMd
	  * @return count of adii
	  */
	public static int adii(String ferramenta) {  
		Avaliacao_Ferramentas.getSheet();
		int adii = 0;
		boolean aux;  
		int maxRows = excel_sheet.getLastRowNum();
		for (int i = 1; i < maxRows; i++) {
			aux = excel_sheet.getRow(i).getCell(8).getBooleanCellValue();
			if (ferramenta.equals("iPlasma")) {
				if ((aux != excel_sheet.getRow(i).getCell(9).getBooleanCellValue() && aux == true))
					adii++;
			}
			else
				if (aux != excel_sheet.getRow(i).getCell(10).getBooleanCellValue() && aux == true)
					adii++;;
		}
		return adii;
	}

}