package application;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Controller extends thread{
	
		@FXML
		private Circle img;
	
		@FXML
		private TextField text;
	
		@FXML
		private Button button;

		private Scene scene;
		private Parent root;
		private Stage stage;
		
		public boolean started = false;
		public boolean pause = false;
		double x = 0;		
		
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
		

	
				Timer timer = new Timer();

		        TimerTask task = new TimerTask() {
		            @Override
		            public void run() {
		            	System.out.println("1");
			
		        			scale.setNode(img);
		        			System.out.println(img);
		        			scale.setByX(0.1);
		        			scale.setByY(0.1);
		        			scale.play();
		                
		            }
		        };
		        timer.schedule(task, 1000, 1000);
			
									
		}
		
		
		

		
		public void showTime()
		{
			Date currentDate = new Date();
			SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
			System.out.println(timeFormat.format(currentDate));
			
			
		}
		
		
		
		
	
		
		
} 