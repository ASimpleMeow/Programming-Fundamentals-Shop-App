package shop_app;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * HandleXML class will handle the writing and reading to and from an XML file and 
 * will be used to save and load employees List.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */

public class HandleXML {
	
	/**
	 * This method will create and write to an XML file the employees List data.
	 * 
	 * @param employees
	 * @param filename
	 * @throws Exception
	 */
	public static void write(List<Employee> employees, String filename) throws Exception
	{
		XMLEncoder encoder = 
				new XMLEncoder(
						new BufferedOutputStream(
								new FileOutputStream(filename)));
		encoder.writeObject(employees);
		encoder.close();
	}
	
	/**
	 * This method will read from an existing XML file the employees List data.
	 * 
	 * @param filename
	 * @return loaded employees List from the XML
	 * @throws Exception
	 */
	public static List<Employee> read(String filename) throws Exception 
	{
		XMLDecoder decoder = 
				new XMLDecoder(new BufferedInputStream(
						new FileInputStream(filename)));
		List<Employee> employees = (ArrayList<Employee>) decoder.readObject();
		decoder.close();
		return employees;
	}
}
