package com.godworm.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.godworm.game.screens.StartingMenuScreen;

public class Main extends Game {

    private AssetManager assetManager;
    private Music music;
    @Override
    public void create() {
        assetManager = new AssetManager();
        assetManager.load("skin/craftacular-ui.json", Skin.class);
        assetManager.finishLoading();
        setScreen(new StartingMenuScreen(this));

        music = Gdx.audio.newMusic(Gdx.files.internal("song/moonman.mp3"));
        music.setLooping(true);
        music.setVolume(1.0f);
        music.play();

    }

    public AssetManager getAssetManager() {
        return assetManager;
    }
}
