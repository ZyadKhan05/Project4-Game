
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Element extends Polygon {
	public Point[] points;
	double rotation;
	Point position;
	//Graphics brush;

	int counter = 0;
	
	public Element(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.points = shape;
		this.rotation = rotation;
		this.position = position;
	}

	public void paint(Graphics brush) {
        // Draw a base circle
        int radius = 50; // Adjust for desired size
		// Adjust offset for center
        int centerX = (int) position.getX() + 50; 
		// Adjust offset for center
        int centerY = (int) position.getY() + 50; 
        brush.setColor(Color.WHITE);
        brush.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw additional circles to simulate sphere
        for (int i = 1; i < 4; i++) { // Adjust number of circles for desired effect
            brush.setColor(new Color(255, 255, 255, 255 - i * 50)); // Adjust transparency for depth effect
            brush.fillOval(centerX - radius + i * 10, centerY - radius + i * 10, 2 * radius - 2 * i * 10, 2 * radius - 2 * i * 10);
        }
	}

	public void updatePosition(double xChange, double yChange) {
        this.position.setLocation(this.position.getX() + xChange, this.position.getY() + yChange);
    }

	public void move() {
		double amountToMove = this.position.getX();
		boolean forward = true;
		boolean left = false;
		boolean right = false;

		if (amountToMove < 700 && amountToMove >= 0) {
			this.position.setX(++amountToMove);
			//counter++;
		}

		if (this.position.getX() >= 700) {
			this.position.setX(10);
			counter++;
		}
	}

	

	public void rotate(int degrees) {
		rotation = (rotation + degrees) % 360;
	}

}