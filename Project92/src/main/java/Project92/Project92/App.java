package Project92.Project92;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class App {
	

	
	
	
    public static void main( String[] args ) throws FileNotFoundException{
        System.out.println( "Hello World!" );
        File fis=new File("C:\\Users\\Jasmine\\Desktop\\Univ\\ES1_Grupo92\\ES1-2019-IGEPL-92\\Project92\\Long-Method.xlsx");  
        readExcelFile(fis);
        
        
    }
    
    
    /**
     * Method to read an Excel File
     *
     */
    public static void readExcelFile(File fileToRead) {
	    try {
	    	DataFormatter df = new DataFormatter();
	    	FileInputStream file = new FileInputStream(fileToRead);
		    //Create Workbook instance holding reference to .xlsx file
		    XSSFWorkbook workbook = new XSSFWorkbook(file);
		    //Get first/desired sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    //Iterate through each rows one by one
		    Iterator<Row> rowIterator = sheet.iterator();
		    while (rowIterator.hasNext()){
		    	Row row = rowIterator.next();
			    //For each row, iterate through all the columns
			    Iterator<Cell> cellIterator = row.cellIterator();
			    while (cellIterator.hasNext()) {
			    	Cell cell = cellIterator.next();
				    //Check the cell type and format accordingly
			    	switch (cell.getCellType()){
				        case NUMERIC : 
				            System.out.print(cell.getNumericCellValue() + "\t");
				            break;
				        case STRING:
				            System.out.print(cell.getStringCellValue() + "\t");
				            break;
				            
				        case BOOLEAN:
				        	 System.out.print(cell.getBooleanCellValue() + "\t");
					            break;
			        }
			    }
			    System.out.println("\n");
		    }
		    int DCI=0;
		    for(int i = 1; i < sheet.getLastRowNum() + 1; i++ ) {
		    	Cell is_Long_method = sheet.getRow(i).getCell(8);
			    Cell PMD = sheet.getRow(i).getCell(9);
			    if (is_Long_method.getBooleanCellValue()== PMD.getBooleanCellValue() && is_Long_method.getBooleanCellValue()== true) {
			    	DCI++;
			    }
			    System.out.println(DCI);
		    }
		    System.out.println("DCI = " + DCI);
		    Cell is_Long_method = sheet.getRow(1).getCell(8);
		    Cell PMD = sheet.getRow(1).getCell(9);
		    Boolean s = is_Long_method.getBooleanCellValue();
		    Boolean ss = PMD.getBooleanCellValue();
		    System.out.println(s);
		    System.out.println(ss);
	
		    file.close();
		}
	    catch (Exception e)
	    {
	    e.printStackTrace();
	    } 
    }
    
}
