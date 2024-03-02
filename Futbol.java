
/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.KeyEvent;

class Futbol extends Game {
	static int counter = 0;

	Element element;
	Striker striker;
	GoalKeeper goalKeeper;

	public Futbol() {
		super("Futbol!", 1000, 800);
		this.setFocusable(true);
		this.requestFocus();

		// Create element with desired shape, position, and rotation
		Point[] elementPoints = {
				new Point(0, 0),
				new Point(100, 0),
				new Point(100, 100),
				new Point(0, 100)
		};

		Point elementPosition = new Point(150, 400); 
		double elementRotation = 0;

		Point[] strikerPoints = {
			new Point(0, 0),
			new Point(100, 0),
			new Point(100, 100),
			new Point(0, 100)
	};



		Point strikerPosition = new Point(100, 400); 
		double strikerRotation = 0; 

		element = new Element(elementPoints, elementPosition, elementRotation);

		striker = new Striker(strikerPoints, strikerPosition, strikerRotation);
		striker.addKeyListener(this);

		// creating the goalkeeper
		goalKeeper = new GoalKeeper(elementPoints, new Point(875, 300), elementRotation);
	}

	public void paint(Graphics brush) {
		// Draw soccer field background
		brush.setColor(new Color(128, 209, 70)); // Light green color for the field
		brush.fillRect(0, 0, width, height);

		// Draw field lines
		brush.setColor(Color.white);

		// Calculate field dimensions based on proportions
		int fieldWidth = width - 2 * (width / 10);
		int fieldHeight = height - 2 * (height / 10);
		int goalLineY1 = height / 3;
		int goalLineY2 = 2 * height / 3;

		// Draw center line
		brush.drawLine(fieldWidth / 2, 0, fieldWidth / 2, height);

		// Draw penalty areas
		int penaltyAreaWidth = fieldWidth * 2 / 3;
		int penaltyAreaHeight = goalLineY2 - goalLineY1;

		// Draw penalty spot
		int penaltySpotX = width / 10 + penaltyAreaWidth / 6;
		int penaltySpotY = goalLineY1 + penaltyAreaHeight / 2;

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

		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		// counter++;
		brush.setColor(Color.white);
		brush.drawString("Score is " + element.counter,10,10);
		

		if (element != null) {
			element.paint(brush);
			// Check for collision with striker
			if (this.strikerCollision(striker, element)) {
				// Move the ball forward
				element.position.setX(element.position.getX() + 10); // Adjust speed as needed
				element.rotate(5);
			}
			if (this.goalkeeperCollision(goalKeeper, element)) {
			 	// Move the ball forward
			 	element.position.setX(100); 
			}
			// element.move(); // Call move
			element.rotate(5); // Call rotate
			repaint(); // Call repaint after modifications
		}

		// to draw the lines thick
		brush.setColor(Color.white);
		Graphics2D g2d = (Graphics2D) brush;

		// Set the thickness of the line
		int thickness = 5;
		g2d.setStroke(new BasicStroke(thickness));

		// Draw a line
		g2d.drawLine(800, 250, 1000, 250);
		g2d.drawLine(800, 250, 800, 550);
		g2d.drawLine(800, 550, 1000, 550);
		// brush.drawArc(800, 250, 800, 300, 90, 180);

		if (striker != null) {
			striker.paint(brush);
		}

		// For goal keeper
		goalKeeper.paint(brush);
		goalKeeper.move();

		// repaint();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			striker.moveLeft();
			; // Move striker left
		} else if (key == KeyEvent.VK_RIGHT) {
			striker.moveRight();
			; // Move striker right
		}
	}

	public boolean strikerCollision(Polygon object1, Polygon object2) {
		// Get the points of each object
		Point[] points1 = object1.getPoints();
		Point[] points2 = object2.getPoints();

		// Loop through each point in the first object
		for (Point point1 : points1) {
			// Check if the point is inside the second object
			if (object2.contains(point1)) {
				return true; // Collision detected
			}
		}

		// Loop through each point in the second object
		for (Point point2 : points2) {
			// Check if the point is inside the first object
			if (object1.contains(point2)) {
				return true; // Collision detected
			}
		}
		// No collision detected
		return false;
	}

	public boolean goalkeeperCollision(Polygon object1, Polygon object2) {
		// Get the points of each object
		Point[] points1 = object1.getPoints();
		Point[] points2 = object2.getPoints();

		// Loop through each point in the first object
		for (Point point1 : points1) {
			// Check if the point is inside the second object
			if (object2.contains(point1)) {
				return true; // Collision detected
			}
		}

		// Loop through each point in the second object
		for (Point point2 : points2) {
			// Check if the point is inside the first object
			if (object1.contains(point2)) {
				return true; // Collision detected
			}
		}
		// No collision detected
		return false;
	}

	public static void main(String[] args) {
		Futbol a = new Futbol();
		a.setVisible(true);
	}
}
