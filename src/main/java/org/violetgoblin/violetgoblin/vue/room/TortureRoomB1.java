package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class TortureRoomB1 implements Room {
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
        return "Torture Room(B1)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.TORTURE_ROOM_B1;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        if (curDoor.equals("5-0")) {
            roomObj.setRoom(new HallwayRoomB1());
            roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
            roomObj.setLoc(new int[]{5, 9});
        }
        return roomObj;
    }
}
