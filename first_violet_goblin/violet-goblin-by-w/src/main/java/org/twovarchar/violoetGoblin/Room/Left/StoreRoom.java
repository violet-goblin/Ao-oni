package org.twovarchar.violoetGoblin.Room.Left;

import org.twovarchar.violoetGoblin.Room.LeftRoom;

public class StoreRoom extends LeftRoom {
    private static int floor = 2;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        StoreRoom.floor = floor;
    }
}
