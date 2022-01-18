package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Controller {

	@FXML
	Button b;
	
	@FXML
	ImageView con;
	
	@FXML
	ImageView i;
	
	@FXML
	Button end;
	
	@FXML
	ImageView p;
	
	@FXML
	Button pButton;
	
	@FXML
	Button conB;
	
	
	@FXML
	Shape c;
	
    ScaleTransition scale = new ScaleTransition();
	
    double x = 0.5;
    
    float sec = 0;
    float realTime = 0;
    boolean pause;
    float holdTime = 0;
	@FXML
	public void Start(ActionEvent event) throws Exception
	{	
		p.setVisible(true);
		pButton.setDisable(false);
		
		i.setVisible(false);
		b.setDisable(true);

		
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		System.out.println(timeFormat.format(currentDate));
		
		
		Timer timer = new Timer();

		
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	
            	if(pause == false)
            	{
            		scale.setNode(c);           		
                	scale.setByX(0.1);
            		scale.setByY(0.1);
            		scale.play();
            		sec ++;
            		realTime ++;
            	}
            	
            	if(pause == true)
            	{
            		scale.setNode(c);           		
                	scale.setByX(0);
            		scale.setByY(0);
            		scale.play();
            		realTime ++;
            	}
            	
            	if(holdTime + 3 == realTime && realTime !=3)
        		{
        		
						End();
			
        		}

            	
            }
        };
        timer.schedule(task, 1000, 1000);
	}
	
	@FXML
	public void drag(MouseEvent event) throws Exception
	{
	
		i.setBlendMode(BlendMode.DARKEN);
		p.setBlendMode(BlendMode.DARKEN);
		con.setBlendMode(BlendMode.DARKEN);
		

		holdTime = realTime;
		
		
	//	i1.setVisible(true);
		
		
	}
	
	@FXML
	public void undrag(MouseEvent event) throws Exception
	{
		holdTime = 0;
		
		i.setBlendMode(BlendMode.SRC_OVER);
		p.setBlendMode(BlendMode.SRC_OVER);
		con.setBlendMode(BlendMode.SRC_OVER);
		//i1.setVisible(false);
	}
	
	
	
	@FXML
	public void End() 
	{
	
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");		
		System.out.println(timeFormat.format(currentDate));

		
		float hours = sec / 3600;
		float  minutes = (sec % 3600) / 60;
		float  seconds = sec % 60;
		
		float  rhours = realTime / 3600;
		float  rminutes = (realTime % 3600) / 60;
		float  rseconds = realTime % 60;
		
	//	String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	//	String reallTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
		
			
		System.out.println(sec);
		System.out.println(realTime);
		
		float actTime = 100 * (sec/realTime) ;
		

		System.out.println("Actually studied "+ actTime + "% of the time");
		
		
	}
	
	@FXML
	public void Pause(ActionEvent event) throws Exception
	{
		pause = true;
		p.setVisible(false);
		pButton.setDisable(true);
		
		conB.setVisible(true);
		conB.setDisable(false);
		
	}
	
	@FXML
	public void Continue(ActionEvent event) throws Exception
	{
		pause = false;
		
		conB.setVisible(false);
		conB.setDisable(true);
		
		p.setVisible(true);
		pButton.setDisable(false);
		
	}
	
}
	
