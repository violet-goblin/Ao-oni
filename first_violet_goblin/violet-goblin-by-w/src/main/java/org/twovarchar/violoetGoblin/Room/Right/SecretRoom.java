package org.twovarchar.violoetGoblin.Room.Right;

import org.twovarchar.violoetGoblin.Room.RightRoom;

public class SecretRoom extends RightRoom {
    private static int floor = 3;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        SecretRoom.floor = floor;
    }
}
