/**
 * @author wontzer
 * 
 * product of - ???
 * 2017
 */
package com.reflex_game.core;

import com.reflex_game.utils.Properties;

public class Mover implements Runnable{
	
	Properties properties;
	
	public Mover(Properties prop){
		properties = prop;
	}

	@Override
	public void run() {
		while(true){			
			try {
				Thread.sleep(71);
				properties.getBoard().doMove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			

		}
	}
}
