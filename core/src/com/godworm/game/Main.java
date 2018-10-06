package com.godworm.game;

import com.badlogic.gdx.Game;
import com.godworm.game.screens.MainMenuScreen;

public class Main extends Game {

	@Override
	public void create() {
		setScreen(new MainMenuScreen(this));
	}
}
