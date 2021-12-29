package application;

import java.awt.Event;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller extends thread{

	
	
		@FXML
		
		private TextField text;
	
		@FXML
		private Button button;
		
		@FXML
		Button btwn;
		
		private Scene scene;
		private Parent root;
		private Stage stage;
		

		int x = 0;		
		
		thread t = new thread();
		
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
		
			t.start();
					
		}
		
		@FXML
		public void end(ActionEvent event) throws Exception
		{
		
			t.setboolean();
			System.out.println("stop");
			
			Date currentDate = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
			System.out.println(timeFormat.format(currentDate));
			
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
					
		}
		
		
} 
