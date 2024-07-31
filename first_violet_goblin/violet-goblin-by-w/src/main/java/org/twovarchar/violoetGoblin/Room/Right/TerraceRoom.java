package org.twovarchar.violoetGoblin.Room.Right;

import org.twovarchar.violoetGoblin.Room.RightRoom;

public class TerraceRoom extends RightRoom {
    private static int floor = 2;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        TerraceRoom.floor = floor;
    }
}
