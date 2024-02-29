import java.awt.*;
import java.awt.event.*;


public class Striker extends Polygon implements Player {

  static Image image;
  private final int SPEED = 5; // Adjust speed as needed

  public Point[] points;
  double rotation;
  Point position;
  private KeyListener keyListener;

  public Striker(Point[] shape, Point position, double rotation) {
    super(shape, position, rotation);
    this.points = shape;
    this.rotation = rotation;
    this.position = position;
    image = Toolkit.getDefaultToolkit().getImage("pic.png"); // Replace with your image path

    keyListener = new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
          moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
          moveRight();
        }
      }
    };
  }

  @Override
  public void move(){}
    

  public void paint(Graphics brush) {
    brush.drawImage(image, (int) position.getX() - image.getWidth(null) / 2, (int) position.getY() - image.getHeight(null) / 2, null);
  }

  public void moveLeft() {
    if (position.getX() > 50) {
      position.setX(position.getX() - SPEED);
    }
  }

public void moveRight() {
  if (position.getX() < 500) {
    position.setX(position.getX() + SPEED);
  }
}

  public void addKeyListener(Component component) {
    component.addKeyListener(keyListener);
  }

  public void removeKeyListener(Component component) {
    component.removeKeyListener(keyListener);
  }

  public void rotate(int degrees) {
    rotation = (rotation + degrees) % 360;
  }
}
