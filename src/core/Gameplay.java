/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import highscores.NameInput;
import utils.UtilsBoard;

public class Gameplay extends UtilsBoard{
	
	protected boolean doCheckCenters(int size, boolean found, ActionEvent event) throws IOException{
		for(int x = 0; x < size; x++){
			JButton button = levelEngine.getCenter(x);
			if(button == event.getSource()){
				found = true;
				if(!randomizeFlag){
					if(levelEngine.checkPattern(x)){
						doScoreCenter();
					}else{
						doMissCenter();
					}
					break;
				}else{
					if(button == event.getSource()){
						found = true;
						int result = levelEngine.checkRandomPosition(x);
						if(result == -1){
							doMissRandomCenter();
						}else if(result == 0){
							doScoreRandomCenter();
						}else if(result == 1){
							doMissRandomCenter();
						}
						break;
					}
				}
			}
		}
		return found;
	}
	
	private synchronized void doScoreCenter(){
		messageSet = true;
		while(time.getText().compareTo("") == 0){
			
		}
		Double timeNow;
		if(time != null && time.getText().compareTo("--") != 0) {
			timeNow = Double.parseDouble(time.getText());
			Double scoreNow = timeLastScore - timeNow;
			Double previousScore = Double.parseDouble(score.getText());
		
			// center score: 1.25 - time diff
			Double total = (previousScore - scoreNow) + CENTER_SCORE_MULTIPLIER;
			DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
			score.setText(output.format(total));
			messages.setText("center - " + output.format(scoreNow));
		
			lastTime = System.currentTimeMillis();
			timeLastScore = timeNow;
		}
	}
	
	private synchronized void doScoreRandomCenter(){
		messageSet = true;
		while(time.getText().compareTo("") == 0){
			
		}
		Double timeNow;
		if(time != null && time.getText().compareTo("--") != 0) {
			timeNow = Double.parseDouble(time.getText());
			Double scoreNow = timeNow - timeLastScore;
			Double previousScore = Double.parseDouble(score.getText());
			
			// center score: 2.5 - time diff
			Double total = previousScore + (CENTER_RANDOM_MULTIPLIER - scoreNow);
			DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
			score.setText(output.format(total));
			messages.setText("center - " + output.format(scoreNow));
			
			lastTime = System.currentTimeMillis();
			timeLastScore = timeNow;
			count++;
			if(count == RANDOM_STAGE_MAX){
				doRandomCompleted();
			}
		}
	}
	
	private void doMissCenter() throws IOException{
		messages.setText("MISS");
		messageSet = true;
		miss++;
		if(miss == MAX_MISS_ALLOWANCE){
			doStop(true);
		}
	}
	
