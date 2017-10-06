package myPackage;


import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFSheet;

public interface RowProcessor
{
	public Vector process(HSSFSheet sheet) throws Exception;
}
