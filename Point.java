
/*
CLASS: Point
DESCRIPTION: Ah, if only real-life classes were this straight-forward. We'll
             use 'Point' throughout the program to store and access 
             coordinates.
*/

/**
 * The `Point` class represents a two-dimensional point in space.
 * 
 * <p>
 * This class is used to store and manipulate coordinates (x and y values).
 * </p>
 * 
 * @see java.awt.Point (for similar functionality in AWT)
 */
public class Point implements Cloneable {
	/**
	 * The x-coordinate and y-coordinate of the point.
	 */
	public double x, y;

	/**
	 * Constructor for the `Point` class.
	 * 
	 * <p>
	 * This constructor initializes the x and y coordinates of the point.
	 * </p>
	 * 
	 * @param inX The initial x-coordinate of the point.
	 * @param inY The initial y-coordinate of the point.
	 */
	public Point(double inX, double inY) {
		x = inX;
		y = inY;
	}

	/**
	 * Gets the x-coordinate of the point.
	 * 
	 * @return The x-coordinate of the point.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y-coordinate of the point.
	 * 
	 * @return The y-coordinate of the point.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the x-coordinate of the point.
	 * 
	 * @param x The new x-coordinate of the point.
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets the y-coordinate of the point.
	 * 
	 * @param y The new y-coordinate of the point.
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Creates a copy of the point object.
	 * 
	 * @return A new `Point` object with the same coordinates as this object.
	 * 
	 */
	public Point clone() {
		return new Point(x, y);
	}

	/**
	 * This method is not implemented and throws an `UnsupportedOperationException`
	 * if called.
	 * 
	 * @param d The x-coordinate for the new location (ignored).
	 * @param e The y-coordinate for the new location (ignored).
	 * @throws UnsupportedOperationException This method is not supported.
	 */
	public void setLocation(double d, double e) {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException("Unimplemented method 'setLocation'");
	}
}