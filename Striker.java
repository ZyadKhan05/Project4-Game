import java.awt.*;
import java.awt.event.*;

/**
 * The Striker class represents a striker player in the game.
 * It extends Polygon and implements the Player interface.
 */
public class Striker extends Polygon implements Player {

  static Image image;
  private final int SPEED = 7;

  /**
   * An array of `Point` objects that defines the shape of the element. 
   * Each `Point` in the array represents a vertex of the polygon shape.
   */
  public Point[] points;
  double rotation;
  Point position;
  private KeyListener keyListener;

  /**
   * Constructor for the Striker class.
   * 
   * @param shape    The shape of the striker.
   * @param position The initial position of the striker.
   * @param rotation The initial rotation angle of the striker.
   */
  public Striker(Point[] shape, Point position, double rotation) {
    super(shape, position, rotation);
    this.points = shape;
    this.rotation = rotation;
    this.position = position;
    image = Toolkit.getDefaultToolkit().getImage("striker.png");

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

  // Implementation of the move() method required by the Player interface.
  // This method is intentionally left blank as it is not used in this class.
  @Override
  public void move() {
  }

    /**
     * Paints the striker on the screen.
     * 
     * @param brush The Graphics object used for drawing.
     */
  public void paint(Graphics brush) {
    brush.drawImage(image, (int) position.getX() - image.getWidth(null) / 2,
        (int) position.getY() - image.getHeight(null) / 2, null);
  }

  /**
   * Moves the striker horizontally to the left.
   */
  public void moveLeft() {
    if (position.getX() > 70) {
      position.setX(position.getX() - SPEED);
    }
  }

  /**
   * Moves the striker horizontally to the left.
   */
  public void moveRight() {
    if (position.getX() < 900) {
      position.setX(position.getX() + SPEED);
    }
  }

    /**
   * Moves the striker vertically up.
   */
  public void moveUp() {
    position.setY(position.getY() - SPEED);
  }

    /**
   * Moves the striker vertically down.
   */
  public void moveDown() {
    position.setY(position.getY() + SPEED);
  }

    /**
     * Adds a key listener to a component.
     * 
     * @param component The component to which the key listener is added.
     */
  public void addKeyListener(Component component) {
    component.addKeyListener(keyListener);
  }

      /**
     * Removes a key listener from a component.
     * 
     * @param component The component from which the key listener is removed.
     */
  public void removeKeyListener(Component component) {
    component.removeKeyListener(keyListener);
  }

  /**
  * Rotates the striker by the specified angle.
  * 
  * @param degrees The angle by which the striker should be rotated.
  */
  public void rotate(int degrees) {
    rotation = (rotation + degrees) % 360;
  }
}