
import java.awt.*;

public class GoalKeeper extends Polygon implements Player {

  static Image image;

  public Point[] points;
  double rotation;
  Point position;
  int score = 0; // Score variable

  /**
   * Constructor for the GoalKeeper class.
   * 
   * @param shape    The shape of the goalkeeper.
   * @param position The initial position of the goalkeeper.
   * @param rotation The initial rotation angle of the goalkeeper.
   */
  public GoalKeeper(Point[] shape, Point position, double rotation) {
    super(shape, position, rotation);
    this.points = shape;
    this.rotation = rotation;
    this.position = position;
    image = Toolkit.getDefaultToolkit().getImage("goalkeeper.png"); // Replace with your image path
  }

  /**
   * Moves the goalkeeper vertically on the screen automatically
   */
  @Override
  public void move() {
    double amountToMove = this.position.getY();

    if (amountToMove < 530 && amountToMove >= 200) {
      this.position.setY(++amountToMove);
      // counter++;
    }

    if (this.position.getY() >= 530) {
      this.position.setY(250);
      // counter++;
    }
  }

    /**
     * Paints the goalkeeper on the screen.
     * 
     * @param brush The Graphics object used for drawing.
     */
    public void paint(Graphics brush) {
      brush.drawImage(image, (int) position.getX() - image.getWidth(null) / 2,
        (int) position.getY() - image.getHeight(null) / 2, null);
      this.move();
    }
}
