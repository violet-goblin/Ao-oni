package org.twovarchar.violoetGoblin.Room.Left;

import org.twovarchar.violoetGoblin.Room.LeftRoom;

public class MainRoom extends LeftRoom {
    private static int floor = 1;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        MainRoom.floor = floor;
    }
}
