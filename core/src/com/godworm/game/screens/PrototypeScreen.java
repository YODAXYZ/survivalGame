package com.godworm.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.godworm.game.Main;

public class PrototypeScreen extends MainScreen {

    public static final float SPEED = 300f;
    private ShapeRenderer shapeRenderer;

    public PrototypeScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        shapeRenderer = new ShapeRenderer();
    }

    float x = 300, y = 300;

    @Override
    public void render(float delta) {
        float speedMul = 1.0f;
        if ((Gdx.input.isKeyPressed(Input.Keys.W) ^ Gdx.input.isKeyPressed(Input.Keys.S)) && (Gdx.input.isKeyPressed(Input.Keys.A) ^ Gdx.input.isKeyPressed(Input.Keys.D)))
            speedMul = (float) (Math.sqrt(2) / 2);

        if (Gdx.input.isKeyPressed(Input.Keys.W))
            y += delta * SPEED * speedMul;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            x -= delta * SPEED * speedMul;
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            y -= delta * SPEED * speedMul;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            x += delta * SPEED * speedMul;

        Vector2 mousePos = new Vector2(stage.getViewport().unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY())));

        super.render(delta);
        shapeRenderer.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
        shapeRenderer.setTransformMatrix(stage.getBatch().getTransformMatrix());

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0x80af49ff));
        shapeRenderer.rect(0, 0, 640, 480);

        shapeRenderer.setColor(new Color(0xf8c574ff));
        shapeRenderer.circle(x, y, 40, 1000);
        shapeRenderer.setColor(new Color(0x000000ff));
        shapeRenderer.circle(x - 30, y + 30, 20, 1000);
        shapeRenderer.circle(x + 30, y + 30, 20, 1000);
        shapeRenderer.setColor(new Color(0xf8c574ff));
        shapeRenderer.circle(x - 30, y + 30, 16, 1000);
        shapeRenderer.circle(x + 30, y + 30, 16, 1000);

        shapeRenderer.end();
    }
}
