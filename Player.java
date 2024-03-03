/**
 * The Player interface represents a player in the game. Any class implementing
 * this interface must define the move() method.
 */
public interface Player {
	/**
	 * This method defines how the player moves within the game world.
	 * 
	 * <p>
	 * The implementation of this method should update the player's position based
	 * on the game's rules and mechanics.
	 * </p>
	 */
	public void move();
}
