/**
 * @author wontzer
 * 
 * product of - ???
 * 2017
 */
package com.reflex_game.utils;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class CommonLevelEngine {

		//board animation
		protected int width;
		protected int height;
		
		//scripted levels
		protected Levels levels;
		protected ArrayList<JLabel> backgrounds;
		protected ArrayList<JButton> middles;
		protected ArrayList<JButton> centers;
		
		protected ArrayList<Integer> played;
		protected String[] pattern;
		protected int level;
		protected int count;
		
		//randomized levels
		protected int[][] patternQueue;
		protected int queuePosition = 0;
		protected boolean queueEmpty = true;
		
		//config
		protected final int QUEUE_SIZE = 3;
		protected final int COORDINATE = 2;
	
}
