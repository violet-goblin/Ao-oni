package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class MasterRoom1F implements Room {
    private String[][] room = {{"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}
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
        return "Master Room(1F)";
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.MASTER_ROOM_1F;
    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        switch (curDoor) {
            case "5-10":
                roomObj.setRoom(new KitchenRoom1F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 1});
                break;
            case "0-5":
                roomObj.setRoom(new GuestRoom2F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{9, 5});
                break;
            case "5-0":
                roomObj.setRoom(new MainRoom1F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 9});
                break;
            case "10-5":
                roomObj.setRoom(new HallwayRoomB1());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{1, 5});
                break;
        }
        return roomObj;
    }
}
