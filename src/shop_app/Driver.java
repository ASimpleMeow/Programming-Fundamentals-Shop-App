package shop_app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * The Driver class will handle opening of various windows and 
 * managing the employees List.
 * 
 * @author Oleksandr
 * @version 1.0
 *
 */
public class Driver extends Application {
	
	private Stage primaryStage; //The main window
	private static List<Employee> employees = new ArrayList<Employee>();
	
	/**
	 * This method is run at the very start and will set the main window. 
	 * 
	 * @param The primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Shop Application");
		this.primaryStage.setResizable(false); //Makes the window non-resizable
		
		showMainView();
	}
	
	/**
	 * This method will show the main view window
	 */
	public void showMainView()
	{
		try
		{
			//Load layout from fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Driver.class.getResource("view/MainView.fxml"));
			AnchorPane mainLayout = (AnchorPane) loader.load();
			
			// Show the scene containing the layout.
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will open a separate window to fill in details to add a new
	 * employee.
	 */
	public void addEmployeeWindow()
	{
		try{
			stageSetUp("Add An Employee","view/AddEmployeeView.fxml");
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will open a separate window to add an existing employee to
	 * a manager department.
	 */
	public void addEmployeeToDeptWindow()
	{
		try{
			stageSetUp("Add An Employee To A Manager Dept.","view/AddEmployeeToDeptView.fxml");
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will open a separate window to add an existing employee to
	 * a manager department.
	 */
	public void calculateSalaryWindow()
	{
		try{
			stageSetUp("Calculate Employee Salary","view/CalculateSalaryView.fxml");
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will open a separate window and show a list of employees.
	 */
	public void printEmployeesWindow()
	{
		try{
			stageSetUp("Print All Employees","view/PrintEmployeesView.fxml");
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
     * Returns the main stage.
     * @return the primary stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }	
	
    /**
     * The main method which will be the starting point of the program.
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Accessor for the employees List
	 * 
	 * @return employees List
	 */
	public static List<Employee> getEmployees()
	{
		return employees;
	}
	
	/**
	 * Mutator for the employees List.
	 * 
	 * @param employee
	 */
	public static void addEmployee(Employee employee)
	{
		employees.add(employee);
	}
	
	/**
	 * This method will see if the employees List is empty.
	 * 
	 * @return boolean
	 */
	public static boolean employeesEmpty()
	{
		if (employees.size() == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * This method will display an error message, when something is not right.
	 * 
	 * @param title
	 * @param header
	 * @param message
	 */
	public void showErrorMessage(String title,String header, String message)
	{
		 // Show the error message.
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
	}
	
	/**
	 * This method will display a confirmation message to tell the user that the 
	 * operation was successful.
	 * 
	 * @param title
	 * @param header
	 * @param message
	 */
	public void showConfirmationMessage(String title, String header, String message)
	{
		 // Show the confirmation message.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        alert.showAndWait();
	}
	
	/**
	 * This method will load employees List from an XML file.
	 * 
	 * @throws Exception
	 */
	public void load() throws Exception 
	{
		employees = HandleXML.read("employees.xml");
	}
	
	/**
	 * This method will save the employees List to an XML file.
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception
	{
		HandleXML.write(employees, "employees.xml");
	}
	
	/**
	 * This method is a template for each stage/window that I use outside
	 * of the main window.
	 * 
	 * @param title
	 * @param location
	 * @throws IOException
	 */
	private void stageSetUp(String title, String location) throws IOException
	{
		// Create the separate Stage.
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //Load layout from fxml file
		AnchorPane stageLayout = 
				(AnchorPane) FXMLLoader.load(Driver.class.getResource(location));
		stage.setResizable(false);
        Scene scene = new Scene(stageLayout);
        stage.setScene(scene);
        stage.show();
	}
}
