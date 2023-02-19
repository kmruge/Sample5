package allAboutPractice;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String args[]) throws IOException
	{
		String file="C:\\Users\\kmruge\\Desktop\\SMaC Assessment\\Myra Configuration Training\\CC-UI Configuration.xlsx";
		XSSFWorkbook ji=new XSSFWorkbook(file);
		XSSFSheet sheet=ji.getSheet("Jan 19");
		int row=sheet.getLastRowNum();
		int cell=sheet.getRow(0).getLastCellNum();
		System.out.println(row+cell);
		for(int i=1;i<=row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				XSSFRow rowValue=sheet.getRow(i);
				XSSFCell cellValue=rowValue.getCell(j);
				DataFormatter data=new DataFormatter();
				String value=data.formatCellValue(cellValue);
				System.out.println(value);
			}
		}
		
	}

}
