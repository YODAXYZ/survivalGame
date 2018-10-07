package com.godworm.game.engine;

import com.badlogic.gdx.math.MathUtils;

public class Room {
    public final int height;
    public final int width;
    public Entity entities[][];

    public Room(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new Entity[this.width][this.height];
    }

    public void generate() {
        for (int i = MathUtils.random(2, 4); i >= 0; i--) {
            int x = MathUtils.random(width - 1);
            int y = MathUtils.random(height - 1);
            while (entities[x][y] != null)//bad practice
            {
                x = MathUtils.random(width - 1);
                y = MathUtils.random(height - 1);
            }
            entities[x][y] = new DummyEnemy();
        }

        for (int i = MathUtils.random(0, 2); i >= 0; i--) {
            int x = MathUtils.random(width - 1);
            int y = MathUtils.random(height - 1);
            while (entities[x][y] != null)//bad practice
            {
                x = MathUtils.random(width - 1);
                y = MathUtils.random(height - 1);
            }
            entities[x][y] = new DummyWall();
        }
    }
}
