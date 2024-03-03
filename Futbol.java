
/*
CLASS: Futbol
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Constructor for Futbol class. Initializes the game components.
 */
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
				new Point(20, 0),
				new Point(20, 20),
				new Point(0, 20)
		};

		Point elementPosition = new Point(150, 400);
		double elementRotation = 0;

		Point[] strikerPoints = {
				new Point(0, 0),
				new Point(75, 0),
				new Point(75, 75),
				new Point(0, 75)
		};

		Point strikerPosition = new Point(100, 400);
		double strikerRotation = 0;

		element = new Element(elementPoints, elementPosition, elementRotation);

		striker = new Striker(strikerPoints, strikerPosition, strikerRotation);
		striker.addKeyListener(this);

		// creating the goalkeeper
		goalKeeper = new GoalKeeper(elementPoints, new Point(875, 300), elementRotation);
	}

	/**
	 * Paint method for drawing the game components on the screen.
	 * 
	 * @param brush The Graphics object used for drawing.
	 */
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

		if (element != null) {
			element.paint(brush);
			// Check for collision with striker
			if (this.playerCollision(striker, element)) {
				// Move the ball forward
				element.position.setX(element.position.getX() + 10); // Adjust speed as needed
				element.rotate(5);
			}
			if (this.playerCollision(goalKeeper, element)) {
				goalKeeper.score++;
				element.position.setX(100);
				striker.position.setX(75);
			}

			// Check for collision with the goal line (when the striker scores)
			if (element.position.getX() > 880) {
				// Increment score when the striker scores a goal
				element.score++;

				// Reset ball position
				element.position.setX(100);
				striker.position.setX(75);
			}
			// element.move(); // Call move
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
		if (goalKeeper != null) {
			goalKeeper.paint(brush);
			goalKeeper.move();
		}
		// repaint();

		Font font = new Font("Arial", Font.BOLD, 28);
		brush.setFont(font);

		// Draw home and away scores
		if (element != null && goalKeeper != null) {
			brush.setColor(Color.BLUE);
			brush.drawString(String.valueOf(element.score), 200, 30); // Home score on left
			brush.setColor(Color.RED);
			brush.drawString(String.valueOf(goalKeeper.score), width - 200, 30); // Away score on right
		}
	}

	/**
	 * Handles the keyPressed event.
	 * 
	 * @param e The KeyEvent object representing the key press event.
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			striker.moveLeft();
		} else if (key == KeyEvent.VK_RIGHT) {
			striker.moveRight();
		} else if (key == KeyEvent.VK_UP) {
			striker.moveUp();
		} else if (key == KeyEvent.VK_DOWN) {
			striker.moveDown();
		}
	}

	/**
	 * Checks for collision between two polygons.
	 * 
	 * @param object1 The first polygon.
	 * @param object2 The second polygon.
	 * @return True if collision is detected, false otherwise.
	 */
	public boolean playerCollision(Polygon object1, Polygon object2) {
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


	/**
 	* The main method of the program.
 	* 
 	* @param args Command-line arguments (not used).
 	*/
	public static void main(String[] args) {
		Futbol a = new Futbol();
		a.setVisible(true);
	}
}
