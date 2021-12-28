package application;

import java.awt.Event;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

	
	
		@FXML
		
		private TextField text;
	
		@FXML
		private Button button;
		
		@FXML
		Button btwn;
		
		private Scene scene;
		private Parent root;
		private Stage stage;
		
		public boolean start = false;
		boolean test;
		@FXML
		public void pressed(ActionEvent event) throws Exception
		{
			Date currentDate = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
			System.out.println(timeFormat.format(currentDate));
			
			Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
			start = true;
			timer();
	
					
		}
		
		@FXML
		public void end(ActionEvent event) throws Exception
		{
			start = false;
			Date currentDate = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
			System.out.println(timeFormat.format(currentDate));
			
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
			
		}
		
		
		public void timer() throws InterruptedException
		{
			int x = 0;
			
			
			while(start)
			{
				
				Thread.sleep(1000);
				System.out.println(x);
				x++;				
			}
			
			return;
		}
		
} 
