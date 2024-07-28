package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class KitchenRoom1F implements Room {
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
        return "Kitchen Room(1F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.KITCHEN_ROOM_1F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        if (curDoor.equals("5-0")) {
            roomObj.setRoom(new MasterRoom1F());
            roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
            roomObj.setLoc(new int[]{5, 9});
        }
        return roomObj;
    }
}
