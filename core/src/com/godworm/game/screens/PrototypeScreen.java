package com.godworm.game.screens;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.godworm.game.Main;

public class PrototypeScreen extends MainScreen {

    private ShapeRenderer shapeRenderer;

    public PrototypeScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        shapeRenderer.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
        shapeRenderer.setTransformMatrix(stage.getBatch().getTransformMatrix());
    }
}
