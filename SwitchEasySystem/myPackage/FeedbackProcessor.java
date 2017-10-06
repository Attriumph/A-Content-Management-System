package myPackage;



import java.util.Vector;

import java.io.BufferedReader;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;



public class FeedbackProcessor implements RowProcessor
{	
	//Row columns
	private static final short COLUMN_ID = 1;
	private static final short COLUMN_PART = 2;
	private static final short COLUMN_REVISION = 3;
	private static final short COLUMN_REASON = 4;
	private static final short COLUMN_SOLUTION = 5;
	//private static final short COLUMN_ELSE = 4;
	
	private static FeedbackProcessor thisProcessor;
	
	
	private FeedbackProcessor()
	{
		//Private so no outside instantiation
	}
	
	
	public static RowProcessor getInstance()
	{
		if(thisProcessor == null)
		{
			thisProcessor = new FeedbackProcessor();
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
			   System.out.println("first:"+first+"last:"+last);
			   HSSFRow row = null;
			   Vector itemContainer = new Vector ();
			   
			   Feedback item = null; //Change this line to your own DataObject
			 
			   first += 2; //Ignore first 2 rows - they are headers
			   
			   for(int i= first; i<=last; i++)
			   {
				   row = sheet.getRow(i);
				   if(row != null && row.getCell((short) COLUMN_ID) != null)
				   {
					   item = new Feedback();
					   //There only three attributes for Component object. If you have more you should
					   //have more lines below.
					   //System.out.println(row.getCell(COLUMN_ID).toString());
					   
					   item.setID(row.getCell(COLUMN_ID).toString()); //For String value
					   item.setPart(row.getCell(COLUMN_PART).toString());
					   item.setRevision(row.getCell(COLUMN_REVISION).toString());
					   item.setReason(row.getCell(COLUMN_REASON).toString());
					   item.setSolution(row.getCell(COLUMN_SOLUTION).toString());
					   itemContainer.add(item); //Add newly created item into the container.
					   
				   }
			   }
			   
			   System.out.println("Container:"+itemContainer.size());
			   return itemContainer; // Return the container
		}
		
		return null;
	}
}
