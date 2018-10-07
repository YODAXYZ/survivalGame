package com.godworm.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.godworm.game.Main;
import com.godworm.game.engine.DummyDoor;
import com.godworm.game.engine.DummyEnemy;
import com.godworm.game.engine.DummyWall;
import com.godworm.game.engine.Level;
import com.godworm.game.engine.Room;

public class PrototypeScreen extends MainScreen {

    private ShapeRenderer shapeRenderer;
    private Level level;
    private Room room;

    public PrototypeScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        shapeRenderer = new ShapeRenderer();
        level = new Level();

        generate();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.justTouched())
            generate();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            if (room.entities[0][room.height / 2] instanceof DummyDoor)
                room = ((DummyDoor) room.entities[0][room.height / 2]).getRoom();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            if (room.entities[room.width - 1][room.height / 2] instanceof DummyDoor)
                room = ((DummyDoor) room.entities[room.width - 1][room.height / 2]).getRoom();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            if (room.entities[room.width / 2][0] instanceof DummyDoor)
                room = ((DummyDoor) room.entities[room.width / 2][0]).getRoom();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            if (room.entities[room.width / 2][room.height - 1] instanceof DummyDoor)
                room = ((DummyDoor) room.entities[room.width / 2][room.height - 1]).getRoom();
        }


        super.render(delta);
        shapeRenderer.setProjectionMatrix(stage.getBatch().getProjectionMatrix());
        shapeRenderer.setTransformMatrix(stage.getBatch().getTransformMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BROWN);
        float width = 640.0f/room.width;
        shapeRenderer.rect(0, 0, room.width * width, room.height * width);


        for (int x = 0; x < room.width; x++) {
            for (int y = 0; y < room.height; y++) {
                if (room.entities[x][y] == null)
                    continue;
                if (room.entities[x][y] instanceof DummyEnemy)
                    shapeRenderer.setColor(Color.RED);
                if (room.entities[x][y] instanceof DummyWall)
                    shapeRenderer.setColor(Color.GRAY);
                if (room.entities[x][y] instanceof DummyDoor)
                    shapeRenderer.setColor(Color.YELLOW);
                shapeRenderer.rect(x * width, y * width, width, width);
            }
        }

        for (int x = level.minX; x <= level.maxX; x++) {
            for (int y = level.minY; y <= level.maxY; y++) {
                if (level.rooms[x][y] == null)
                    continue;
                shapeRenderer.setColor(1, 1, 1, 0.5f);

                if (level.rooms[x][y] == room)
                    shapeRenderer.setColor(1, 1, 0, 0.5f);

                shapeRenderer.rect((x - level.minX) * 20, room.height * width + (y - level.minY) * 20-(level.maxY-level.minY+1)*20, 20, 20);
            }
        }


        shapeRenderer.end();
    }

    private void generate() {
        level.generate();
        level.generate();
        room = level.firstRoom;
    }
}
