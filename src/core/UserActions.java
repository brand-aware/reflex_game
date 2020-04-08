/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UserActions extends Gameplay{
	
	//animation tooling
	public void doMove(){
		if(!randomizeFlag){
			if(showHelp){
				doHelp();
			}
			if(playPattern){
				doPlayPattern();
			}
			if(messageSet){
				if(messageCounter >= MESSAGE_WAIT_INTERVAL){
					messages.setText("");
					messageSet = false;
					messageCounter = 0;
				}else{
					messageCounter++;
				}
			}
			if(started){
				if(startCount > 0){
					updateTime();
				}else{
					startCount++;
				}
			}
		}else{
			if(randomHelp){
				doRandomHelp();
			}
			if(randomPattern){
				doRandomPattern();
			}
			if(randomMessage){
				if(messageCounter >= MESSAGE_WAIT_INTERVAL){	
					messages.setText("");
					randomMessage = false;
					messageCounter = 0;
				}else{
					messageCounter++;
				}
			}
			if(randomStarted){
				if(startCount > 0){
					randomUpdateTime();
				}else{
					startCount++;
				}
			}
		}
	}
	
	protected void doHelp(){
		Integer[] helpPosition = levelEngine.getPatternPosition();
		int xcoord = helpPosition[0];
		int ycoord = helpPosition[1];
		
		int index = ((ycoord - 1) * levelEngine.getWidth()) 
				+ (xcoord - 1);
		String path = properties.getBackgroundHighlighted();
		ImageIcon icon = new ImageIcon(path);
		JLabel background = levelEngine.getBackground(index);
		background.setIcon(icon);
		
		if(patternCounter1 > HELP_DISPLAY_INTERVAL){
			path = properties.getBackground();
			icon = new ImageIcon(path);
			levelEngine.getBackground(index).setIcon(icon);
			patternCounter1 = 0;
			showHelp = false;
		}else{
			patternCounter1++;
		}
	}
	
	protected void doRandomHelp(){
		int[] helpPosition = levelEngine.getRandomNext(patternProgress);
		if(helpPosition != null){
			int xcoord = helpPosition[0];
			int ycoord = helpPosition[1];
			
			int index = ((ycoord - 1) * levelEngine.getWidth())
					+ (xcoord - 1);
			
			if(patternCounter1 <= HELP_DISPLAY_INTERVAL){
				String path = properties.getBackgroundHighlighted();
				ImageIcon icon = new ImageIcon(path);
				JLabel background = levelEngine.getBackground(index);
				background.setIcon(icon);
				patternCounter1++;
			}else if(patternCounter1 > HELP_DISPLAY_INTERVAL){
				String path = properties.getBackground();
				ImageIcon icon = new ImageIcon(path);
				levelEngine.getBackground(index).setIcon(icon);
				if(patternCounter2 > PATTERN_WAIT){
					patternCounter1 = 0;
					patternCounter2 = 0;
					patternProgress++;
				}else{
					patternCounter2++;
				}
			}
		}else{
			patternProgress = 0;
			randomHelp = false;
			randomPattern = true;
		}
	}
	
	protected void doPlayPattern(){
		if(!patternSet){
			startTimer();
			levelEngine.setPattern(level, count);
			patternSet = true;
		}
		String[] pattern = levelEngine.getPattern();
		int length = pattern.length;
		if(patternProgress < length){
			String coordinate = pattern[patternProgress];
			int xcoord = Integer.parseInt(coordinate);
			coordinate = pattern[patternProgress + 1];
			int ycoord = Integer.parseInt(coordinate);
			
			int index = ((ycoord - 1) * levelEngine.getWidth()) 
					+ (xcoord - 1);
			if(patternCounter1 <= PATTERN_DISPLAY){
				String path = properties.getBackgroundHighlighted();
				ImageIcon icon = new ImageIcon(path);
				JLabel background = levelEngine.getBackground(index);
				background.setIcon(icon);
				patternCounter1++;
			
			}else if(patternCounter1 > PATTERN_DISPLAY){
				String path = properties.getBackground();
				ImageIcon icon = new ImageIcon(path);
				levelEngine.getBackground(index).setIcon(icon);
				
				if(patternCounter2 > PATTERN_WAIT){
					patternProgress+=2;
					patternCounter1 = 0;
					patternCounter2 = 0;
				}else{
					patternCounter2++;
				}
			}
		}else{
			help.setEnabled(true);
			patternProgress = 0;
			playPattern = false;
			patternSet = false;
		}
	}
	
	protected void doRandomPattern(){
		if(!patternSet){
			startRandomTimer();
			int[] coordinate = levelEngine.getRandomCoordinate();
			levelEngine.addCoordinateToRandomQueue(coordinate);
			patternSet = true;
			randomModifier = 25;
		}else {
			int[] coordinate;
			
			if(patternCounter1 == 0){
				coordinate = levelEngine.getRandomDisplayNext();
				if(coordinate != null){
					displayPosition = (coordinate[1] - 1) * levelEngine.getWidth()
							+ (coordinate[0] - 1);
					String path = properties.getBackgroundHighlighted();
					ImageIcon icon = new ImageIcon(path);
					JLabel background = levelEngine.getBackground(displayPosition);
					background.setIcon(icon);
					patternCounter1++;
				}
			}else if(patternCounter1 <= (RANDOM_DISPLAY + randomModifier)){
				patternCounter1++;
			}else if(patternCounter1 > PATTERN_DISPLAY && displayPosition > -1){
				String path = properties.getBackground();
				ImageIcon icon = new ImageIcon(path);
				levelEngine.getBackground(displayPosition).setIcon(icon);
					
				if(patternCounter2 > PATTERN_WAIT){
					if(!levelEngine.randomFull()){
						coordinate = levelEngine.getRandomCoordinate();
						levelEngine.addCoordinateToRandomQueue(coordinate);
						patternCounter1 = 0;
						patternCounter2 = 0;
						displayPosition = -1;
					}else{
						patternCounter2 = 0 - RANDOM_DELAY - randomLevelPenalty;
					}
				}else{
					patternCounter2++;
				}
			}
		}
	}
	
	protected synchronized void updateTime(){
		Long currentTime = System.currentTimeMillis();
		String timeText = time.getText();
		if(timeText.compareTo(EMPTY_DISPLAY) == 0){
			timeText = "0";
		}
		Double previous;
		if(timeText != null) {
			previous = Double.parseDouble(timeText);
			Long difference = currentTime - lastTime;
			double newTime = previous - (difference * .001);
			DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
			time.setText(output.format(newTime));
			lastTime = currentTime;
		}
	}
	
	protected void randomUpdateTime(){
		Long currentTime = System.currentTimeMillis();
		String timeText = time.getText();
		if(timeText.compareTo(EMPTY_DISPLAY) == 0){
			timeText = "0";
		}
		Double previous = Double.parseDouble(timeText);
		Long difference = currentTime - lastTime;
		double newTime = previous + (difference * .001);
		DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
		time.setText(output.format(newTime));
		lastTime = currentTime;
	}
	
	//interactive tooling
	protected void doStart(){
		balogger.startTimer();
		if(!randomizeFlag){
			int index = levelChooser.getSelectedIndex();
			level = (int)(index / MAX_STAGES);
			count = index % MAX_STAGES;
			
			score.setText("0");
			enableButtons();
			JOptionPane.showMessageDialog(boardPage, 
					"get ready for:\nLevel: " 
					+ (level + 1) + " Stage: " + (count + 1),
					"start new level",
					JOptionPane.INFORMATION_MESSAGE, 
					new ImageIcon(properties.getImageDir() + File.separator + "company.png"));
			levelChooser.setEnabled(false);
			playPattern = true;
		}else{
			level = 1;
			enableButtons();
			JOptionPane.showMessageDialog(boardPage, 
					"get ready for continuous random pattern", 
					"game start", 
					JOptionPane.INFORMATION_MESSAGE, 
					new ImageIcon(properties.getImageDir() + File.separator + "company.png"));
			help.setEnabled(true);
			score.setText("0");
			randomPattern = true;
		}
	}
	
	public void doGameplay(int size, boolean found, ActionEvent event) throws IOException{
		found = doCheckCenters(size, found, event);
		if(!found){
			doCheckMiddles(size, event);
		}
		if(levelEngine.completed()){
			doCompleted();
		}
	}

}
