/**
 * 
 */
package com.mystore.dataprovider;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.mystore.utility.ReadExcelFile;

/**
 * @author winma
 *
 */
public class DataProvider1 {

	ReadExcelFile obj =new ReadExcelFile();
	
	
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		//total row counts
		int rows=obj.getRowCount("Credentials");
		
		//total column counts
		int column=obj.getColumnCount("Credentials");
		
		int actRows=rows-1;
		
		Object[][] data = new Object[actRows][column];
		
		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}
	
	
	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("SearchProduct");
			// Total Columns
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}
		
		
		@DataProvider(name = "email")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("Email");
			// Total Columns
			int column = obj.getColumnCount("Email");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Email", j, i + 2);
				}
			}
			return data;
		}
		
		
		//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		@DataProvider(name = "getProduct")
		public Object[][] getProduct() {
			// Totals rows count
			int rows = obj.getRowCount("ProductDetails");
			// Total Columns
			int column = obj.getColumnCount("ProductDetails");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
				}
			}
			return data;
		}
	
	
}
