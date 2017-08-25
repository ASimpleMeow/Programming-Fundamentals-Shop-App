import static org.junit.Assert.*;
import shop_app.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the SalesWorker class
 */

/**
 * @author Oleksandr Kononov
 * @version 12/04/2016
 */

public class SalesWorkerTest {
	private SalesWorker sales1, sales2;
	private SalesWorker validSales1, validSales2, validSales3;
	
	/**
	 * setUp method will set up data before each test. 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		sales1 = new SalesWorker("Cheese","Burger",10,0.1);
		sales2 = new SalesWorker("Burger","King",45,0.2);
		validSales1 = new SalesWorker("Test","Robot",0,0);
		validSales2 = new SalesWorker("Fish","Pirate",-1,-1);
		validSales3 = new SalesWorker("Pirate","Swimmer",1,1);
	}
	
	/**
	 * This method will test the constructor of SalesWorker.
	 */
	@Test
	public void testConstructor() 
	{
		assertEquals("Cheese", sales1.getFirstName());
		assertEquals("Burger", sales1.getSecondName());
		assertEquals(10, sales1.getHourlyRate(),0.01);
		assertEquals(0.1,sales1.getBonus(),0.01);
	}
	
	/**
	 * This method tests the constructor with invalid data.
	 */
	@Test
	public void testInvalidSalesWorkers()
	{
		assertEquals(0,validSales1.getHourlyRate(),0.01);
		assertEquals(0,validSales1.getBonus(),0.01);
		assertEquals(0,validSales2.getHourlyRate(),0.01);
		assertEquals(0,validSales2.getBonus(),0.01);
		assertEquals(1,validSales3.getHourlyRate(),0.01);
		assertEquals(0,validSales3.getBonus(),0.01);
	}
	
	/**
	 * This method tests the accessor and mutator for the first name.
	 */
	@Test
	public void testGetSetFirstName()
	{
		assertEquals(sales2.getFirstName(), "Burger");
		sales2.setFirstName("McBurger");
		assertEquals(sales2.getFirstName(), "McBurger");
	}
	
	/**
	 * This method tests the accessor and mutator for the second name.
	 */
	@Test
	public void testGetSetSecondName()
	{
		assertEquals(sales2.getSecondName(), "King");
		sales2.setSecondName("Kingdom");
		assertEquals(sales2.getSecondName(), "Kingdom");
	}
	
	/**
	 * This method tests the accessor and mutator for the bonus.
	 */
	@Test
	public void testGetSetBonus() {
		assertEquals(0.1, sales1.getBonus(), 0.01);
        sales1.setBonus(-1);
		assertEquals(0, sales1.getBonus(), 0.01);
        sales1.setBonus(0);
        assertEquals(0, sales1.getBonus(), 0.01);
        sales1.setBonus(0.15);
        assertEquals(0.15, sales1.getBonus(), 0.01);
	}
	
	/**
	 * This method tests the accessor and mutator for the hourly rate.
	 */
	@Test
	public void testGetSetHourlyRate() {
		assertEquals(10, sales1.getHourlyRate(), 0.01);
        sales1.setHourlyRate(-1);
		assertEquals(10, sales1.getHourlyRate(), 0.01);
        sales1.setHourlyRate(0);
        assertEquals(0, sales1.getHourlyRate(), 0.01);
        sales1.setHourlyRate(20);
        assertEquals(20, sales1.getHourlyRate(), 0.01);
	}
	
	/**
	 * This method will test the calculateSalary method in Employee class.
	 */
	@Test
	public void testCalculateSalary() {
		assertEquals(407.0, sales1.calculateSalary(37), 0.01);
		assertEquals(412.5, sales1.calculateSalary(37.5), 0.01);
		assertEquals(423.5, sales1.calculateSalary(38), 0.01);
		assertEquals(435.98, sales1.calculateSalary(38.5674), 0.01);	
	}
}
