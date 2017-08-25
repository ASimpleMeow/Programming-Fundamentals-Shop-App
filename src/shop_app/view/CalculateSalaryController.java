package shop_app.view;

import shop_app.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * CalculateSalaryController will handle all user input from the CalculateSalaryView window.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class CalculateSalaryController {
	
	@FXML
	private ComboBox<Employee> employeeBox;//ComboBox for specific-employee salary calculation
	@FXML
	private Button calculateSpecificSalaryButton;//Specific Salary Calculation Button
	@FXML
	private Button calculateTotalSalaryButton; //Total Salary Calulcation Button
	@FXML
	private Button okButton; //The OK Button
	@FXML
	private TextField specificSalaryField; //Specific Salary Text Field
	@FXML
	private TextField totalSalaryField;//Total Salary Text Field
	@FXML
	private TextField specificHoursField;//Specific Work Hours Text Field
	@FXML
	private TextField managerHoursField;//Manager's Work Hours Text Field
	@FXML
	private TextField salesHoursField;//Sales Worker's Work Hours Text Field
	@FXML
	private TextField tempHoursField;//Temp Worker's Work Hours Text Field
	
	private Driver driver;
	
	/**
     * Initialises the controller class. This method is automatically called
     * after the fxml file has been loaded. Here it will fill up the Combo Box's with
     * employees.
     */
    @FXML
    private void initialize() {
    	
    	driver = new Driver();
    	employeeBox.setVisibleRowCount(3);//Sets the visible employees in the Combo Box
    	//Checking to make sure there are employees to add
    	if (!Driver.employeesEmpty())
    	{
    		//Adding all the employees to the Combo Box
    		for (int i=0; i<Driver.getEmployees().size(); i++)
    			employeeBox.getItems().add(Driver.getEmployees().get(i));
    	}
    }
    
    /**
     * This method will provide result for the calculation of salary for a specific Employee from the 
     * Combo Box.
     */
    @FXML
    private void handleSpecificSalary()
    {
    	//Checking the Combo Box and the Specific Work Hours Text Field are filled in
    	if ((employeeBox.getValue() != null) && specificHoursField.getText() != null)
    	{
    		//Taking the value from the text field and calculating the Employees salary
    		try{
    			double specificSalary = 
    					employeeBox.getValue().calculateSalary(Double.parseDouble(specificHoursField.getText()));
    			specificSalaryField.setText(Double.toString(specificSalary));
    		}catch (Exception e){
    			driver.showErrorMessage("Invalid Input","Please Enter A Valid Double Into Hours Worked","");
    		}
    	}
    	else
    		driver.showErrorMessage("Invalid Input", "Please Select An Employee/Fill In The Work Hours Field", "");
    }
    
    /**
     * This method will provide result for the calculation for all the employees.
     */
    @FXML
    private void handleTotalSalary()
    {
    	//Making sure there are employees to begin with
    	if (!Driver.employeesEmpty())
    	{
    		double totalSalary = 0;
    		double managerHours = 0;
    		double salesHours = 0;
    		double tempHours = 0;
    		
    		//Taking in the values from the Text Fields
    		try{
    			managerHours = Double.parseDouble(managerHoursField.getText());
        		salesHours = Double.parseDouble(salesHoursField.getText());
        		tempHours = Double.parseDouble(tempHoursField.getText());
        		
        		//Getting all the salary from each Employee and adding it all together
        		for (int i=0;i<Driver.getEmployees().size();i++)
        		{
        			try{
        				Manager manager = (Manager)Driver.getEmployees().get(i);
        				totalSalary += manager.calculateSalary(managerHours);
        			}catch(Exception e){}
        			try{
        				SalesWorker salesWorker = (SalesWorker)Driver.getEmployees().get(i);
        				totalSalary += salesWorker.calculateSalary(salesHours);
        			}catch(Exception e){}
        			try{
        				TempWorker tempWorker = (TempWorker)Driver.getEmployees().get(i);
        				totalSalary += tempWorker.calculateSalary(tempHours);
        			}catch(Exception e){}
        		}
        		
        		totalSalaryField.setText(Double.toString(totalSalary)); //Showing the result
        		
    		}catch (Exception e){
    			driver.showErrorMessage("Invalid Input","Please Input Proper Numeric Values Into Each Field",""
    					+ "If there are no specific employee type, please put in a zero.");
    		}
    	}
    	else
    		driver.showErrorMessage("Error","There Are No Existing Employees","");
    }
    
    /**
     * Called when the user clicks the OK Button
     */
    @FXML
    private void handleOk()
    {
    	Stage stage = (Stage) okButton.getScene().getWindow(); //Gets this window
        stage.close(); //Closes this window
    }
}
