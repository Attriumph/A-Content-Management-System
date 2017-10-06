package myPackage;


import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;


/**
 * @author Sandarenu
 *
 */
public class ComponentProcessor implements RowProcessor
{	
	//Row columns
	private static final short COLUMN_NAME = 1;
	private static final short COLUMN_WEIGHT = 2;
	private static final short COLUMN_BRAND = 3;
	//private static final short COLUMN_ELSE = 4;
	/**
     * The singleton instance of this class.
     */
	private static ComponentProcessor thisProcessor;
	
	/**
	 * Default constructor
	 * Created on: Nov 8, 2007
	 * @Author: Sandarenu
	 */
	private ComponentProcessor()
	{
		//Private so no outside instantiation
	}
	
	/**
	 * Get an instance of this row processor.
	 * Created on: Nov 8, 2007
	 * @Author Sandarenu
	 * @return instance of this row processor.
	 */
	public static RowProcessor getInstance()
	{
		if(thisProcessor == null)
		{
			thisProcessor = new ComponentProcessor();
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
			   
			   Component item = null; //Change this line to your own DataObject
			   
			   first += 2; //Ignore first 2 rows - they are headers
			   
			   for(int i= first; i<=last; i++)
			   {
				   row = sheet.getRow(i);
				   if(row != null && row.getCell(COLUMN_NAME) != null)
				   {
					   item = new Component();
					   //There only three attributes for Component object. If you have more you should
					   //have more lines below.
					   item.setName(row.getCell(COLUMN_NAME).getRichStringCellValue().getString()); //For String value
					   item.setWeight(row.getCell(COLUMN_WEIGHT).getNumericCellValue());//For numerical value
					   item.setBrand(row.getCell(COLUMN_BRAND).getRichStringCellValue().getString());
					   itemContainer.add(item); //Add newly created item into the container.
				   }
			   }
			   
			   return itemContainer; // Return the container
		}
		
		return null;
	}
}
