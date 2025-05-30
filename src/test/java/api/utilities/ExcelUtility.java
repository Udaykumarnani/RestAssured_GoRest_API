package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	static String path;

	 public ExcelUtility(String path) {
		
		this.path=path;
		
	}
		public  int getRowCount(String xlsheet) throws IOException {
			
			 fi=new FileInputStream(path);
			 wb=new XSSFWorkbook(fi);
			 ws=wb.getSheet(xlsheet);
			 int rowcount=ws.getLastRowNum();
			 wb.close();
			 fi.close();
			 
			  return rowcount;
			
		}
		
		public  int getCellCount(String xlsheet,int rownum) throws IOException {
			
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			int cellCount=row.getLastCellNum();
			wb.close();
			fi.close();
			
			return cellCount;
			
		}
		
		public  String getCellData(String xlsheet,int rownum,int colnum) throws IOException {
			
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.getCell(colnum);
			
			String data;
			
			try {
			
			//data=cell.toString();
			DataFormatter formatter=new DataFormatter();
			data=formatter.formatCellValue(cell);
			
			}catch(Exception e){
				
				data="";
			}
			
			wb.close();
			fi.close();
			
			return data;
			
		}
		
		public  void setCellData(String xlfile,String xlsheet,int rownum,int colnum, String data) throws IOException {
			
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsheet);
			row=ws.getRow(rownum);
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		
			
			
		}
		
}
		
	


