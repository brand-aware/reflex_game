/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

import java.io.File;
import java.net.URL;

import core.Board;

public class Properties {
	
	private Board board;
	
	private String rootDir;
	private URL title;
	private URL gameBackground;
	private URL company;
	
	private URL background;
	private URL backgroundHighlighted;
	
	private String completed;
	
	private URL[] outsideColors;
	private URL[] centerColors;
	
	public Properties(String root){
		rootDir = root;
		
		title = getClass().getResource("/img/logo.png");
		background = getClass().getResource("/img/background.png");
		backgroundHighlighted = getClass().getResource("/img/background_highlighted.png");
		gameBackground = getClass().getResource("/img/big_background.png");
		company = getClass().getResource("/img/company.png");
		
		completed = rootDir + File.separator + "completed.txt";
		
		outsideColors = new URL[] {
				getClass().getResource("/img/blue_middle.png"),
				getClass().getResource("/img/green_middle.png"),
				getClass().getResource("/img/orange_middle.png"),
				getClass().getResource("/img/yellow_middle.png"),
				getClass().getResource("/img/purple_middle.png")
		};
		
		centerColors = new URL[] {
				getClass().getResource("/img/blue_center.png"),
				getClass().getResource("/img/green_center.png"),
				getClass().getResource("/img/orange_center.png"),
				getClass().getResource("/img/yellow_center.png"),
				getClass().getResource("/img/purple_center.png")
		};
	}
	
	public String getRoot(){
		return rootDir;
	}
	public URL getTitle(){
		return title;
	}
	public URL getCompany(){
		return company;
	}
	public URL getGameBackground(){
		return gameBackground;
	}
	public URL getMiddle(int index){
		return outsideColors[index];
	}
	public URL getCenter(int index){
		return centerColors[index];
	}
	public URL getBackground(){
		return background;
	}
	public URL getBackgroundHighlighted(){
		return backgroundHighlighted;
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
