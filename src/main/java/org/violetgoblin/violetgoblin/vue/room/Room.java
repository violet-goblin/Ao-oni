package org.violetgoblin.violetgoblin.vue.room;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;

public interface Room {
    String[][] getRoomMap();
    String getRoomName();
//    RoomType getRoomType();
    RoomObj changeRoom(String curDoor, RoomObj roomObj);
}
