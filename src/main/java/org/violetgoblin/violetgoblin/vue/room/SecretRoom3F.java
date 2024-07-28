package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class SecretRoom3F implements Room {
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
        return "Secret Room(3F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.SECRET_ROOM_3F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        if (curDoor.equals("5-0")) {
            roomObj.setRoom(new AtticRoom3F());
            roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
            roomObj.setLoc(new int[]{5, 9});
        }
        return roomObj;
    }
}
