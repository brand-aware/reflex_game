/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

public class ConfigBoard extends ConfigGameplay {
	
	protected final String HEADER = "reflex_game";
	
	protected final int WIDTH = 6;
	protected final int HEIGHT = 5;
	
	protected final int TITLE_WIDTH = 502;
	protected final int TITLE_HEIGHT = 136;
	
	protected final int BACKGROUND_WIDTH = 69;
	protected final int BACKGROUND_HEIGHT = 62;
	
	protected final int MIDDLE_WIDTH = 56;
	protected final int MIDDLE_HEIGHT = 50;	
	
	protected final int CENTER_WIDTH = 14;
	protected final int CENTER_HEIGHT = 12;
	
	protected final int SPACE = 33;
	
	protected final int START_BUTTON_WIDTH = 100;
	protected final int START_BUTTON_HEIGHT = 30;
	
	protected final int STOP_BUTTON_WIDTH = 100;
	protected final int STOP_BUTTON_HEIGHT = 30;
	
	protected final int HELP_BUTTON_WIDTH = 100;
	protected final int HELP_BUTTON_HEIGHT = 30;
	
	protected final int LEVEL_CHOOSER_WIDTH = 100;
	protected final int LEVEL_CHOOSER_HEIGHT = 30;
	
	protected final int SCORE_DISPLAY_WIDTH = 75;
	protected final int SCORE_DISPLAY_HEIGHT = 20;
	
	protected final int SCORE_LABEL_WIDTH = 55;
	protected final int SCORE_LABEL_HEIGHT = 30;
	
	protected final int TIME_DISPLAY_WIDTH = 75;
	protected final int TIME_DISPLAY_HEIGHT = 20;
	
	protected final int TIME_LABEL_WIDTH = 100;
	protected final int TIME_LABEL_HEIGHT = 30;
	
	protected final int MESSAGE_DISPLAY_WIDTH = 200;
	protected final int MESSAGE_DISPLAY_HEIGHT = 30;
	
	protected final int MESSAGE_LABEL_WIDTH = 45;
	protected final int MESSAGE_LABEL_HEIGHT = 20;
	
	protected int gameAreaX = 0;
	protected int gameAreaY = 0;
	protected int totalX = 0;
	protected int totalY = 0;
	protected int topHeight = 0;
	
	protected int titleX = 0;
	protected int titleY = 0;
	protected int startX = 0;
	protected int startY = 0;
	protected int stopX = 0;
	protected int stopY = 0;
	protected int helpX = 0;
	protected int helpY = 0;
	protected int chooserX = 0;
	protected int chooserY = 0;
	
	protected int scoreDisplayX = 0;
	protected int scoreDisplayY = 0;
	protected int scoreLabelX = 0;
	protected int scoreLabelY = 0;
	protected int timeDisplayX = 0;
	protected int timeDisplayY = 0;
	protected int timeLabelX = 0;
	protected int timeLabelY = 0;
	protected int messageDisplayX = 0;
	protected int messageDisplayY = 0;
	protected int messageLabelX = 0;
	protected int messageLabelY = 0;
	
	public ConfigBoard(){
		gameAreaX = BACKGROUND_WIDTH * WIDTH + SPACE * (WIDTH + 1) + 15;
		gameAreaY = BACKGROUND_HEIGHT * HEIGHT + SPACE * (HEIGHT + 1);
		
		topHeight = TITLE_HEIGHT + HELP_BUTTON_HEIGHT 
		+ SCORE_LABEL_HEIGHT + 35 + 15;
		
		totalX = gameAreaX;
		totalY = gameAreaY + topHeight + SPACE;
		titleX = (totalX / 2) - (TITLE_WIDTH / 2);
		titleY = 5;
		
		int row1X = START_BUTTON_WIDTH + STOP_BUTTON_WIDTH 
				+ HELP_BUTTON_WIDTH + LEVEL_CHOOSER_WIDTH + 25;
		int row1Y = TITLE_HEIGHT + 10;
		
		startX = (totalX / 2) - (row1X / 2);
		startY = row1Y;
		stopX = startX + START_BUTTON_WIDTH + 5;
		stopY = row1Y;
		helpX = stopX + STOP_BUTTON_WIDTH + 5;
		helpY = row1Y;
		chooserX = helpX + HELP_BUTTON_WIDTH + 5;
		chooserY = row1Y;
		
		int row2X = SCORE_DISPLAY_WIDTH + SCORE_LABEL_WIDTH 
				+ TIME_DISPLAY_WIDTH + TIME_LABEL_WIDTH + MESSAGE_DISPLAY_WIDTH 
				+ MESSAGE_LABEL_WIDTH + 65;
		int row2Y = row1Y + STOP_BUTTON_HEIGHT + 5;
		
		scoreLabelX = (totalX / 2) - (row2X / 2);
		scoreLabelY = row2Y;
		scoreDisplayX = scoreLabelX + SCORE_LABEL_WIDTH + 5;
		scoreDisplayY = row2Y;
		timeLabelX = scoreDisplayX + SCORE_DISPLAY_WIDTH + 5;
		timeLabelY = row2Y;
		timeDisplayX = timeLabelX + TIME_LABEL_WIDTH + 5;
		timeDisplayY = row2Y;
		messageLabelX = timeDisplayX + TIME_DISPLAY_WIDTH + 5;
		messageLabelY = row2Y;
		messageDisplayX = messageLabelX + MESSAGE_LABEL_WIDTH + 5;
		messageDisplayY = row2Y;
		
	}
}
