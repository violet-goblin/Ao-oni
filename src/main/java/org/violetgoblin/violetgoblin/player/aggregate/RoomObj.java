package org.violetgoblin.violetgoblin.player.aggregate;

import org.violetgoblin.violetgoblin.vue.room.Room;

public class RoomObj {
    private Room room;
    private String roomName;
    private int[] loc;

    public RoomObj(Room room, String roomName, int[] loc) {
        this.room = room;
        this.roomName = roomName;
        this.loc = loc;
    }

    public void changeRoom(Room newRoom, String newRoomName, int[] curDoorLoc) {
        this.room = newRoom;
        this.roomName = newRoomName;
        this.loc[0] = curDoorLoc[0];
        this.loc[1] = curDoorLoc[1];
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }

    public Room getRoomObj() {
        return room;
    }

    public String getRoomName() {
        return roomName;
    }

    public int[] getLoc() {
        return loc;
    }
}
