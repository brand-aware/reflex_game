/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
import core.Board;
import core.Mover;
import utils.Properties;

public class driver {

	/**
	 * From program launcher on OS, starts all main components
	 * using project working directory.
	 * 
	 * @param String[] args
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Program syntax:\n"
					+ "java driver <working directory>");
			System.exit(0);
		}
		Properties properties = new Properties(args[0]);
		Board board = new Board(properties);
		board.init();
		properties.setBoard(board);
		Mover mover = new Mover(properties);
		Thread thread = new Thread(mover);
		thread.start();
	}
}