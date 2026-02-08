/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import balogging.BALoggerUtil;
import highscores.HighScores;
import highscores.IBoardOutline;
import highscores.hsProperties;
import utils.Levels;
import utils.Properties;

public class Board extends UserActions implements IBoardOutline{
	
	private ButtonHandler handler;
	private MenuHandler menuHandler;
	
	public Board(Properties p){
		properties = p;
		levels = new Levels();
		levelEngine = new LevelEngine(WIDTH, HEIGHT, levels);
		balogger = new BALoggerUtil(properties.getRoot(), "reflex_game");
		board = this;
	}
	
	private void createBoard(){
		boardPage = new JFrame(HEADER);
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardPage.setResizable(false);
		boardPage.setLocation(200, 15);
		String imageDir = properties.getImageDir();
		Image logo = Toolkit.getDefaultToolkit().getImage(imageDir + File.separator + "company.png");
		boardPage.setIconImage(logo);
		menuHandler = new MenuHandler();
		handler = new ButtonHandler();
		pane = new JDesktopPane();
		ImageIcon gameBackground = new ImageIcon(properties.getGameBackground());
		JLabel gameBackgroundLabel = new JLabel();
		gameBackgroundLabel.setIcon(gameBackground);
		gameBackgroundLabel.setBounds(0, 0, 700, 900);
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("file");
		optionsMenu = new JMenu("options");
		helpMenu = new JMenu("help");
		exit = new JMenuItem("exit");
		exit.addActionListener(menuHandler);
		randomize = new JCheckBoxMenuItem("randomize");
		randomize.addActionListener(menuHandler);
		rules = new JMenuItem("game rules");
		rules.addActionListener(menuHandler);
		about = new JMenuItem("about");
		about.addActionListener(menuHandler);
		
		fileMenu.add(exit);
		optionsMenu.add(randomize);
		helpMenu.add(rules);
		helpMenu.add(about);
		menuBar.add(fileMenu);
		menuBar.add(optionsMenu);
		menuBar.add(helpMenu);
		boardPage.setJMenuBar(menuBar);
		
		boardPage.setPreferredSize(new Dimension(totalX, totalY));
		
		ImageIcon title = new ImageIcon(properties.getTitle());
		JLabel titleLabel = new JLabel();
		titleLabel.setIcon(title);
		titleLabel.setBounds(titleX, titleY, TITLE_WIDTH, TITLE_HEIGHT);
		
		start = new JButton("start");
		start.setBounds(startX, startY, START_BUTTON_WIDTH, START_BUTTON_HEIGHT);
		start.addActionListener(handler);
		
		stop = new JButton("stop");
		stop.setBounds(stopX, stopY, STOP_BUTTON_WIDTH, STOP_BUTTON_HEIGHT);
		stop.addActionListener(handler);
		
		help = new JButton("help");
		help.setBounds(helpX, helpY, HELP_BUTTON_WIDTH, HELP_BUTTON_HEIGHT);
		help.setEnabled(false);
		help.addActionListener(handler);
		
		levelChooser = new JComboBox<Double>(properties.getLevelList());
		levelChooser.setBounds(chooserX, chooserY, LEVEL_CHOOSER_WIDTH, LEVEL_CHOOSER_HEIGHT);
		
		score = new JTextArea(EMPTY_DISPLAY);
		score.setBounds(scoreDisplayX, scoreDisplayY, SCORE_DISPLAY_WIDTH, SCORE_DISPLAY_HEIGHT);
		score.setEditable(false);
		
		JLabel scoreLabel = new JLabel("Score:");
		scoreLabel.setBounds(scoreLabelX, scoreLabelY, SCORE_LABEL_WIDTH, SCORE_LABEL_HEIGHT);
		
		time = new JTextArea(EMPTY_DISPLAY);
		time.setBounds(timeDisplayX, timeDisplayY, TIME_DISPLAY_WIDTH, TIME_DISPLAY_HEIGHT);
		time.setEditable(false);
		
		JLabel timeLabel = new JLabel("Elapsed time:");
		timeLabel.setBounds(timeLabelX, timeLabelY, TIME_LABEL_WIDTH, TIME_LABEL_HEIGHT);
		
		messages = new JTextArea();
		messages.setBounds(messageDisplayX, messageDisplayY, MESSAGE_DISPLAY_WIDTH, MESSAGE_DISPLAY_HEIGHT);
		messages.setEditable(false);
		
		JLabel messagesLabel = new JLabel("Info");
		messagesLabel.setBounds(messageLabelX, messageLabelY, MESSAGE_LABEL_WIDTH, MESSAGE_LABEL_HEIGHT);
		
		pane.add(gameBackgroundLabel);
		pane.add(titleLabel);
		pane.add(start);
		pane.add(stop);
		pane.add(help);
		pane.add(levelChooser);
		pane.add(scoreLabel);
		pane.add(score);
		pane.add(timeLabel);
		pane.add(time);
		pane.add(messagesLabel);
		pane.add(messages);
		
		pane.moveToFront(titleLabel);
		pane.moveToFront(start);
		pane.moveToFront(stop);
		pane.moveToFront(help);
		pane.moveToFront(levelChooser);
		pane.moveToFront(scoreLabel);
		pane.moveToFront(score);
		pane.moveToFront(timeLabel);
		pane.moveToFront(time);
		pane.moveToFront(messagesLabel);
		pane.moveToFront(messages);
		
		counter = 0;
		
		int size = WIDTH * HEIGHT;
		for(int x = 0; x < size; x++){
			placeLayeredButton(x);
		}
		
		pane.moveToBack(gameBackgroundLabel);
		
		boardPage.add(pane);
		boardPage.pack();
		boardPage.setVisible(true);
		levelEngine.setBackground(allBackgrounds);
		disableButtons();
	}
	
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == randomize){
				if(randomize.isSelected()){
					randomizeFlag = true;
					levelChooser.setEnabled(false);
					stop.setEnabled(false);
				}else{
					randomizeFlag = false;
					levelChooser.setEnabled(true);
					stop.setEnabled(true);
				}
			}else if(event.getSource() == exit){
				System.exit(0);
			}else if(event.getSource() == rules){
				JOptionPane.showMessageDialog(boardPage, 
						GAME_RULES, 
						"reflex_game rules",
						JOptionPane.INFORMATION_MESSAGE, 
						new ImageIcon(properties.getImageDir() + File.separator + "company.png"));
			}else if(event.getSource() == about) {
				JOptionPane.showMessageDialog(boardPage, 
						ABOUT, 
						"about", 
						JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(properties.getImageDir() + File.separator + "company.png"));
			}
		}
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			boolean found = false;
			int size = levelEngine.getTotalTargets();
			if(event.getSource() == start){
				doStart();
				stop.setEnabled(true);
				start.setEnabled(false);
			}else if(event.getSource() == stop){
				try {
					doStop(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(event.getSource() == help){
				if(randomizeFlag){
					randomHelp = true;
					randomPattern = false;
					patternProgress = 0;
					patternCounter1 = 0;
					patternCounter2 = 0;
				}else{
					showHelp = true;
				}
			}else{ // all other button actions (gameplay)
				try {
					doGameplay(size, found, event);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	private void placeLayeredButton(int column){
		background = new JLabel();
		String path = properties.getBackground();
		ImageIcon icon = new ImageIcon(path);
		background.setIcon(icon);
		background.setOpaque(true);
		
		int xcoord = BACKGROUND_WIDTH * (column % WIDTH) + (((column % WIDTH) + 1) * SPACE);
		int ycoord = (BACKGROUND_HEIGHT * counter) + ((counter + 1) * SPACE) + topHeight;
		background.setBounds(xcoord, ycoord, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		pane.add(background);
		allBackgrounds.add(background);
		
		middle = new JButton();
		path = properties.getMiddle(counter);
		icon = new ImageIcon(path);
		middle.setIcon(icon);
		
		int xcoord_button = xcoord + ((BACKGROUND_WIDTH - MIDDLE_WIDTH) / 2);
		int ycoord_button = ycoord + ((BACKGROUND_HEIGHT - MIDDLE_HEIGHT) / 2);
		middle.setBounds(xcoord_button, ycoord_button, MIDDLE_WIDTH, MIDDLE_HEIGHT);
		middle.addActionListener(handler);
		pane.add(middle);
		pane.moveToFront(middle);
		levelEngine.addMiddle(middle);
		
		center = new JButton();
		path = properties.getCenter(counter);
		icon = new ImageIcon(path);
		center.setIcon(icon);
		
		int xcoord_button2 = xcoord + ((BACKGROUND_WIDTH - CENTER_WIDTH) / 2);
		int ycoord_button2 = ycoord + ((BACKGROUND_HEIGHT - CENTER_HEIGHT) / 2);
		center.setBounds(xcoord_button2, ycoord_button2, CENTER_WIDTH + 2, CENTER_HEIGHT + 2);
		center.addActionListener(handler);
		pane.add(center);
		pane.moveToFront(center);
		levelEngine.addCenter(center);
		
		if((column + 1) % WIDTH == 0 && column != 0){
			counter++;
		}
	}
	
	public void init(){
		if(boardPage == null){
			createBoard();
		}else{
			boardPage.setVisible(true);
			if(!randomizeFlag){
				levelChooser.setEnabled(true);
			}
			level = 0;
			count = 0;
		}
	}

	@Override
	public void enable() {
		start.setEnabled(true);
		fileMenu.setEnabled(true);
		optionsMenu.setEnabled(true);
		helpMenu.setEnabled(true);
		if(!randomizeFlag){
			levelChooser.setEnabled(true);
		}
	}

	@Override
	public void initHighScores(hsProperties hsProps) {
		HighScores highScores = new HighScores(this);
		
		try {
			//balogger.logScore("", "");
			highScores.init(hsProps);
			pane.add(highScores);
			pane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initHighScores(String name, String rank, int score, hsProperties hsProps) {
		HighScores highScores = new HighScores(this);
		try {
			//balogger.logScore(name, "" + score);
			highScores.init(name, rank, score, hsProps);
			pane.add(highScores);
			pane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
