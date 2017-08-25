package shop_app.view;

import shop_app.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

/**
 * AddEmployeeController class will handle all user input for the AddEmployeeView window.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class AddEmployeeController {
	
	@FXML
	private ToggleGroup group = new ToggleGroup(); //A Group to group all the Radio Buttons
	@FXML
	private Button okButton; //The OK Button
	@FXML
	private Button cancelButton; //The Cancel Button
	@FXML
	private TextField firstNameField; //First Name Text Field
	@FXML
	private TextField secondNameField; //Second Name Text Field
	@FXML
	private TextField hourlyRateField; //Hourly Rate Text Field
	@FXML
	private TextField managerBonusField; //Manager Bonus Text Field
	@FXML
	private TextField salesBonusField; //Sales Worker Bonus Text Field
	@FXML
	private RadioButton managerRadioBtn; //Radio Button for Manager
	@FXML
	private RadioButton salesRadioBtn; //Radio Button for Sales Worker
	@FXML
	private RadioButton tempRadioBtn; //Radio Button for Temporary Worker
	
	private String firstName;
	private String secondName;
	private double hourlyRate;
	private double managerBonus;
	private double salesBonus;
	private Driver driver;
    
    /**
     * Initialises the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	//Setting the Radio Buttons to be grouped in the Group
    	managerRadioBtn.setToggleGroup(group);
    	managerRadioBtn.setSelected(true);
    	salesRadioBtn.setToggleGroup(group);
    	tempRadioBtn.setToggleGroup(group);
    	
    	driver = new Driver(); //Driver constructor
    }
    
    /**
     * This method will check if the data is valid and will assign it to variables.
     * 
     * @return boolean if the data is valid
     */
    private boolean setInputData()
    {
    	//Checking basic data that is common to all Employees
    	if ((firstNameField.getText().length()==0) || (secondNameField.getText().length()==0) 
    			|| hourlyRateField.getText().length()==0)
    	{
    		driver.showErrorMessage("Input Error","Required Input Fields Not Filled In!","Fill in "
    				+ "First Name Field / Second Name Field / Hourly Rate");
    		return false;
    	}
    	else
    	{
    		firstName = firstNameField.getText();
    		secondName = secondNameField.getText();
        	try{hourlyRate = Double.parseDouble(hourlyRateField.getText());}
        	catch (Exception e){
        		driver.showErrorMessage("Invalid Input", "Wrong Data Type", "Please Enter Correct "
        				+ " Data Type Into The Hourly Rate Field!");
        		return false;
        		}
    	}
    		
    	//Checking the data specific for the Manager class
    	if (managerRadioBtn.isSelected() && managerBonusField.getText().length() == 0)
    	{
    		driver.showErrorMessage("Input Error","Required Input Fields Not Filled In!"," Fill in "
    				+ "Manager Bonus Field!");
    		return false;
    	}
    	else if (managerRadioBtn.isSelected() && managerBonusField.getText().length() != 0)
    	{
    		try{managerBonus = Double.parseDouble(managerBonusField.getText());}
        	catch (Exception e){
        		driver.showErrorMessage("Invalid Input", "Wrong Data Type", "Please Enter Correct "
        				+ " Data Type Into The Manager Bonus Field!");
        		return false;
        		}
    	}
    	
    	//Checking data specific to the SalesWorker class
    	if (salesRadioBtn.isSelected() && salesBonusField.getText().length()==0)
    	{
    		driver.showErrorMessage("Input Error","Required Input Fields Not Filled In!","Fill In "
    				+ "Sales Worker Bonus Field!");
    		return false;
    	}
    	if (salesRadioBtn.isSelected() && salesBonusField.getText().length()!=0)
    	{
    		try{salesBonus = Double.parseDouble(salesBonusField.getText());}
        	catch (Exception e){
        		driver.showErrorMessage("Invalid Input", "Wrong Data Type", "Please Enter Correct "
        				+ " Data Type Into The Sales Worker Bonus Field!");
        		return false;
        		}
    	}
    	return true; //If all data is valid and assigned, return true
    }
    
	/**
     * Called when the user clicks Cancel Button.
     */
    @FXML
    private void handleCancel() {
    	Stage stage = (Stage) cancelButton.getScene().getWindow(); //Gets the current window
        stage.close(); //closes the window
    }
    
    /**
     * Called when the user clicks the OK Button.
     */
    @FXML
    private void handleOk()
    {
    	//Making sure the data is valid and present
    	if (setInputData())
    	{
    		//Checking which Radio Button was selected
    		if (managerRadioBtn.isSelected())
    			Driver.addEmployee(new Manager(firstName,secondName,hourlyRate, managerBonus));
    		else if (salesRadioBtn.isSelected())
    			Driver.addEmployee(new SalesWorker(firstName,secondName,hourlyRate,salesBonus));
    		else
    			Driver.addEmployee(new TempWorker(firstName,secondName,hourlyRate));
    		driver.showConfirmationMessage("Sucess!","New Employee Added!","");
    		handleCancel();
    	}
    }
	
}
