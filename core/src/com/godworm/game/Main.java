package com.godworm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.godworm.game.screens.MainMenuScreen;

public class Main extends Game {

    private AssetManager assetManager;

    @Override
    public void create() {
        assetManager = new AssetManager();
        setScreen(new MainMenuScreen(this));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
