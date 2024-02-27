package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

class YourGameName extends Game {
	static int counter = 0;

	Element element;
	Striker striker;
	
	public YourGameName() {
		super("YourGameName!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		
		// Create element with desired shape, position, and rotation
		Point[] elementPoints = { 
				new Point(0, 0), 
				new Point(100, 0), 
				new Point(100, 100), 
				new Point(0, 100) };
		
		Point elementPosition = new Point(400, 300); // Center of the screen
		double elementRotation = 0; // No rotation initially

		element = new Element(elementPoints, elementPosition, elementRotation);
		
		striker = new Striker(elementPoints, elementPosition, elementRotation);
	}

	public void paint(Graphics brush) {
    	brush.setColor(Color.green);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	//counter++;
    	//brush.setColor(Color.white);
    	//brush.drawString("Counter is " + counter,10,10);
    	//brush.draw
    	element.paint(brush);
    	element.move();
    	element.rotate(5);
    	brush.drawLine(600, 150 , 800, 150);
    	brush.drawLine(600, 150 , 600, 450);
    	brush.drawLine(600, 450 , 800, 450);
    	brush.setColor(Color.white);
    	striker.paint(brush);
    	//brush.set
    		
    	
  }

	public static void main(String[] args) {
		YourGameName a = new YourGameName();
		a.repaint();
	}
}