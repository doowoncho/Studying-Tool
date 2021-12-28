package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

	
	
		@FXML
		private TextField text;
	
		@FXML
		private Button button;
		
		
		@FXML
		void pressed(ActionEvent event)
		{
			System.out.println("pressed!");
		}
		
} 
