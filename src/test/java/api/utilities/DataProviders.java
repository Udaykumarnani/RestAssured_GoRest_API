package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="userData")
	
	public String[][] getAllData() throws IOException{
		
		String path=System.getProperty("user.dir")+"//testdata//EmailandPwd.xlsx";
		
		ExcelUtility utility=new ExcelUtility(path);
		
		int rowNum=utility.getRowCount("Sheet1");
		
		int colNum=utility.getCellCount("Sheet1", rowNum);
		
		String apiData[][]=new String[rowNum][colNum];
		
		for(int i=1;i<=rowNum;i++) {
			
			for(int j=0;j<colNum;j++) {
				
				apiData[i-1][j]=utility.getCellData("Sheet1", i, j);
			}
		}
		
		return apiData;
	}

	
	@DataProvider(name="getUsername")
	
	public String[] getPetID() throws IOException {
		
		String path=System.getProperty("user.dir")+"//testData//UsernamesData.xlsx";
		
		ExcelUtility utility=new ExcelUtility(path);
		
		int rowNum=utility.getRowCount("Sheet1");
		
		String apiData[]=new String[rowNum];
		
		for(int i=1;i<=rowNum;i++) {
			
			apiData[i-1] = utility.getCellData("Sheet1", i, 1);
		}
		
		return apiData;
		
	}
	
	@DataProvider(name="EmailandPwd")
	
	public  String[][] getUsernameandEmail() throws IOException {
		
		String path=System.getProperty("user.dir")+"//testData//EmailandPwd.xlsx";
		
		ExcelUtility utility=new ExcelUtility(path);
		
		int rowNum=utility.getRowCount("Sheet1");
		
		int colCount=utility.getCellCount("Sheet1", rowNum);
		
		String apiData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++) {
			
			for(int j=0;j<colCount;j++) {
				
				apiData[i-1][j]=utility.getCellData("Sheet1", i, j);
			}
		}
		
		return apiData;
		
	}
	
}
