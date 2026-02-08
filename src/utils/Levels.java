/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package utils;

import java.util.ArrayList;

public class Levels {
		
	private ArrayList<String[]> level1 = new ArrayList<String[]>();
	private ArrayList<String[]> level2 = new ArrayList<String[]>();
	private ArrayList<String[]> level3 = new ArrayList<String[]>();
	private ArrayList<String[]> level4 = new ArrayList<String[]>();
	private ArrayList<String[]> level5 = new ArrayList<String[]>();
	private ArrayList<String[]> level6 = new ArrayList<String[]>();
	
	public Levels(){
		setLevel1();
		setLevel2();
		setLevel3();
		setLevel4();
		setLevel5();
		setLevel6();
	}
	
	public int getLevelMax(int level){
		if(level == 1){
			return level1.size();
		}else if(level == 2){
			return level2.size();
		}else if(level == 3){
			return level3.size();
		}else if(level == 4){
			return level4.size();
		}else if(level == 5){
			return level5.size();
		}else if(level == 6){
			return level6.size();
		}
		return -1;
	}
	
	private void setLevel1(){
		System.out.println("set level1");
		//(3,2), (3,3)
		level1.add(new String[]{"3", "2", "3", "3"});
		//(5,4), (6,4)
		level1.add(new String[]{"5", "4", "6", "4"});
		//(1,2), (1,1), (2,1)
		level1.add(new String[]{"1", "2", "1", "1", "2", "1"});
		//(5,1), (6,1), (6,2)
		level1.add(new String[]{"5", "1", "6", "1", "6", "2"});
		//(2,5), (3,4), (4,5)
		level1.add(new String[]{"2", "5", "3", "4", "4", "5"});
	}
	
	private void setLevel2(){
		//(3,1), (5,2), (5,3)
		level2.add(new String[]{"3", "1", "5", "2", "5", "3"});
		//(3,3), (5,5), (3,5)
		level2.add(new String[]{"3", "3", "5", "5", "3", "5"});
		//(2,1), (4,1), (4,3), (2,3)
		level2.add(new String[]{"2", "1", "4", "1", "4", "3", "2", "3"});
		//(3,2), (5,3), (3,4), (2,3)
		level2.add(new String[]{"3", "2", "5", "3", "3", "4", "2", "3"});
		//(4,5), (3,3), (3,2)
		level2.add(new String[]{"4", "5", "3", "3", "3", "2"});		
	}
	
	private void setLevel3(){
		//(3,2), (6,2), (6,4), (3,4)
		level3.add(new String[]{"3", "2", "6", "2", "6", "4", "3", "4"});
		//(4,1), (3,2), (3,4), (5,4)
		level3.add(new String[]{"4", "1", "3", "2", "3", "4", "5", "3"});
		//(1,2), (2,3), (3,2), (4,3), (5,2)
		level3.add(new String[]{"1", "2", "2", "3", "3", "2", "4", "3", "5", "2"});
		//(4,1), (5,2), (5,4), (3,4), (3,2)
		level3.add(new String[]{"4", "1", "5", "2", "5", "4", "3", "4", "3", "2"});
		//(3,1), (5,4), (4,5), (2,2)
		level3.add(new String[]{"3", "1", "5", "4", "4", "5", "2", "2"});
	}
	
	private void setLevel4(){
		//(6,4), (1,3), (6,3)
		level4.add(new String[]{"6", "4", "1", "3", "6", "3"});
		//(1,2), (3,5), (4,1)
		level4.add(new String[]{"1", "2", "3", "5", "4", "1"});
		//(1,1), (6,1), (6,3), (1,3)
		level4.add(new String[]{"1", "1", "6", "1", "6", "3", "1", "3"});
		//(3,1), (5,3), (3,5), (1,3)
		level4.add(new String[]{"3", "1", "5", "3", "3", "5", "1", "3"});
		//(1,2), (6,1), (1,1)
		level4.add(new String[]{"1", "2", "6", "1", "1", "1"});
	}
	
	private void setLevel5(){
		//(1,1), (6,1), (6,5), (1,5)
		level5.add(new String[]{"1", "1", "6", "1", "6", "5", "1", "5"});
		//(1,3), (2,5), (5,1), (6,3)
		level5.add(new String[]{"1", "3", "2", "5", "5", "1", "6", "3"});
		//(1,5), (6,4), (1,3), (6,2), (1,1)
		level5.add(new String[]{"1", "5", "6", "4", "1", "3", "6", "2", "1", "1"});
		//(6,1), (1,2), (6,3), (1,4), (6,5)
		level5.add(new String[]{"6", "1", "1", "2", "6", "3", "1", "4", "6", "5"});
		//(5,1), (6,2), (1,5), (3,1)
		level5.add(new String[]{"5", "1", "6", "2", "1", "5", "3", "1"});
	}
	
	private void setLevel6(){
		//(1,1), (6,5), (1,5), (6,1), (4,2)
		level6.add(new String[]{"1", "1", "6", "5", "1", "5", "6", "1", "4", "2"});
		//(1,3), (6,2), (1,4), (3,5), (4,1)
		level6.add(new String[]{"1", "3", "6", "2", "1", "4", "3", "5", "4", "1"});
		//(2,5), (3,5), (6,2), (1,1), (6,5), (2,4)
		level6.add(new String[]{"2", "5", "3", "5", "6", "2", "1", "1", "6", "5", "2", "4"});
		//(1,3), (6,2), (1,2), (6,3), (3,1), (4,5)
		level6.add(new String[]{"1", "3", "6", "2", "1", "2", "6", "3", "3", "1", "4", "5"});
		//(6,1), (5,1), (5,5), (6,5), (1,1), (2,1), (2,5), (1,5)
		level6.add(new String[]{"6", "1", "5", "1", "5", "5", "6", "5", "1", "1", "2", "1", "2", "5", "1", "5"});
	}
	
	public String[] getLevel1(int count){
		return level1.get(count);
	}
	
	public String[] getLevel2(int count){
		return level2.get(count);
	}
	
	public String[] getLevel3(int count){
		return level3.get(count);
	}
	
	public String[] getLevel4(int count){
		return level4.get(count);
	}
	
	public String[] getLevel5(int count){
		return level5.get(count);
	}
	
	public String[] getLevel6(int count){
		return level6.get(count);
	}
}