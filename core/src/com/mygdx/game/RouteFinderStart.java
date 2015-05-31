package com.mygdx.game;

import java.io.IOException;
import com.badlogic.gdx.Game;
import com.mygdx.game.MenuScreen;

public class RouteFinderStart extends Game {
	
	@Override
	public void create() {
		try {
			setScreen(new MenuScreen());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
