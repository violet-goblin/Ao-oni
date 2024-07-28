package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class TerraceRoom2F implements Room {
    private final String[][] room = {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"ㅁ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};

    @Override
    public String[][] getRoomMap() {
        return this.room;
    }

    @Override
    public String getRoomName() {
        return "Terrace Room(2F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.TERRACE_ROOM_2F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        if (curDoor.equals("5-0")) {
            roomObj.setRoom(new GuestRoom2F());
            roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
            roomObj.setLoc(new int[]{5, 9});
        }
        return roomObj;
    }
}
