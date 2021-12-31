package application;

import java.awt.Event;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller extends thread{

	
		@FXML
		private ImageView img;
	
		@FXML
		
		private TextField text;
	
		@FXML
		private Button button;
		
		@FXML
		private Button btwn;
		
		private Scene scene;
		private Parent root;
		private Stage stage;
		
		public boolean started = false;
		public boolean pause = false;
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
			
			animate();

			if(started == false)
			{
				t.pause();
				started = true;
			}
	
				
				cont();

			
			
			
			/*
			 * Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); stage =
			 * (Stage)((Node)event.getSource()).getScene().getWindow(); scene = new
			 * Scene(root); stage.setScene(scene); stage.show();
			 */
					
		}
		
		public void cont()
		{
			if(pause == true)
			{
				btwn.setText("pause");
				pause = false;
				
				t.go();
				
				
				
		
			
			}
			else
			{
				btwn.setText("continue");
				pause = true;
				t.pause();
			
				
				
			
			}
		}
		
		public void showTime()
		{
			Date currentDate = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
			System.out.println(timeFormat.format(currentDate));
		}
		
		
		public void animate()
		{
			ScaleTransition scale = new ScaleTransition();
			scale.setNode(img);
			
			scale.setDuration(javafx.util.Duration.millis(1000));
			scale.setCycleCount(-1);
			scale.setByX(0.05);
			scale.setAutoReverse(true);
			scale.play();
		}
		
		
} 
