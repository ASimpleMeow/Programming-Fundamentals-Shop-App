package shop_app.view;

import shop_app.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * PrintEmployeesController will handle all user input from the PrintEmployeesView window.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class PrintEmployeesController {
	
	@FXML
	private Button okButton; //The OK Button
	@FXML
	private TextArea employeesArea; //The Text Field where all employees will be printed
	
	/**
	 * Initialises the controller class. This method is automatically called
     * after the fxml file has been loaded. Here it will fill the Text Field with all the 
     * employees.
	 */
	@FXML
	private void initialize()
	{
		String employeeList = "";//Prepare an empty String
		
		//Making sure there are employees to begin with
		if (!Driver.employeesEmpty())
		{
			//Getting all employees to fill the employeeList String
			for (int i=0; i<Driver.getEmployees().size();i++)
			{
				employeeList += Driver.getEmployees().get(i)+"\n\n";
			}
			
			employeesArea.setText(employeeList); //Prints employeeList to the Text Field
		}
		else
			employeesArea.setText("There are no employees added, please add employees."); //Default 
	}
	
	/**
	 * Called when user clicks the OK Button
	 */
	@FXML 
	private void handleOk()
	{
		Stage stage = (Stage) okButton.getScene().getWindow();//Gets the current window
        stage.close();//Closes the current window
	}
}