	private void doMissRandomCenter() throws IOException{
		messages.setText("MISS");
		randomMessage = true;
		miss++;
		if(miss == MAX_MISS_ALLOWANCE){
			double finalScore = Double.parseDouble(score.getText());
			score.setText(EMPTY_DISPLAY);
			doStop(true);
			try {
				nameInput = new NameInput(properties.getRoot(), board, PRODUCT_NAME, userDir);
				nameInput.setDescending();
				nameInput.init((int) finalScore);
				disable();
				pane.add(nameInput);
				pane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doCheckMiddles(int size, ActionEvent event) throws IOException{
		size = levelEngine.getTotalTargets();
		for(int y = 0; y < size; y++){
			JButton button = levelEngine.getMiddle(y);
			if(!randomizeFlag){
				if(button == event.getSource()){
					if(levelEngine.checkPattern(y)){
						doScoreMiddle();
					}else{
						doMissMiddle();
					}
				}
			}else{
				if(button == event.getSource()){
					int result = levelEngine.checkRandomPosition(y);
					if(result == -1){
						doMissRandomMiddle();
					}else if(result == 0){
						doScoreRandomMiddle();
					}else if(result == 1){
						doMissRandomMiddle();
					}
				}
			}
		}
	}
	
	private synchronized void doScoreMiddle(){
		messageSet = true;
		while(time.getText().compareTo("") == 0){
			
		}
		Double timeNow;
		if(time != null && time.getText().compareTo("--") != 0) {
			timeNow = Double.parseDouble(time.getText());
			Double scoreNow = timeLastScore - timeNow;
			Double previousScore = Double.parseDouble(score.getText());
			
			// middle score: 1 - time diff
			Double total = (previousScore - scoreNow) + MIDDLE_SCORE_MULTIPLIER;
			DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
			score.setText(output.format(total));
			messages.setText("middle - " + output.format(scoreNow));
			
			lastTime = System.currentTimeMillis();
			timeLastScore = timeNow;
		}
	}
	
	private synchronized void doScoreRandomMiddle(){
		randomMessage = true;
		while(time.getText().compareTo("") == 0){
			
		}
		Double timeNow;
		if(time != null && time.getText().compareTo("--") != 0) {
			timeNow = Double.parseDouble(time.getText());
			Double scoreNow = timeNow - timeLastScore;
			Double previousScore = Double.parseDouble(score.getText());
			
			// middle score 2 - time diff
			Double total = previousScore + (MIDDLE_RANDOM_MULTIPLIER - scoreNow);
			DecimalFormat output = new DecimalFormat(OUTPUT_FORMAT);
			score.setText(output.format(total));
			messages.setText("middle - " + output.format(scoreNow));
			
			lastTime = System.currentTimeMillis();
			timeLastScore = timeNow;
			count++;
			if(count == RANDOM_STAGE_MAX){
				doRandomCompleted();
			}
		}
	}
	
	private void doMissMiddle() throws IOException{
		messages.setText("MISS");
		messageSet = true;
		miss++;
		if(miss == MAX_MISS_ALLOWANCE){
			doStop(true);
		}
	}
	
	private void doMissRandomMiddle() throws IOException{
		messages.setText("MISS");
		randomMessage = true;
		miss++;
		if(miss == MAX_MISS_ALLOWANCE){
			double finalScore = Double.parseDouble(score.getText());
			score.setText(EMPTY_DISPLAY);
			doStop(true);
			
			try {
				nameInput = new NameInput(properties.getRoot(), board, PRODUCT_NAME, userDir);
				nameInput.init((int) finalScore);
				nameInput.setDescending();
				disable();
				pane.add(nameInput);
				pane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void doCompleted() throws IOException{
		//game_charter logging
		balogger.stopTimer();
		balogger.logScore("", score.getText());
		
		stopTimer();
		count++;
		disableButtons();
		miss = 0;
		if(count == MAX_STAGES){
			JOptionPane.showMessageDialog(boardPage, 
					"LEVEL COMPLETED",
					"next level",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(properties.getCompany()));
			count = 0;
			level++;
		}
		if(level < LEVEL_MAX){
			int levelDisplay = levelChooser.getSelectedIndex();
			levelChooser.setSelectedIndex(levelDisplay + 1);
			JOptionPane.showMessageDialog(boardPage, 
					"Get ready for:\nLevel: " + (level + 1) 
					+ " Stage: " + (count + 1), 
					"stage complete", 
					JOptionPane.INFORMATION_MESSAGE, 
					new ImageIcon(properties.getCompany()));
			enableButtons();
			playPattern = true;
		}else{
			playPattern = false;
			level = 0;
			count = 1;
			time.setText(EMPTY_DISPLAY);
			double finalScore = Double.parseDouble(score.getText());
			score.setText(EMPTY_DISPLAY);
			
			try {
				nameInput = new NameInput(properties.getRoot(), board, PRODUCT_NAME, userDir);
				nameInput.init((int) finalScore);
				nameInput.setDescending();
				disable();
				pane.add(nameInput);
				pane.moveToFront(nameInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void doRandomCompleted(){
		level++;
		count = 0;
		if(level < RANDOM_LEVEL_MAX){
			randomModifier -= RANDOM_LEVELUP_BONUS;
		}
	}
	
	protected void clearHighlight(){
		int size = allBackgrounds.size();
		for(int x = 0; x < size; x++){
			String path = properties.getBackground();
			ImageIcon image = new ImageIcon(path);
			allBackgrounds.get(x).setIcon(image);
		}
	}
	
	protected void doStop(boolean doLog) throws IOException{
		if(doLog) {
			balogger.stopTimer();
			balogger.logScore("", score.getText());
		}
		if(!randomizeFlag){
			started = false;
			playPattern = false;
			levelChooser.setEnabled(true);
			//levelChooser.setSelectedIndex(0);
			score.setText(EMPTY_DISPLAY);
			messages.setText(EMPTY_DISPLAY);
			time.setText(EMPTY_DISPLAY);
			levelEngine.reset();
			disableButtons();
			clearHighlight();
			patternProgress = 0;
			patternSet = false;
			playPattern = false;
			patternCounter1 = 0;
			patternCounter2 = 0;
			level = 0;
			count = 0;
			miss = 0;
			startCount = 0;
		}else{
			randomStarted = false;
			randomPattern = false;
			levelEngine.clearPattern();
			score.setText(EMPTY_DISPLAY);
			messages.setText(EMPTY_DISPLAY);
			time.setText(EMPTY_DISPLAY);
			patternCounter1 = 0;
			patternCounter2 = 0;
			disableButtons();
			clearHighlight();
			level = 0;
			miss = 0;
			startCount = 0;
			
			patternSet = false;
		}
		start.setEnabled(true);
		stop.setEnabled(false);
	}
	
	public void disable(){
		start.setEnabled(false);
		fileMenu.setEnabled(false);
		optionsMenu.setEnabled(false);
		helpMenu.setEnabled(false);
		levelChooser.setEnabled(false);
	}

}
