
/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.KeyEvent;

class YourGameName extends Game {
	static int counter = 0;

	Element element;
	Striker striker;
	
	public YourGameName() {
		super("Futbol!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
	  
		// Create element with desired shape, position, and rotation
		Point[] elementPoints = {
			new Point(0, 0),
			new Point(100, 0),
			new Point(100, 100),
			new Point(0, 100)
		};
	  
		Point elementPosition = new Point(400, 300); // Center of the screen
		double elementRotation = 0; // No rotation initially
	  
		element = new Element(elementPoints, elementPosition, elementRotation);
	  
		striker = new Striker(elementPoints, elementPosition, elementRotation);
		striker.addKeyListener(this); 
	}


  public void paint(Graphics brush) {
	// Draw soccer field background
	brush.setColor(new Color(128, 209, 70)); // Light green color for the field
	brush.fillRect(0, 0, width, height);

	// Draw field lines
	brush.setColor(Color.white);

	// Calculate field dimensions based on proportions
	int fieldWidth = width - 2 * (width / 10); // Subtract margins on each side
	int fieldHeight = height - 2 * (height / 10);
	int goalLineY1 = height / 3;
	int goalLineY2 = 2 * height / 3;

	// Draw rounded corners at goal lines (using arcs)
	brush.drawArc(0, goalLineY1 - fieldWidth / 18, fieldWidth / 9, fieldWidth / 9, 0, 180);
	brush.drawArc(width - fieldWidth, goalLineY1 - fieldWidth / 18, fieldWidth / 9, fieldWidth / 9, 180, 180);
	brush.drawArc(0, goalLineY2 - fieldWidth / 18, fieldWidth / 9, fieldWidth / 9, 0, 180);
	brush.drawArc(width - fieldWidth, goalLineY2 - fieldWidth / 18, fieldWidth / 9, fieldWidth / 9, 180, 180);

	// Draw touchlines
	brush.drawLine(width / 10, 0, width / 10, height);
	brush.drawLine(width - width / 10, 0, width - width / 10, height);

	// Draw center line
	brush.drawLine(fieldWidth / 2, 0, fieldWidth / 2, height);

	// Draw penalty areas
	int penaltyAreaWidth = fieldWidth * 2 / 3;
	int penaltyAreaHeight = goalLineY2 - goalLineY1;
	brush.drawRect(width / 10, goalLineY1, penaltyAreaWidth, penaltyAreaHeight);
	brush.drawRect(width - width / 10 - penaltyAreaWidth, goalLineY1, penaltyAreaWidth, penaltyAreaHeight);

	// Draw goal lines
	brush.drawLine(0, goalLineY1, width, goalLineY1);
	brush.drawLine(0, goalLineY2, width, goalLineY2);

	// Draw penalty spots (12 yards from goal line)
	int penaltySpotX = width / 10 + penaltyAreaWidth / 6;
	int penaltySpotY = goalLineY1 + penaltyAreaHeight / 2;
	brush.fillOval(penaltySpotX - 3, penaltySpotY - 3, 6, 6); // Adjust size as needed

	brush.fillOval(width - penaltySpotX - 3, penaltySpotY - 3, 6, 6); // Adjust size as needed

	// Draw center circle
	int centerX = fieldWidth / 2;
	int centerY = (goalLineY1 + goalLineY2) / 2;
	int radius = Math.min(fieldWidth / 5, fieldHeight / 5); // Adjust radius based on field size
	brush.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);


	brush.setColor(Color.white); // Set back to white for striker and potential text
	if (striker != null) {
		striker.paint(brush);
	}
   // brush.setColor(Color.green);
    //brush.fillRect(0, 0, width, height);

    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	//counter++;
    	//brush.setColor(Color.white);
    	//brush.drawString("Counter is " + counter,10,10);
    	//brush.draw

    if (element != null) {
      element.paint(brush);
     // element.move(); // Call move
      element.rotate(5); // Call rotate
      repaint(); // Call repaint after modifications
    }

    brush.drawLine(600, 150, 800, 150);
    brush.drawLine(600, 150, 600, 450);
    brush.drawLine(600, 450, 800, 450);
    brush.setColor(Color.white);
	if (striker != null) {
		striker.paint(brush);
	  }
  }

  public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();
	if (key == KeyEvent.VK_LEFT) {
		striker.moveLeft();; // Move striker left
	} else if (key == KeyEvent.VK_RIGHT) {
		striker.moveRight();; // Move striker right
	}
}

  public static void main(String[] args) {
    YourGameName a = new YourGameName();
    a.setVisible(true); 
  }
}
