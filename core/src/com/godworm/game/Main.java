package com.godworm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.godworm.game.screens.StartingMenuScreen;

public class Main extends Game {

    private AssetManager assetManager;

    @Override
    public void create() {
        assetManager = new AssetManager();
        setScreen(new StartingMenuScreen(this));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
