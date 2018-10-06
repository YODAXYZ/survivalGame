package com.godworm.game.engine;

public class DummyDoor extends Entity {
    private Room room;

    public DummyDoor(Room room) {
        this.room = room;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    public Room getRoom() {
        return room;
    }
}
