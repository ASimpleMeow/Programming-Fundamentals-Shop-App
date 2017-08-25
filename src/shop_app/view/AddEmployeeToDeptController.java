package shop_app.view;

import shop_app.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * AddEmployeeToDeptController will handle all user inputs to the AddEmployeeToDeptView window.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class AddEmployeeToDeptController {
	
	@FXML
	private ComboBox<Employee> employeeBox; //The Combo Box for all Employees except Managers
	@FXML
	private ComboBox<Manager> managerBox; //The Combo Box exclusively for Managers
	@FXML
	private Button okButton; //The OK Button
	@FXML
	private Button cancelButton; //The Cancel Button
	
	private Driver driver;
	
	/**
     * Initialises the controller class. This method is automatically called
     * after the fxml file has been loaded. Here it will fill up the Combo Box's with
     * employees.
     */
    @FXML
    private void initialize() {
    	
    	driver = new Driver();
    	managerBox.setVisibleRowCount(2);//Set the view limit in the Combo Box for Manager's Combo Box
    	employeeBox.setVisibleRowCount(3); //Set the view limit in the Combo Box for Employee's Combo Box
    	
    	//Making sure that there are employees to add to the Combo Box
    	if (!Driver.employeesEmpty())
    	{
    		//Separating Employee Types and adding them to their respective Combo Box
    		for (int i=0; i<Driver.getEmployees().size(); i++)
    		{
    			try{
    				managerBox.getItems().add((Manager)Driver.getEmployees().get(i));
    			}catch(Exception e)
    			{
    				employeeBox.getItems().add(Driver.getEmployees().get(i));
    			}
    		}
    	}
    }
    
    /**
     * Called when the user clicks the OK Button
     */
    @FXML
    private void handeOk()
    {
    	//Making sure that the Combo Box's aren't empty
    	if ((managerBox.getValue() != null) && (employeeBox.getValue() != null))
    	{
    		//Checking if the employee is already in the Manager's Dept.
    		if (!checkEmployeeInDept())
    		{
    			managerBox.getValue().addDeptEmployee(employeeBox.getValue());
        		driver.showConfirmationMessage("Success", "Employee Sucessfully Added To Manager's Dept.", "");
    		}
    		else
    			driver.showErrorMessage("Error","This Employee Is Already In This Manager's Dept.","");
    	}
    	else
    		driver.showErrorMessage("Invalid Input!","Please Fill In All Inputs!","");
    }
    
    /**
     * Called when the user clicks the Cancel Button
     */
    @FXML
    private void handleCancel()
    {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    /**
     * This method will perform a check to see if the selected Employee is already in the
     * selected Manager's Department.
     * 
     * @return boolean 
     */
    private boolean checkEmployeeInDept()
    {
    	//Checking if managers dept isn't empty
    	if (managerBox.getValue().getDept().size() != 0)
    	{
    		//Going through all Employees in Manager's Dept and comparing them to the selected Employee
    		for (int i=0; i<managerBox.getValue().getDept().size(); i++)
    		{
    			if (managerBox.getValue().getDept().get(i).equals(employeeBox.getValue()))
    				return true;
    		}
    		return false;
    	}
    	else
    		return false;
    }
}
