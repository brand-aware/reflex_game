/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import balogging.BALoggerUtil;
import core.LevelEngine;
import highscores.IBoardOutline;
import highscores.NameInput;

public class CommonBoard extends ConfigBoard{
	
	protected LevelEngine levelEngine;
	protected Properties properties;
	protected NameInput nameInput = null;
	protected IBoardOutline board;
	protected Levels levels;
	protected BALoggerUtil balogger;
	
	protected JFrame boardPage = null;
	protected JDesktopPane pane;
	
	protected JLabel background;
	protected JButton middle;
	protected JButton center;
	
	protected JMenuBar menuBar;
	protected JMenu fileMenu, optionsMenu, helpMenu;
	protected JMenuItem exit, rules, about;
	protected JCheckBoxMenuItem randomize;
	
	protected JButton start, stop, help;
	protected JComboBox<Double> levelChooser;
	
	protected JTextArea score, time, messages;
	
	protected ArrayList<JLabel> allBackgrounds = new ArrayList<JLabel>();
	
	protected double scoreStart = PRESET_SCORE_TIME_MODIFIER;
	protected double timeLastScore = 0;
	protected int startCount = 0; //timer
	protected int level = 0; //combo box
	protected int count = 0; //board display
	protected int miss = 0;
	
	protected int counter;
	//animation variables
	protected int messageCounter = 0;
	protected int patternCounter1 = 0;
	protected int patternCounter2 = 0;
	protected int patternProgress = 0; //fixed pattern display
	protected int displayPosition = -1; //gui coordinate system
	protected Long lastTime;
	//random mode timer variables
	protected int randomModifier = 0;
	protected int randomLevelPenalty = 0;
	
	protected boolean started = false;
	protected boolean playPattern = false;
	protected boolean messageSet = false;
	protected boolean showHelp = false;
	protected boolean patternSet = false;
	protected boolean randomizeFlag = false;
	
	protected boolean randomHelp = false;
	protected boolean randomPattern = false;
	protected boolean randomStarted = false;
	protected boolean randomMessage = false;
	
	// new lib vars
	protected final String PRODUCT_NAME = "reflex_game";
	protected String userDir;

}
