package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public class HallwayRoomB1 implements Room {
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
            , {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};

    @Override
    public String[][] getRoomMap() {
        return this.room;
    }

    @Override
    public String getRoomName() {
        return "Hallway Room(B1)";
    }

//    @Override
//    public RoomType getRoomType() {
//        return RoomType.HALLWAY_ROOM_B1;
//    }

    @Override
    public RoomObj changeRoom(String curDoor, RoomObj roomObj) {
        switch (curDoor) {
            case "5-10":
                roomObj.setRoom(new TortureRoomB1());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 1});
                return roomObj;
            case "0-5":
                roomObj.setRoom(new MasterRoom1F());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{9, 5});
                return roomObj;
            case "5-0":
                roomObj.setRoom(new LaboratoryRoomB1());
                roomObj.setRoomName(roomObj.getRoomObj().getRoomName());
                roomObj.setLoc(new int[]{5, 9});
        }
        return roomObj;
    }
}
