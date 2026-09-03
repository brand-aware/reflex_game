/**
 * @author wontzer
 * 
 * product of - ???
 * 2017
 */
import com.reflex_game.core.Board;
import com.reflex_game.core.Mover;
import com.reflex_game.utils.Properties;

public class driver {

	/**
	 * From program launcher on OS, starts all main components
	 * using project working directory.
	 * 
	 * @param String[] args
	 */
	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		Properties properties = new Properties(currentDir);
		Board board = new Board(properties);
		board.init();
		properties.setBoard(board);
		Mover mover = new Mover(properties);
		Thread thread = new Thread(mover);
		thread.start();
	}
}