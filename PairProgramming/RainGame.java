//UIUC CS125 FALL 2014 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2015-09-28T22:34:25-0500.001253881
/**
 * @author bzhang64,qilezhi2
 * @reviewed kalyonc2, ybao9
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0, count = 0;
		int color;
		String text = "";
		long startTime = System.currentTimeMillis(); // Set start time.

		Zen.setFont("Helvetica-32");
		
		while (Zen.isRunning()) {

			if (text.length() == 0 || y > Zen.getZenHeight()) { 
				
				int oldCount=count;
				if (text.length() == 0) count++;
				
				x = (int) (Zen.getZenWidth()/4+Math.random() * (Zen.getZenWidth()/2));
				y = 0;
				dx = 0;
				dy = 2+count; // The numbers should fall vertically.
				
				text = "" + (int) (Math.random() * 999); 
				long elapsed = System.currentTimeMillis() - startTime; // Calculate the time used to type a number.
				startTime = System.currentTimeMillis();
				
				if (count!=1 && oldCount!=count) score += 90000 / elapsed; // The score remains unchanged when count = 1.
																			// If text.length() == 0, score increases.
				if (oldCount==count) score -= 10;  // If the number falls past the bottom of the screen, score decreases.
			}
				
			Zen.setColor(255, 255, 200);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			
			// Visual distraction.
			for (int j=5; j<count; j++) { // The number of visual distraction is based on level of difficulty.
				Zen.setColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)); // the color is random.
				Zen.fillRect((int)(Math.random()*Zen.getZenWidth()),(int)(Math.random()*Zen.getZenHeight()),(int)(Math.random()*10+5),(int)(Math.random()*10+5));
			}

			color = 10 * count;
			if (color > 200) color = 200;
			Zen.setColor(color, color, color); // The color is lighter when count becomes bigger. 
			Zen.drawText(text, x, y);
			
			Zen.setColor(0, 0, 0);
			Zen.drawText("Level: "+count,10,40);
			Zen.drawText("Score: "+score,10,80);
			Zen.drawText("Enter \"s\" to skip the easiest level.",10,450);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
		
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if((c == 's') && count<10) {
					count=10;
					dy = 2+count;
				}
			}
			
			for(int i=0; i < user.length() && text.length()!=0; i++) { // Add "text.length()!=0" to avoid exception.
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); // all except first character
			}
			
			Zen.flipBuffer(); // Prevent flicker.
			Zen.sleep(90); // sleep for 90 milliseconds

		}
	}

}
