package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Shape;

public class Controller {

	@FXML
	Button b;
	
	@FXML
	Shape c;
	
    ScaleTransition scale = new ScaleTransition();
	
    double x = 0.1;
    
    int sec = 0;
    
	@FXML
	public void Start(ActionEvent event) throws Exception
	{
	
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		System.out.println(timeFormat.format(currentDate));
		
		System.out.println();
		Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            		
        			scale.setNode(c);
        			System.out.println(c);
        			scale.setByX(x);
        			scale.setByY(x);
        			scale.play();
        			
        			sec ++;
                
            }
        };
        timer.schedule(task, 1000, 1000);
	}
	
	
	@FXML
	public void End(ActionEvent event) throws Exception
	{
	
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		System.out.println(timeFormat.format(currentDate));
		
		
	}
}
