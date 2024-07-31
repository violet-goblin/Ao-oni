package org.twovarchar.violoetGoblin.Room.Left;

import org.twovarchar.violoetGoblin.Room.LeftRoom;

public class LaboratoryRoom extends LeftRoom {
    private static int floor = -1;

    public static int getFloor() {
        return floor;
    }

    public static void setFloor(int floor) {
        LaboratoryRoom.floor = floor;
    }
}
