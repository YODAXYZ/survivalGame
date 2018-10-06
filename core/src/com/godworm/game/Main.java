package com.godworm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.godworm.game.screens.MainMenuScreen;

public class Main extends Game {

    private AssetManager assetManager;

    @Override
    public void create() {
        assetManager = new AssetManager();
        assetManager.load("skin/craftacular-ui.json", Skin.class);
        assetManager.finishLoading();
        setScreen(new MainMenuScreen(this));
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
