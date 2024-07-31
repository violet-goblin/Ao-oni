package org.twovarchar.violoetGoblin.Player;

import org.twovarchar.violoetGoblin.Room.*;
import org.twovarchar.violoetGoblin.Room.Left.LaboratoryRoom;
import org.twovarchar.violoetGoblin.Room.Left.MainRoom;
import org.twovarchar.violoetGoblin.Room.Left.StoreRoom;
import org.twovarchar.violoetGoblin.Room.Right.KitchenRoom;
import org.twovarchar.violoetGoblin.Room.Right.SecretRoom;
import org.twovarchar.violoetGoblin.Room.Right.TerraceRoom;
import org.twovarchar.violoetGoblin.Room.Right.TortureRoom;

import java.util.HashMap;


public class PlayerRepository {

    private final HashMap<String,Room> myRoom = new HashMap<>();
    private final HashMap<String, String[][]> myMap = new HashMap<>();

    /* 설명. 플레이어 초기 위치 설정 및 캡슐화 */
    private int curX = Room.mapSize / 2;
    private int curY = Room.mapSize -1;

    public int getCurY() {
        return curY;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }

    public int getCurX() {
        return curX;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public PlayerRepository() {
        /* 설명. 객체 생성이다. */
        myRoom.put("MasterRoom",new MasterRoom());
        myRoom.put("GuestRoom",new GuestRoom());
        myRoom.put("HallwayRoom",new HallwayRoom());
        myRoom.put("AtticRoom",new AtticRoom());
        myRoom.put("LaboratoryRoom",new LaboratoryRoom());
        myRoom.put("MainRoom",new MainRoom());
        myRoom.put("StoreRoom",new StoreRoom());
        myRoom.put("KitchenRoom",new KitchenRoom());
        myRoom.put("TerraceRoom",new TerraceRoom());
        myRoom.put("TortureRoom",new TortureRoom());
        myRoom.put("SecretRoom",new SecretRoom());

        /* 설명. 맵을 담는다.*/
        for (String key : myRoom.keySet()) {
            myMap.put(key, myRoom.get(key).createMap());
        }
    }

    public void writeMap(String key){
        myRoom.get("MasterRoom").printMap(myMap.get("MasterRoom"));
    }
}
