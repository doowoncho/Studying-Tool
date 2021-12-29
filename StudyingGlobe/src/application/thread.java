package application;

import java.util.concurrent.TimeUnit;

public class thread extends Thread{

	public int x =0;
    protected boolean exit = false;
	public void run()
	{
		while(exit == false)
		{

			try {
				thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(x);
			System.out.println(exit);
			x++;
			
		}
		
	}
	public void setboolean() {
		exit = true;
		System.out.println(exit);
		
	}
	
}
