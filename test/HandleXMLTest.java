import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import shop_app.*;

/**
 * Test for HandleXML class.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */

public class HandleXMLTest {
	
	private List<Employee> employees, employees2, testEmpty, testFull;
	private Employee employee1, employee2, employee3;
	
	/**
	 * This method will set everything up before each test.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		employees = new ArrayList<Employee>();
		employees2 = new ArrayList<Employee>();
		testEmpty = new ArrayList<Employee>();
		testFull = new ArrayList<Employee>();
		employee1 = new Manager("Henry","McCoffee",25,10);
		employee2 = new SalesWorker("Joe","Ruman",22,1);
		employee3 = new TempWorker("Poor","guy",2.5);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
	}

	/**
	 * This method will test the write and read methods
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSaveAndLoad() throws Exception {
		
		//TESTING AN EMPTY ARRAYLIST
		assertEquals(0,employees2.size());
		HandleXML.write(employees2,"test1.xml");
		testEmpty = HandleXML.read("test1.xml");
		assertEquals(testEmpty.size(),employees2.size());
		
		//TESTING A FULL ARRAYLIST
		assertEquals(3, employees.size());
		HandleXML.write(employees, "test2.xml");
		testFull = HandleXML.read("test2.xml");
		assertEquals(testFull.size(),employees.size());
		assertEquals(testFull.get(0).getFirstName(),employees.get(0).getFirstName());
		assertEquals(testFull.get(1).getFirstName(),employees.get(1).getFirstName());
		assertEquals(testFull.get(2).getFirstName(),employees.get(2).getFirstName());
	}

}
