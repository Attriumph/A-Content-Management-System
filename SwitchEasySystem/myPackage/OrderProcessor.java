package myPackage;



import java.util.Vector;

import java.io.BufferedReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;



public class OrderProcessor implements RowProcessor
{	
	//Row columns
	private static final short COLUMN_ID = 1;
	private static final short COLUMN_PRIORITY = 2;
	private static final short COLUMN_QUANTITY = 3;
	private static final short COLUMN_SUPPLIER = 4;
	private static final short COLUMN_LINK = 5;
	//private static final short COLUMN_ELSE = 4;
	
	private static OrderProcessor thisProcessor;
	
	
	private OrderProcessor()
	{
		//Private so no outside instantiation
	}
	
	
	public static RowProcessor getInstance()
	{
		if(thisProcessor == null)
		{
			thisProcessor = new OrderProcessor();
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
			   
			   Order item = null; //Change this line to your own DataObject
			 
			   first += 2; //Ignore first 2 rows - they are headers
			   
			   for(int i= first; i<=last; i++)
			   {
				   row = sheet.getRow(i);
				   if(row != null && row.getCell((short) COLUMN_ID) != null)
				   {
					   item = new Order();
					   //There only three attributes for Component object. If you have more you should
					   //have more lines below.
					   item.setID(row.getCell(COLUMN_ID).toString()); //For String value
					   item.setPriority(row.getCell(COLUMN_PRIORITY).toString());
					   item.setQuantity(row.getCell(COLUMN_QUANTITY).toString());
					   item.setSupplier(row.getCell(COLUMN_SUPPLIER).toString());
					   item.setLink(row.getCell(COLUMN_LINK).toString());
					   itemContainer.add(item); //Add newly created item into the container.
				   }
			   }
			   
			   return itemContainer; // Return the container
		}
		
		return null;
	}
}
