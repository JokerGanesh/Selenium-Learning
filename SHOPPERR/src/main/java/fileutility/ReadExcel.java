package fileutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel 
{
     FileInputStream path;
     Workbook wb;
     public Object[][] readMultipleData(String sheetName)
     {
    	 Sheet sheet=wb.getSheet(sheetName);
    	 int rowCount=sheet.getPhysicalNumberOfRows();
    	 int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
    	 Object[][] data=new Object[rowCount][cellCount];
    	 for(int i=0;i<rowCount;i++)
    	 {
    		 for(int j=0;j<cellCount;j++)
    		 {
    			 data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
    		 }
    	 }
    	 return data;
     }
}
