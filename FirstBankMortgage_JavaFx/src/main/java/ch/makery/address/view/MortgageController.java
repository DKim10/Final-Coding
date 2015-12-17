package ch.makery.address.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController implements Initializable {

	@FXML
	private Label income;
	@FXML
	private Label Expenses;
	@FXML
	private Label CreditScore;
	@FXML 
	private Label HouseCost;
	@FXML
	private Label Term;
	@FXML
	private Label MortgagePayment;
	@FXML
	private Label MortgagePaymentDisplay;
	@FXML
	private TextField incomeStr;
	@FXML
	private TextField ExpensesStr;
	@FXML
	private TextField CreditScoreStr;
	@FXML
	private TextField HouseCostStr;
	@FXML
	private ComboBox<String> TermStr;
				
	private boolean isClicked = false;
	
		@FXML
		public void handleClicked(){
			//Handles when option is picked in combo box
			isClicked = true;
			this.ShowNewValue();
		}
	
		//Setter for income
		public void setIncomeStr(TextField IncomeStr){
			this.incomeStr = IncomeStr;
		}
		
		//Setter for expenses
		public void setExpensesStr(TextField expensesStr){
			this.ExpensesStr = expensesStr;
		}
		
		//setter for CreditScore
		public void setCreditScoreStr(TextField creditScoreStr){
			this.CreditScoreStr = creditScoreStr;
		}
		
		//Setter for HouseCost
		public void setHouseCostStr(TextField houseCostStr){
			this.HouseCostStr = houseCostStr;
		}
		
		//Setter for Term
		public void setTermStr(ComboBox<String> termStr){
			this.TermStr = termStr;
		}
		
		//Setter for mortgagePayment Display
		public void setMortgagePaymentDisplay(Label mortgagePaymentDisplay){
			this.MortgagePaymentDisplay = mortgagePaymentDisplay;
		}
		
		//getter that converts from string to Int for income
		public Double getConvertedIncomeStr(){
			return new Double(incomeStr.getText());
		}
		
		//getter that converts from string to Int for Expenses
		public Integer getConvertedExpensesStr(){
			return new Integer(ExpensesStr.getText());
		}
		
		//getter that converts from string to Int for CreditScore
		public Integer getConvertedCreditScoreStr(){
			return new Integer(CreditScoreStr.getText());
		}
		
		//getter that converts from string to Int for HouseCost
		public Double getConvertedHouseCostStr(){
			return new Double(HouseCostStr.getText());
		}
		
		//getter that converts from string to Int for Term
		//Also takes the years and converts it to number of payments based upon user selection
		public Integer getConvertedTermStr(){
			if(this.TermStr.getValue() == "15 years"){
				return 15*12;
			}
			else{
				return 30*12;
			}
		}
		
		
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    
    @FXML
    private void initialize() {
    	
    	}

   
    	
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    public void ShowNewValue() {
    	/** This function displays the mortgage calculation
    	 * Parameters: None
    	 * Variables: None
    	 */
    	
    	//Checks if all text fields are filled then calculates mortgage
    	if(isClicked != false & incomeStr.getText().isEmpty() != true & ExpensesStr.getText().isEmpty() != true &
    			CreditScoreStr.getText().isEmpty() != true & HouseCostStr.getText().isEmpty() != true){
    		
    		//Calculates Mortgage
    		Double displayOutput = Rate.getPayment(this.getConvertedTermStr(),this.getConvertedHouseCostStr(), this.getConvertedCreditScoreStr());
    		
    		//Checks if user can afford monthly mortgage
    		//if not displays House Cost too high
    		if((displayOutput <= (this.getConvertedIncomeStr() * .36 )) & 
    				(displayOutput <= ((this.getConvertedIncomeStr()+this.getConvertedExpensesStr()) * .28))){
    			
    			this.MortgagePaymentDisplay.setText("$" + String.format("%.2f", displayOutput));
    		}
    		
    		else{
    			this.MortgagePaymentDisplay.setText("House Cost too high");
    		}
    	}
    	
    	else{
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/** This function forces program to create ComboBox with options
		 * Also forces implementation bug fix for javaFx
		 * Variables: None
		 * Parameters: Location - unused, resources - unused
		 * Parameters are used to Override the function since initialize already exists
		 */
		
		//adds options to comboBox
    	this.TermStr.getItems().add("15 years");
    	this.TermStr.getItems().add("30 years");
    	
    	//fixes javafx bug where program freezes if you have windows10 and touchscreen
    	TermStr.setOnMousePressed(new EventHandler<MouseEvent>(){
    		@FXML
    	    public void handle(MouseEvent event) {
    	        TermStr.requestFocus();
    	    }
    	});
	}
	
}