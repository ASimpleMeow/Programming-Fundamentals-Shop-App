package shop_app;

/**
 * SalesWorker is a sub-class of an Employee Superclass and will contain all SalesWorker exclusive 
 * data that is not common to all Employee types.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class SalesWorker extends Employee 
{
	private double bonus; //Exclusive SalesWorker bonus
	
	/**
	 * This is the SalesWorker constructor
	 * 
	 * @param firstName
	 * @param secondName
	 * @param hourlyRate
	 * @param bonus
	 */
	public SalesWorker(String firstName,String secondName, double hourlyRate, double bonus)
	{
		super(firstName,secondName,hourlyRate); //First line will call to the Superclass
		setBonus(bonus);
	}
	
	/**
	 * Empty constructor for the SalesWorker class to fix the XML bug.
	 */
	public SalesWorker(){}
	
	////ACCESSORS////
	public double getBonus() {
		return bonus;
	}
	/////////////////
	////MUTATORS/////
	public void setBonus(double bonus) {
		if (bonus >=0.0 && bonus <= 0.2)
			this.bonus = bonus;
		else 
			this.bonus = 0;
	}
	/////////////////
	
	/**
	 * This method will calculate and return the SalesWorker's salary with it's bonus.
	 * 
	 * @return sales workers salary
	 */
	public double calculateSalary(double numHours)
	{
		if (numHours<0)
			numHours = 0;
		double calculatedBonus = super.calculateSalary(numHours)*bonus;
		return super.calculateSalary(numHours)+calculatedBonus;
	}
	
	/**
	 * This method will return String data.
	 * 
	 * @return String
	 */
	public String toString()
	{
		return 	"SALES WORKER: \n"+
				super.toString()+
				"Sales Worker Percentage Bonus (%): "+(bonus*100)+"\n";
	}
}
