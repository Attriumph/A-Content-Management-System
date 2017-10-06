package myPackage;



import java.util.Vector;

import java.io.BufferedReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;



public class AccountsProcessor implements RowProcessor
{	
	//Row columns
	private static final short COLUMN_NAME = 0;
	private static final short COLUMN_PASSCODE = 1;
	private static final short COLUMN_TYPE = 2;
	//private static final short COLUMN_ELSE = 4;
	
	private static AccountsProcessor thisProcessor;
	
	
	private AccountsProcessor()
	{
		//Private so no outside instantiation
	}
	
	
	public static RowProcessor getInstance()
	{
		if(thisProcessor == null)
		{
			thisProcessor = new AccountsProcessor();
		}
		return thisProcessor;
	}
	
	/**
	 * Do required processing for the Incomes.
	 */
	public Vector process(HSSFSheet sheet) throws Exception
	{
		if(sheet != null)
		{
			   int first = sheet.getFirstRowNum();
			   int last = sheet.getLastRowNum();
			   HSSFRow row = null;
			   Vector itemContainer = new Vector ();
			   
			   Accounts item = null; //Change this line to your own DataObject
			 
			   first += 2; //Ignore first 2 rows - they are headers
			   
			   for(int i= first; i<=last; i++)
			   {
				   row = sheet.getRow(i);
				   if(row != null && row.getCell((short) COLUMN_NAME) != null)
				   {
					   item = new Accounts();
					   //There only three attributes for Component object. If you have more you should
					   //have more lines below.
					   item.setName(row.getCell(COLUMN_NAME).getRichStringCellValue().getString()); //For String value
					   item.setPasscode((int) row.getCell(COLUMN_PASSCODE).getNumericCellValue());//For numerical value
					   item.setType(row.getCell(COLUMN_TYPE).getRichStringCellValue().getString());
					   itemContainer.add(item); //Add newly created item into the container.
				   }
			   }
			   
			   return itemContainer; // Return the container
		}
		
		return null;
	}
}
