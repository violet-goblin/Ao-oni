package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class AtticRoom3F implements Room {
    private String[][] room = {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "ㅁ"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}};

    @Override
    public String[][] getRoomMap() {
        return this.room;
    }

    @Override
    public String getRoomName() {
        return "Attic Room(3F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.ATTIC_ROOM_3F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        switch (curDoor) {
            case "5-10":
                roomObj.setRoom(new SecretRoom3F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 1});
                return roomObj;
            case "10-5":
                roomObj.setRoom(new GuestRoom2F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{1, 5});
        }
        return roomObj;
    }
}
