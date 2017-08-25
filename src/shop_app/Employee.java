package shop_app;

/**
 * Employee class is a Superclass for the sub-classes of Manager, TempWorker and 
 * SalesWorker.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public abstract class Employee 
{
	private String firstName; 
	private String secondName;
	private double hourlyRate;
	final static double NORMAL_WORKWEEK = 37.5;
	
	/**
	 * Constuctor for the Employee Superclass
	 * 
	 * @param firstName
	 * @param secondName
	 * @param hourlyRate
	 */
	public Employee(String firstName,String secondName, double hourlyRate)
	{
		setFirstName(firstName);
		setSecondName(secondName);
		setHourlyRate(hourlyRate);
	}
	
	/**
	 * Empty constructor for the Employee Superclass to fix the XML bug.
	 */
	public Employee(){}

	////ACCESSORS////
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	/////////////////
	////MUTATORS////
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate >= 0)
			this.hourlyRate = hourlyRate;
	}
	///////////////
	
	/**
	 * This method will calculate the salary for the employee
	 * 
	 * @param numHours
	 * @return double for the salary
	 */
	public double calculateSalary(double numHours)
	{
		if (numHours > NORMAL_WORKWEEK)
			return (hourlyRate*NORMAL_WORKWEEK)+calculateOvertime(numHours);
		else
			return (hourlyRate*numHours);
	}
	
	/**
	 * This method will calculate the salary bonus for overtime. 
	 * 
	 * @param numHours
	 * @return overtime salary bonus
	 */
	private double calculateOvertime (double numHours)
	 {
		//"for EACH HOUR worked overtime during the week, the hourly rate is doubled"
		 double hourDifference = (numHours - NORMAL_WORKWEEK);
		 return ((hourlyRate*2)*hourDifference);
	 }
	
	/**
	 * This method will return String data.
	 * 
	 * @return String
	 */
	public String toString()
	{
		return "First Name: "+firstName+"\n"+
			   "Second Name: "+secondName+"\n"+
			   "Hourly Rate: "+hourlyRate+"\n";
	}
}
