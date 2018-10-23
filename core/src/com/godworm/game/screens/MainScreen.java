package com.godworm.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.godworm.game.Main;

public abstract class MainScreen implements Screen {
    public final AssetManager assetManager;
    public final Main main;
    public Stage stage;

    public MainScreen(Main main) {
        this.main = main;
        assetManager = main.getAssetManager();
    }

    public int getWidth() {
        return 640;
    }

    public int getHeight() {
        return 480;
    }

    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(getWidth(), getHeight()));
        Gdx.input.setInputProcessor(stage); //to make Gdx send input events to our stage
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
