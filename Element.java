
import java.awt.Color;
import java.awt.Graphics;


/**
 * The Element represents the soccer ball element in the game.
 * It extends Polygon 
 */
public class Element extends Polygon {
	public Point[] points;
	double rotation;
	Point position;
	//Graphics brush;

	int score = 0;
	
    /**
     * Constructor for Element class.
     * 
     * @param shape The shape of the element.
     * @param position The position of the element.
     * @param rotation The rotation angle of the element.
     */	
	public Element(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.points = shape;
		this.rotation = rotation;
		this.position = position;
	}

	/**
     * Paints the element on the screen.
     * 
     * @param brush The Graphics object used for drawing.
     */
	public void paint(Graphics brush) {
         // Draw a base white circle
		 int radius = 30; 
		 int centerX = (int) position.getX() + radius;
		 int centerY = (int) position.getY() + radius;
		 brush.setColor(Color.WHITE);
		 brush.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
 
		 // Draw black pentagons
		 for (int i = 0; i < 5; i++) {
			 double angle = Math.PI * (2 * i / 5.0) + Math.PI / 2;
			 int x1 = (int) (centerX + radius * Math.cos(angle));
			 int y1 = (int) (centerY + radius * Math.sin(angle));
			 int x2 = (int) (centerX + radius / 3.0 * Math.cos(angle + Math.PI / 5.0));
			 int y2 = (int) (centerY + radius / 3.0 * Math.sin(angle + Math.PI / 5.0));
			 int x3 = (int) (centerX + radius / 3.0 * Math.cos(angle - Math.PI / 5.0));
			 int y3 = (int) (centerY + radius / 3.0 * Math.sin(angle - Math.PI / 5.0));
			 int[] xPoints = {x1, x2, x3, x1};
			 int[] yPoints = {y1, y2, y3, y1};
			 brush.setColor(Color.BLACK);
			 brush.fillPolygon(xPoints, yPoints, 4);
		 }
	}

    /**
     * Updates the position of the element.
     * 
     * @param xChange The change in the X coordinate.
     * @param yChange The change in the Y coordinate.
     */
	public void updatePosition(double xChange, double yChange) {
        this.position.setLocation(this.position.getX() + xChange, this.position.getY() + yChange);
    }

	/**
     * Updates the position of the element.
     * 
     * @param xChange The change in the X coordinate.
     * @param yChange The change in the Y coordinate.
     */
	public void move() {
		double amountToMove = this.position.getX();

		if (amountToMove < 950 && amountToMove >= 0) {
			this.position.setX(++amountToMove);
			//counter++;
		}

		if (this.position.getX() >= 950) {
			score++;
		}
	}

	
    /**
     * Rotates the element by the specified angle.
     * 
     * @param degrees The angle by which the element should be rotated.
     */
	public void rotate(int degrees) {
		rotation = (rotation + degrees) % 360;
	}

}