/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import utils.CommonLevelEngine;
import utils.Levels;

public class LevelEngine extends CommonLevelEngine{
		
	public LevelEngine(int x, int y, Levels lvls){
		width = x;
		height = y;
		levels = lvls;
		
		backgrounds = new ArrayList<JLabel>();
		middles = new ArrayList<JButton>();
		centers = new ArrayList<JButton>();
		played = new ArrayList<Integer>();
		
		patternQueue = new int[QUEUE_SIZE][COORDINATE];
	}
	
	public void addMiddle(JButton button){
		middles.add(button);
	}
	public JButton getMiddle(int index){
		return middles.get(index);
	}
	public void enableMiddle(int index){
		middles.get(index).setEnabled(true);
	}
	public void disableMiddle(int index){
		middles.get(index).setEnabled(false);
	}
	
	public void addCenter(JButton button){
		centers.add(button);
	}
	public JButton getCenter(int index){
		return centers.get(index);
	}
	public void enableCenter(int index){
		centers.get(index).setEnabled(true);
	}
	public void disableCenter(int index){
		centers.get(index).setEnabled(false);
	}
	
	//animation tooling
	public void setBackground(ArrayList<JLabel> background){
		backgrounds = background;
	}
	
	public JLabel getBackground(int x){
		return backgrounds.get(x);
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getTotalTargets(){
		return centers.size();
	}
	
	//pre-programmed level pattern tooling
	public void setPattern(int lvl, int cnt){
		level = lvl;
		count = cnt;
		pattern = getPattern();
	}
	
	public String[] getPattern(){
		String[] newPattern = null;
		if(level == 0){
			newPattern = levels.getLevel1(count);
		}else if(level == 1){
			newPattern = levels.getLevel2(count);
		}else if(level == 2){
			newPattern = levels.getLevel3(count);
		}else if(level == 3){
			newPattern = levels.getLevel4(count);
		}else if(level == 4){
			newPattern = levels.getLevel5(count);
		}else if(level == 5){
			newPattern = levels.getLevel6(count);
		}
		
		return newPattern;
	}
	
	public boolean checkPattern(int index){
		if(pattern != null){
			int position1 = (index % width) + 1;
			int position2 = (int)(Math.floor(index / width) + 1);
			int next = played.size();
			
			String data = pattern[next];
			int pattern1 = Integer.parseInt(data);
			data = pattern[next + 1];
			int pattern2 = Integer.parseInt(data);
			if(pattern1 == position1 &&
					pattern2 == position2){
				played.add(position1);
				played.add(position2);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public Integer[] getPatternPosition(){
		int next = played.size();
		String xCoord = pattern[next];
		String yCoord = pattern[next + 1];
		Integer[] position = new Integer[2];
		position[0] = Integer.parseInt(xCoord);
		position[1] = Integer.parseInt(yCoord);
		return position;
	}
	
	public boolean completed(){
		if(played != null && pattern != null){
			if(played.size() == pattern.length){
				played = new ArrayList<Integer>();
				return true;
			}
		}
		return false;
	}
	
	public int getLevel(){
		return level;
	}
	public int getSection(){
		return count;
	}
	
	public void reset(){
		played = new ArrayList<Integer>();
	}
	
	
	//tools for randomized levels/gameplay
	public int[] getRandomCoordinate(){
		int[] coordinate = new int[2];
		// to keep coordinate system consistent
		int firstCoordinate = (int)(Math.random() * width)+1;
		coordinate[0] = firstCoordinate;
		int secondCoordinate = (int)(Math.random() * height)+1;
		coordinate[1] = secondCoordinate;
		
		return coordinate;
	}
	
	public boolean addCoordinateToRandomQueue(int[] coordinate){
		if(queuePosition < QUEUE_SIZE){
			patternQueue[queuePosition] = coordinate;
			queuePosition++;
			queueEmpty = false;
			return true;
		}
		return false;
	}
	
	public int checkRandomPosition(int index){
		if(!queueEmpty){
			int position1 = (index % width) + 1;
			int position2 = (int)(Math.floor(index / width) + 1);
			if(patternQueue[0][0] == position1){
				if(patternQueue[0][1] == position2){
					dequeue();
					return 0;
				}
			}
		}else{
			return 1;
		}
		return -1;
	}
	
	private void dequeue(){
		int[] holder;
		for(int x = 0; x < queuePosition; x++){
			if(x + 1 < queuePosition){
				holder = patternQueue[x + 1];
				patternQueue[x] = holder;
			}
		}
		queuePosition--;
		if(queuePosition == 0){
			queueEmpty = true;
		}
	}
	
	public int[] getRandomNext(int index){
		if(!queueEmpty){
			if(index < queuePosition){
				return patternQueue[index];
			}
		}
		return null;
	}
	
	public int[] getRandomDisplayNext(){
		if(!queueEmpty){
			return patternQueue[queuePosition - 1];
		}
		return null;
	}
	
	public boolean randomFull(){
		return queuePosition == QUEUE_SIZE;
	}
	
	public void clearPattern(){
		patternQueue = new int[QUEUE_SIZE][COORDINATE];
		queuePosition = 0;
		queueEmpty = true;
	}
}
