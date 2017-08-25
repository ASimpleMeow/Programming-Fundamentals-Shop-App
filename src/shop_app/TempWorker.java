package shop_app;

/**
 * TempWorker is a sub-class of an Employee Superclass and will contain all TempWorker exclusive 
 * data that is not common to all Employee types.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class TempWorker extends Employee 
{
	/**
	 * This is the constructor for the TempWorker class.
	 * 
	 * @param firstName
	 * @param secondName
	 * @param hourlyRate
	 */
	public TempWorker(String firstName,String secondName,double hourlyRate)
	{
		super(firstName,secondName,hourlyRate);//First line will be a call to the Superclass
	}
	
	/**
	 * Empty constructor for the TempWorker class to fix the XML bug.
	 */
	public TempWorker(){}
	
	/**
	 * This method will calculate and return the TempWorker's salary.
	 * 
	 * @return temporary worker's salary
	 */
	public double calculateSalary(double numHours)
	{
		if (numHours<0)
			numHours = 0;
		return super.calculateSalary(numHours);
	}
	
	/**
	 * This method will return String data.
	 * 
	 * @return String
	 */
	public String toString()
	{
		return 	"TEMP WORKER: \n"+
				super.toString();
	}
}
