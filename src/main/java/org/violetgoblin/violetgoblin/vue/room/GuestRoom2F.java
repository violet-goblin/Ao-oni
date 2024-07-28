package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class GuestRoom2F implements Room {
    private final String[][] room = {{"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"ㅁ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "ㅁ"}
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
        return "Guest Room(2F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.GUEST_ROOM_2F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        switch (curDoor) {
            case "5-10":
                roomObj.setRoom(new TerraceRoom2F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 1});
                return roomObj;
            case "0-5":
                roomObj.setRoom(new AtticRoom3F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{9, 5});
                return roomObj;
            case "5-0":
                roomObj.setRoom(new StoreRoom2F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 9});
                return roomObj;
            case "10-5":
                roomObj.setRoom(new MasterRoom1F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{1, 5});
        }
        return roomObj;
    }
}
