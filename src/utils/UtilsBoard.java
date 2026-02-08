/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

public class UtilsBoard extends CommonBoard{
	
	public void disableButtons(){
		help.setEnabled(false);
		int size = levelEngine.getTotalTargets();
		for(int x = 0; x < size; x++){
			levelEngine.disableCenter(x);
		}
		for(int y = 0; y < size; y++){
			levelEngine.disableMiddle(y);
		}
	}
	
	public void enableButtons(){
		int size = levelEngine.getTotalTargets();
		for(int x = 0; x < size; x++){
			levelEngine.enableCenter(x);
		}
		for(int y = 0; y < size; y++){
			levelEngine.enableMiddle(y);
		}
	}
	
	public void startTimer(){
		lastTime = System.currentTimeMillis();
		timeLastScore = scoreStart;
		time.setText("" + scoreStart);
		score.setText("" + (Double.parseDouble(score.getText()) 
				+ PRESET_SCORE_TIME_MODIFIER));
		started = true;
	}
	
	public void startRandomTimer(){
		lastTime = System.currentTimeMillis();
		timeLastScore = 0;
		time.setText("0");
		score.setText("0");
		randomStarted = true;
	}
	
	protected void stopTimer(){
		timeLastScore = 0;
		time.setText("--");
		started = false;
	}

}
