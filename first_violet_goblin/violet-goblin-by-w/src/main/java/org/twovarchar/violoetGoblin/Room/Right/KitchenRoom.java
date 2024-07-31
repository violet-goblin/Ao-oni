package org.twovarchar.violoetGoblin.Room.Right;

import org.twovarchar.violoetGoblin.Room.RightRoom;

public class KitchenRoom extends RightRoom {
    private static int floor = 1;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        KitchenRoom.floor = floor;
    }
}
