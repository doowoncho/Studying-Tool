package application;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class thread extends Thread{
	
	
	@FXML
	private Button quit;
	
	@FXML
	private Button btwn;
	
	@FXML
	private Button g;
	
	public float x = 0;
    static boolean exit = false;
    static boolean pause = false;
    
    ScaleTransition scale = new ScaleTransition();
	
    
	@FXML
	public void grows(ActionEvent event) throws Exception
	{

		
	}
    


    
    @FXML
	public void end(ActionEvent event) throws Exception
	{			
			cont();							
	}
	
	@FXML
	public void exit(ActionEvent event) throws Exception
	{
		exit();
		showTime();	
		Parent root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void cont()
	{
		
		if(pause == true)
		{
			btwn.setText("pause");
			pause = false;	
			go();
			
				
		}
		else
		{
			btwn.setText("continue");
			pause = true;
			pause();
						
		
		}
	}

	public void run()
	{
	
		while(exit == false)
		{	
				
			time();	
		}
		

		
	}
	public void pause()
	{

		pause = true;
		
	}
	
	public void go()
	{
		pause = false;

	}
	
	public void time()
	{

		try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pause == false) 
		{			
			x++;
			System.out.println(x);
			
		}		
		else 
		{ 
			System.out.println(x);
		}

	}

	
	public void exit()
	{
		System.out.println("Done Studying");
		exit = true;

	}
	
	
	public void showTime()
	{
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		System.out.println(timeFormat.format(currentDate));
	}
}

