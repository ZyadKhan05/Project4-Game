package game;

import java.awt.*;

public class Striker extends Polygon implements Player{

	static Image image;
	
	public Point[] points;
	double rotation;
	Point position;

	int counter = 0;
	
	public Striker(Point[] shape, Point position, double rotation) {
		super(shape, position, rotation);
		this.points = shape;
		this.rotation = rotation;
		this.position = position;
		
		image = Toolkit.getDefaultToolkit().getImage("stick-figure-png-.png");
	}

	public void paint(Graphics brush) {

		brush.drawImage(image, 200, 300, 100, 100, null);	
		/*
		brush.setColor(Color.CYAN); // Set color to blue (for example)

		Point[] points = getPoints();

		int[] xPoints = new int[points.length];

		int[] yPoints = new int[points.length];

		for (int i = 0; i < points.length; i++) {
			xPoints[i] = (int) points[i].getX();
			yPoints[i] = (int) points[i].getY();
		}
		brush.fillPolygon(xPoints, yPoints, points.length);
		
		brush.drawString("Counter is " + counter,10,10);
		*/
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