package shop_app.view;

import shop_app.Driver;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * MainViewController is responsible for taking inputs from the main window and responding accordingly.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class MainViewController {
	
	@FXML
	private Button addEmployeeButton;//The Add Employees Button
	@FXML
	private Button addEmployeeDeptButton; //The Add Employees To Manager's Dept Button
	@FXML
	private Button salaryButton; //The Calculate Salary Button
	@FXML
	private Button printEmployeeButton; //The Print All Employees Button
	@FXML
	private Button saveButton; //The Save Button
	@FXML
	private Button loadButton; //The Load Button
	@FXML
	private Button exitButton; //The Exit Button
	
	private Driver driver;
	
	
	/**
	 * The constructor for this class
	 */
	public MainViewController(){
		driver = new Driver();
	}
	
	/**
	 * Called when the user clicks on the Add Employee Button.
	 */
	@FXML
	private void handleAddEmployee()
	{
		driver.addEmployeeWindow();
	}
	
	/**
	 * Called when the user clicks on the Add Employee To Manager Dept Button.
	 */
	@FXML
	private void handleAddEmployeeDept()
	{
		driver.addEmployeeToDeptWindow();
	}
	
	/**
	 * Called when the user clicks on the Calculate Salary Button.
	 */
	@FXML
	private void handleSalary()
	{
		driver.calculateSalaryWindow();
	}
	
	/**
	 * Called when the user clicks on the Print Employee Button.
	 */
	@FXML
	private void handlePrintEmployee()
	{
		driver.printEmployeesWindow();
	}
	
	/**
	 * Called when the user clicks on the Save Button.
	 */
	@FXML
	private void handleSave()
	{
		try{
			driver.save();
			driver.showConfirmationMessage("Save Successful", "The Save File Was Created Successfully", "");
		} catch(Exception e)
		{
			driver.showErrorMessage("Save Error", "Could Not Save File", "Please Check Write Permissons");
		}
	}
	
	/**
	 * Called when the user clicks on the Load Button.
	 */
	@FXML
	private void handleLoad()
	{
		try{
			driver.load();
			driver.showConfirmationMessage("Load Successful", "All Data Sucessfully Loaded", "");
		}catch (Exception e)
		{
			driver.showErrorMessage("Load Failed", "Failed To Load The File", "Make Sure You Created"
					+ " A Save File Before Hand, Also Check Read Permissions");
		}
	}
	
	/**
	 * Called when the user clicks on the Exit Button.
	 */
	@FXML
	private void handleExit()
	{
		Platform.exit(); //Exits all windows (closes program)
	}
}
