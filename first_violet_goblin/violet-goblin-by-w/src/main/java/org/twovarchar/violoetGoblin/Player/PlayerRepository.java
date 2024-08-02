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
    private final HashMap<String, Room> myRoom = new HashMap<>();
    private final HashMap<String, String[][]> myMap = new HashMap<>();
    /* 설명. 전역으로 쓸 현재 맵, 키 */
    private String[][] currentMap;
    private String currentMapKey;
    private Room currentRoom;
    /* 설명. 플레이어 초기 위치 설정 및 캡슐화 */
    private int curX = Room.mapSize / 2;
    private int curY = Room.mapSize - 2;

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

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

    public String getCurrentMapKey() {
        return currentMapKey;
    }

    public void setCurrentMapKey(String currentMapKey) {
        this.currentMapKey = currentMapKey;
    }

    public String[][] getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(String[][] currentMap) {
        this.currentMap = currentMap;
    }

    public PlayerRepository() {
        /* 설명. 객체 생성이다. */
        myRoom.put("MasterRoom", new MasterRoom());
        myRoom.put("GuestRoom", new GuestRoom());
        myRoom.put("HallwayRoom", new HallwayRoom());
        myRoom.put("AtticRoom", new AtticRoom());
        myRoom.put("LaboratoryRoom", new LaboratoryRoom());
        myRoom.put("MainRoom", new MainRoom());
        myRoom.put("StoreRoom", new StoreRoom());
        myRoom.put("KitchenRoom", new KitchenRoom());
        myRoom.put("TerraceRoom", new TerraceRoom());
        myRoom.put("TortureRoom", new TortureRoom());
        myRoom.put("SecretRoom", new SecretRoom());

        /* 설명. 맵을 담는다.*/
        for (String key : myRoom.keySet()) {
            myMap.put(key, myRoom.get(key).createMap());
        }
    }

    /* 설명. printMap에 key를 방이 바뀌는 등 연산을 계속 줘야한다. */
    public void printMap(String key) {
        /* 설명. 깊은 복사*/
        updateState(key);

        System.out.println(" ~ " + currentMapKey + " ~\n");

        for (int i = 0; i < currentMap.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < currentMap[i].length; j++) {
                if (i == getCurY() && j == getCurX()) {
                    System.out.print("P");
                } else {
                    System.out.print(currentMap[i][j]);
                }
            }
            System.out.println();
        }

        System.out.println("W: 상, A: 좌, S: 하, D: 우");
    }

    private void updateState(String key) {
        setCurrentRoom(myRoom.get(key));
        setCurrentMap(myMap.get(key));
        setCurrentMapKey(key);
    }

    public int[] controlPlayer(char cmd) {
        /* 설명. tempArray[0]은 x값, tempArray[1]은 y값 */
        int[] tempArray = new int[2];

        switch(cmd){
            case 'W':
                tempArray[1] = -1;
                break;
            case 'S':
                tempArray[1] = 1;
                break;
            case 'A':
                tempArray[0] = -1;
                break;
            case 'D':
                tempArray[0] = 1;
                break;
        }

        return tempArray;
    }

    public void checkPlayerState(int[] changeIndex) {
        /* 설명.
         *  1. 출구에서 방이 바뀔 때. (추후 누를 수 있는 키를 추가?)
         *  2. 벽에 부딪힐 경우
         *  3. 다 아닌 경우
         * */
        int checkX = getCurX() + changeIndex[0];
        int checkY = getCurY() + changeIndex[1];

        /* 설명. 출구에서 행동 */
        if(isAtExit()){
            if(moveToNewRoom(checkX, checkY)){
                return;
            }
        }

        /* 설명. 벽에 부딪힐 경우 */
        if(isWall(checkX, checkY)){
            if(isExit(checkX, checkY)){
                setCurX(checkX);
                setCurY(checkY);
            }
            return;
        }

        /* 설명. 정상적인 행동 */
        setCurX(checkX);
        setCurY(checkY);
    }

    private boolean isAtExit() {
        return currentMap[getCurY()][getCurX()].equals("O");
    }

    private boolean moveToNewRoom(int checkX, int checkY) {
        if (checkX == -1) {
            return moveRoom('l', Room.mapSize - 1, Room.mapSize / 2);
        } else if (checkX == Room.mapSize) {
            return moveRoom('r', 0, Room.mapSize / 2);
        } else if (checkY == Room.mapSize) {
            return moveRoom('d', Room.mapSize / 2, 0);
        } else if (checkY == -1) {
            return moveRoom('u', Room.mapSize / 2, Room.mapSize - 1);
        }
        return false;
    }

    private boolean moveRoom(char direction, int newX, int newY) {
        for (String key : myRoom.keySet()) {
            Room room = myRoom.get(key);
            boolean isSameFloor = room.getFloor() == currentRoom.getFloor();

            switch (direction) {
                case 'l':
                    if (isSameFloor && room.getRoomState() == 'l' && currentRoom.getRoomState() == 'c') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    } else if (isSameFloor && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'r') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    }
                    break;
                case 'r':
                    if (isSameFloor && room.getRoomState() == 'r' && currentRoom.getRoomState() == 'c') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    } else if (isSameFloor && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'l') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    }
                    break;
                case 'd':
                    if (room.getFloor() == currentRoom.getFloor() - 1 && room.getRoomState() == 'c') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    }
                    break;
                case 'u':
                    if (room.getFloor() == currentRoom.getFloor() + 1 && room.getRoomState() == 'c') {
                        updateState(key);
                        setCurX(newX);
                        setCurY(newY);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private boolean isWall(int x, int y) {
        return x == 0 || y == 0 || x == Room.mapSize - 1 || y == Room.mapSize - 1;
    }

    private boolean isExit(int x, int y) {
        return currentMap[y][x].equals("O");
    }

}
