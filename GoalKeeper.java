
import java.awt.*;

public class GoalKeeper extends Polygon implements Player{

    static Image image;
  private final int SPEED = 5; // Adjust speed as needed

  public Point[] points;
  double rotation;
  Point position;
 // private KeyListener keyListener;

  public GoalKeeper(Point[] shape, Point position, double rotation) {
    super(shape, position, rotation);
    this.points = shape;
    this.rotation = rotation;
    this.position = position;
    image = Toolkit.getDefaultToolkit().getImage("goalkeeper.png"); // Replace with your image path
  }

  @Override
  public void move(){
    /*
     * double positionY = this.position.getY();

    if(positionY >= 100 && positionY < 450){
        this.position.setY(++positionY);
    } 
    if(this.position.getX() >= 450){
        this.position.setY(300);
    }
     */
    
     double amountToMove = this.position.getY();
     boolean forward = true;
     boolean left = false;
     boolean right = false;
 
     if (amountToMove < 350 && amountToMove >= 200) {
       this.position.setY(++amountToMove);
       //counter++;
     }
 
     if (this.position.getY() >= 350) {
       this.position.setY(200);
     //  counter++;
     }
   }
    

  public void paint(Graphics brush) {
    brush.drawImage(image, (int) position.getX() - image.getWidth(null) / 2, (int) position.getY() - image.getHeight(null) / 2, null);
    this.move();
  }
}

  

