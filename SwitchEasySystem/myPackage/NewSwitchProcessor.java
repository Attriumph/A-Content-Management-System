package myPackage;


import java.util.Vector;
import java.io.BufferedReader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


/**
 * @author Lingquan
 *
 */
public class NewSwitchProcessor implements RowProcessor
{	
	//Row columns
	private static final short COLUMN_INITIATOR = 0;
	private static final short COLUMN_ID =1;
	private static final short COLUMN_PART = 2;
	private static final short COLUMN_PRIORITY = 3;
	private static final short COLUMN_SUPPLIER = 4;
	private static final short COLUMN_REASON = 5;
	private static final short COLUMN_COMMENT = 6;
	
	//private static final short COLUMN_ELSE = 7;
	/**
     * The singleton instance of this class.
     */
	private static NewSwitchProcessor thisProcessor;
	
	/**
	 * Default constructor
	 * 
	 * @Author:Lingquan
	 */
	private NewSwitchProcessor()
	{
		//Private so no outside instantiation
	}
	
	/**
	 * Get an instance of this row processor.
	 * @Author Lingquan
	 * @return instance of this row processor.
	 */
	public static RowProcessor getInstance()
	{
		if(thisProcessor == null)
		{
			thisProcessor = new NewSwitchProcessor();
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
			   
			   Switch item = null; //Change this line to your own DataObject
			   
			   
			   
			   for(int i= first; i<=last; i++)
			   {
				   row = sheet.getRow(i);
				   if(row != null && row.getCell(COLUMN_INITIATOR) != null)
				   {
					   item = new Switch();
					   //There only three attributes for Component object. If you have more you should
					   //have more lines below.
					   item.setInitiator(row.getCell(COLUMN_INITIATOR).toString()); //For String value
					   item.setID(row.getCell(COLUMN_ID).toString());//For numerical value
					   item.setPart(row.getCell(COLUMN_PART).toString()); //For String value
					   item.setPriority(row.getCell(COLUMN_PRIORITY).toString());
					   item.setSupplier(row.getCell(COLUMN_SUPPLIER).toString());
					   item.setReason(row.getCell(COLUMN_REASON).toString());
					   item.setComment(row.getCell(COLUMN_COMMENT).toString());
					 
					   itemContainer.add(item); //Add newly created item into the container.
					 
				   }
			   }
			   
			   return itemContainer; // Return the container
		}
		
		return null;
	}
}
