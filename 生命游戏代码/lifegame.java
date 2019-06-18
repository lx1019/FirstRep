package ÉúÃüÓÎÏ·;

import java.util.*;

public class lifegame {

	public static void main(String[] args) {
		
		Map map = new Map();
		Timer timer = new Timer();
        TimerTask  task = new TimerTask (){
        	public void run() {
           	    map.changeState(); 
                map.repaintMap();
            }
        };
        timer.schedule (task, 1000L, 1000L);
	}
	
}
