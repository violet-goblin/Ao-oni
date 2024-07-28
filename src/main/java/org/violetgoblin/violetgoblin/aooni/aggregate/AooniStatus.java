package org.violetgoblin.violetgoblin.aooni.aggregate;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;
import org.violetgoblin.violetgoblin.player.service.PlayerService;
import org.violetgoblin.violetgoblin.vue.room.Room;

import java.util.Arrays;

public class AooniStatus {
    private RoomObj room;
    private String roomName;
    private int[] loc;

    public AooniStatus() {
    }

    public AooniStatus(RoomObj room, String roomName, int[] loc) {
        this.room = room;
        this.roomName = roomName;
        this.loc = loc;
    }

    public RoomObj getRoom() {
        return room;
    }

    public void setRoom(RoomObj room) {
        this.room = room;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int[] getLoc() {
        return loc;
    }

    public void setLoc(int[] loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "AooniStatus{" +
                "room=" + room +
                ", roomName='" + roomName + '\'' +
                ", loc=" + Arrays.toString(loc) +
                '}';
    }
}
