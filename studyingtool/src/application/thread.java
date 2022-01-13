package application;

import java.util.concurrent.TimeUnit;

public class thread extends Thread{

	public int x =0;
    static boolean exit = false;
    static boolean pause = false;
    
	public void run()
	{
		while(exit == false)
		{	
			time();	
			try {
				thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	

	
}