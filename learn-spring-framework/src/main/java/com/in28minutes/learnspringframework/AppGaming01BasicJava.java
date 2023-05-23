package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PackmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class AppGaming01BasicJava {

	public static void main(String[] args) {
		
		//var game=new MarioGame();
		var game=new PackmanGame(); 
		//1: object creation
		//var game=new SuperContraGame();
		var gameRunner=new GameRunner(game); 
		///2: object creation+ wiring of dependencies
		//Game is dependency of game runner
		gameRunner.run();

	}

}
