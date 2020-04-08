/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

import java.io.File;

import core.Board;

public class Properties {
	
	private Board board;
	
	private String rootDir;
	private String title;
	private String gameBackground;
	private String company;
	
	private String background;
	private String backgroundHighlighted;
	
	private String highScores;
	private String completed;
	
	private String[] outsideColors;
	private String[] centerColors;
	
	public Properties(String root){
		rootDir = root;
		
		title = rootDir + File.separator + "img" + File.separator + "logo.png";
		background = rootDir + File.separator + "img" + File.separator + "background.png";
		backgroundHighlighted = rootDir + File.separator + "img" + File.separator + "background_highlighted.png";
		gameBackground = rootDir + File.separator + "img" + File.separator + "big_background.png";
		company = rootDir + File.separator + "img" + File.separator + "company.png";
		
		highScores = rootDir + File.separator + "high_scores.txt";
		completed = rootDir + File.separator + "completed.txt";
		
		outsideColors = new String[] {
				rootDir + File.separator + "img" + File.separator + "blue_middle.png",
				rootDir + File.separator + "img" + File.separator + "green_middle.png",
				rootDir + File.separator + "img" + File.separator + "orange_middle.png",
				rootDir + File.separator + "img" + File.separator + "yellow_middle.png",
				rootDir + File.separator + "img" + File.separator + "purple_middle.png"
		};
		
		centerColors = new String[] {
				rootDir + File.separator + "img" + File.separator + "blue_center.png",
				rootDir + File.separator + "img" + File.separator + "green_center.png",
				rootDir + File.separator + "img" + File.separator + "orange_center.png",
				rootDir + File.separator + "img" + File.separator + "yellow_center.png",
				rootDir + File.separator + "img" + File.separator + "purple_center.png"
		};
	}
	
	public String getRoot(){
		return rootDir;
	}
	public String getTitle(){
		return title;
	}
	public String getCompany(){
		return company;
	}
	public String getGameBackground(){
		return gameBackground;
	}
	public String getMiddle(int index){
		return outsideColors[index];
	}
	public String getCenter(int index){
		return centerColors[index];
	}
	public String getBackground(){
		return background;
	}
	public String getBackgroundHighlighted(){
		return backgroundHighlighted;
	}
	public String getHighScores(){
		return highScores;
	}
	public String getCompletedList(){
		return completed;
	}
	public Double[] getLevelList(){
		Double[] list = {1.1, 1.2, 1.3, 1.4, 1.5, 2.1, 2.2, 2.3, 2.4, 2.5, 3.1, 3.2, 3.3, 3.4, 3.5,
				4.1, 4.2, 4.3, 4.4, 4.5, 5.1, 5.2, 5.3, 5.4, 5.5, 6.1, 6.2, 6.3, 6.4, 6.5};
		return list;
	}
	public void setBoard(Board brd){
		board = brd;
	}
	public Board getBoard(){
		return board;
	}
	public String getImageDir(){
		return rootDir + File.separator + "img";
	}
}
