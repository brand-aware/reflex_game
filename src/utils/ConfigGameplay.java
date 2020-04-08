/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

public class ConfigGameplay {
	
	protected final int MAX_MISS_ALLOWANCE = 2;
	protected final double CENTER_SCORE_MULTIPLIER = 1.25;
	protected final double CENTER_RANDOM_MULTIPLIER = 2.5;
	protected final double MIDDLE_SCORE_MULTIPLIER = 1;
	protected final double MIDDLE_RANDOM_MULTIPLIER = 2;
	
	protected final int PATTERN_DISPLAY = 6;
	protected final int PATTERN_WAIT = 2;
	protected final int RANDOM_DISPLAY = 6;
	protected final int RANDOM_DELAY = 0;
	protected final int MESSAGE_WAIT_INTERVAL = 5;
	protected final int HELP_DISPLAY_INTERVAL = 6;
	protected final int PRESET_SCORE_TIME_MODIFIER = 10;
	protected final int MAX_STAGES = 5;
	protected final int RANDOM_STAGE_MAX = 10;
	protected final int RANDOM_LEVEL_MAX = 10;
	protected final int RANDOM_LEVELUP_BONUS = 5;
	protected final int LEVEL_MAX = 6;
	
	
	protected final String OUTPUT_FORMAT = ".##";
	protected final String EMPTY_DISPLAY = "--";
	
	protected final String 	GAME_RULES = 
			"game rules:\n\n2 misses during any one stage ends the game.\n"
			+ "you may start from any stage and play from there."
			+ "\n\nat any point click \"help\" button for next move (to avoid a miss)."
			+ "\ncompleting the last stage, or losing randomize mode triggers a "
			+ "high score.\n\ntarget centers are wroth more points than the outside "
			+ "area.\nlevels 1.1 through 6.5 never change.";
	
	protected final String ABOUT =
			"product: reflex_game\n"
			+"2019 - ???, brand-aware\n\n"
			+"version 0.0.1\n"
			+"mike802@protonmail.com";
	
}
