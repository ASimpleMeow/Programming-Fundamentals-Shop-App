package shop_app;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager is a sub-class of an Employee Superclass and will contain all Manager exclusive 
 * data that is not common to all Employee types.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class Manager extends Employee 
{
	private double bonus; //Exclusive manager bonus
	private List<Employee> depts; //Manager's Department
	
	/**
	 * This is the constructor for the Manager sub-class.
	 * 
	 * @param firstName
	 * @param secondName
	 * @param hourlyRate
	 * @param bonus
	 */
	public Manager(String firstName,String secondName, double hourlyRate, double bonus)
	{
		super(firstName,secondName,hourlyRate);//First line will be to call the Superclass
		depts = new ArrayList<Employee>();
		this.bonus = 0;
		setBonus(bonus);
	}
	
	/**
	 * Empty constructor for the Manager class to fix the XML bug.
	 */
	public Manager(){}
	
	////ACCESSORS////
	public double getBonus() {
		return bonus;
	}
	
	public List<Employee> getDept() {
		return depts;
	}
	////////////////
	////MUTATORS////
	public void setBonus(double bonus) {
		if (bonus >=0)
			this.bonus = bonus;
	}
	
	public void setDept(List<Employee> dept) {
		this.depts = dept;
	}
	////////////////
	
	/**
	 * This method will return the size of the List dept
	 * 
	 * @return integer for the size of dept List
	 */
	public int numberInDept()
	{
		return depts.size();
	}
	
	/**
	 * This method will add a new employee to the dept List.
	 * 
	 * @param employee
	 */
	public void addDeptEmployee(Employee employee)
	{
		depts.add(employee);
	}
	
	/**
	 * This method will calculate and return the Manager's salary with it's bonus.
	 * 
	 * @return the manager's salary
	 */
	public double calculateSalary(double numHours)
	{
		if (numHours<0)
			numHours = 0;
		return super.calculateSalary(numHours)+bonus;
	}
	
	/**
	 * This method will return String data.
	 * 
	 * @return String
	 */
	public String toString()
	{
		return 	"MANAGER: \n"+
				super.toString()+
				"Manager Bonus: "+bonus+"\n"+
				"No. People in Department: "+numberInDept()+"\n";
	}
}
