package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	
	
	@FXML
	Button endButton;
	
	@FXML
	Text startStudy;
	
	@FXML
	Text endStudy;
	
	@FXML
	Text actStudy;
	
	private Scene scene;
	private Stage stage;
	
    ScaleTransition scale = new ScaleTransition();
	
    double x = 0.5;
    
    float sec = 0;
    float realTime = 0;
    boolean pause;
    float holdTime = 0;
    boolean checking = false;
    float checkTime = 0;

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
		startStudy.setText("Started studying at: "+ timeFormat.format(currentDate));
		


		//startStudy.setText("test");
		
		Timer timer = new Timer();

		
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            	
            	if(pause == false && checking == false)
            	{
            		scale.setNode(c);           		
                	scale.setByX(x);
            		scale.setByY(x);
            		scale.play();
            		sec ++;
            		realTime ++;
            	}
            	
            	if(pause == true)
            	{
            		
            		realTime ++;
            	}
            	
            	if(holdTime + 3 == realTime && realTime !=3)
        		{
        		
						checkEnd();
									
        		}
            	
            	if(checkTime + 3 == realTime && realTime !=3)
        		{

						checkGone();
									
        		}

            	
            }
        };
        timer.schedule(task, 1000, 1000);
	}
	
	@FXML
	public void drag(MouseEvent event) throws Exception
	{
		if(checking == false)
		{
			i.setBlendMode(BlendMode.DARKEN);
			p.setBlendMode(BlendMode.DARKEN);
			con.setBlendMode(BlendMode.DARKEN);
			
		}
		
		endButton.setBlendMode(BlendMode.DARKEN);
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

	
		endButton.setBlendMode(BlendMode.SRC_OVER);
		//i1.setVisible(false);
	}
	
	
	
	
	public void checkEnd() 
	{
		checking = true;
		endButton.setVisible(true);
		endButton.setDisable(false);
		pause = true;
		
		checkTime = realTime;
		
		
	}
	
	public void checkGone() 
	{
		checking = false;
		endButton.setVisible(false);
		endButton.setDisable(true);
		pause = true;
		
		checkTime = 0;
		
		
	}

	
	@FXML
	public void End(ActionEvent event) throws IOException 
	{		
	
		checkGone();
		
		Date currentDate = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");		
		System.out.println(timeFormat.format(currentDate));
		
		float hours = sec / 3600;
		float  minutes = (sec % 3600) / 60;
		float  seconds = sec % 60;
		
		float  rhours = realTime / 3600;
		float  rminutes = (realTime % 3600) / 60;
		float  rseconds = realTime % 60;
		
		
		float actTime = 100 * (sec/realTime) ;			
		System.out.println("Actually studied "+ actTime + "% of the time");
		
		actStudy.setText("Actually studied "+ actTime + "% of the time");
		actStudy.setVisible(true);
		endStudy.setText("Finished studying at: "+ timeFormat.format(currentDate));
		endStudy.setVisible(true);
		startStudy.setVisible(true);

		conB.setVisible(false);
		conB.setDisable(true);
		
		p.setVisible(false);
		pButton.setDisable(true);
		
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
		if(checking == false)
		{
			pause = false;
			
			conB.setVisible(false);
			conB.setDisable(true);
			
			p.setVisible(true);
			pButton.setDisable(false);
		}
		
		
	}
	
	
	
}
	
