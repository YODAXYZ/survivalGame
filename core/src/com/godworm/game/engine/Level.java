package com.godworm.game.engine;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Level {
    public Room rooms[][];
    public Room firstRoom;
    public int minX, maxX, minY, maxY;

    public Level() {
    }

    public void generate() {
        rooms = new Room[35][35];

        rooms[17][17] = new Room(13, 7);
        firstRoom = rooms[17][17];
        minX = 17;
        minY = 17;
        maxX = 17;
        maxY = 17;

        for (int i = 0; i < 7; i++) {
            Vector<Vector2> availables = new Vector<Vector2>();
            for (int x = 1; x < 35 - 1; x++) {
                for (int y = 1; y < 35 - 1; y++) {
                    if (rooms[x][y] != null)
                        continue;

                    int connectedTo = 0;
                    if (rooms[x][y - 1] != null)
                        connectedTo++;
                    if (rooms[x - 1][y] != null)
                        connectedTo++;
                    if (rooms[x + 1][y] != null)
                        connectedTo++;
                    if (rooms[x][y + 1] != null)
                        connectedTo++;

                    if (connectedTo != 1)
                        continue;

                    availables.add(new Vector2(x, y));
                }
            }
            Vector2 position = availables.elementAt(MathUtils.random(availables.size() - 1));

            int x = (int) position.x;
            int y = (int) position.y;

            rooms[x][y] = new Room(13, 7);
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (rooms[x][y] == null)
                    continue;

                if (rooms[x][y - 1] != null)
                    rooms[x][y].entities[rooms[x][y].width / 2][0] = new DummyDoor(rooms[x][y - 1]);
                if (rooms[x - 1][y] != null)
                    rooms[x][y].entities[0][rooms[x][y].height / 2] = new DummyDoor(rooms[x - 1][y]);

                if (rooms[x][y + 1] != null)
                    rooms[x][y].entities[rooms[x][y].width / 2][rooms[x][y].height - 1] = new DummyDoor(rooms[x][y + 1]);
                if (rooms[x + 1][y] != null)
                    rooms[x][y].entities[rooms[x][y].width - 1][rooms[x][y].height / 2] = new DummyDoor(rooms[x + 1][y]);

                if(rooms[x][y]==firstRoom)
                    continue;

                rooms[x][y].generate();
            }
        }
    }
}
