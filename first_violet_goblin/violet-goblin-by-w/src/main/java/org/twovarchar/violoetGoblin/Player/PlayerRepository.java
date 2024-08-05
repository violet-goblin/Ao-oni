package org.twovarchar.violoetGoblin.Player;

import org.twovarchar.violoetGoblin.Aooni.Aooni;
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
    private static int playerCurX = Room.mapSize / 2;
    private static int playerCurY = Room.mapSize - 2;
    private final Aooni aooni = new Aooni();

    /* 설명.
     *  아오오니 생성조건 
     *   1. 플레이어가 맵을 3번 옮겼을 때 문 반대쪽에서 생성. o
     *   2. 콘솔에 아오오니 출현!! alert 생성 o
     *   3. 전역 count와 아오오니의 현재 위치를 초기화 및 BFS를 적용한다.
     *  아오오니 소멸 조건 
     *   1. 방을 옮길 시 소멸 o
     *   2. "살려줘" 라고 치면 살 수 있다(이스터에그)
     *  아오오니와의 상하좌우대각선(dx_dy[8][2]) 거리가 1일 때 game_over
    * */
    private int changeRoomCount = 0;
    private boolean liveAoonni = false;

    public int getChangeRoomCount() {
        return changeRoomCount;
    }

    public void setChangeRoomCount(int changeRoomCount) {
        this.changeRoomCount = changeRoomCount;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public static int getPlayerCurY() {
        return playerCurY;
    }

    public void setPlayerCurY(int playerCurY) {
        this.playerCurY = playerCurY;
    }

    public static int getPlayerCurX() {
        return playerCurX;
    }

    public void setPlayerCurX(int playerCurX) {
        this.playerCurX = playerCurX;
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
                if(liveAoonni&& i== aooni.getAooniCurY() && j == aooni.getAooniCurX()){
                    System.out.print("A");
                }
                else if (i == getPlayerCurY() && j == getPlayerCurX()) {
                    System.out.print("P");
                } else {
                    System.out.print(currentMap[i][j]);
                }
                System.out.print(' ');
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
        int checkX = getPlayerCurX() + changeIndex[0];
        int checkY = getPlayerCurY() + changeIndex[1];

        /* 설명. 출구에서 행동 */
        if(isAtExit()){
            if(moveToNewRoom(checkX, checkY)){
                /* 설명. player가 방을 옮긴 수 count */
                setChangeRoomCount(getChangeRoomCount() + 1);

                /* 설명. 아오오니 소멸 */
                if(liveAoonni && getChangeRoomCount() == 1){
                    liveAoonni = false;
                    setChangeRoomCount(0);
                    return;
                }

                /* 설명. 생성 조건.*/
                if(getChangeRoomCount() == 3){
                    liveAoonni = true;
                    /* 설명. 방이 바뀐 시점에  player의 위치는 (0, map.size() -1), map.size() / 2 */
                    setAooniLocation();
                    System.out.println("----------------------------------\n" +
                                       "----------!watch out!-------------\n" +
                                       "-----ao-oni is coming out!!!!-----\n" +
                                       "----------------------------------");
                }
                return;
            }
        }

        /* 설명. 벽에 부딪힐 경우 */
        if(isWall(checkX, checkY)){
            if(isExit(checkX, checkY)){
                setPlayerCurX(checkX);
                setPlayerCurY(checkY);
            }
            return;
        }

        /* 설명. 정상적인 행동 */
        setPlayerCurX(checkX);
        setPlayerCurY(checkY);
    }

    private void setAooniLocation() {
        if(getPlayerCurX() != Room.mapSize / 2){
            if(getPlayerCurX() == 0){
                aooni.setAooniCurX(Room.mapSize - 2);
            }
            else{
                aooni.setAooniCurX(1);
            }
            aooni.setAooniCurY(Room.mapSize / 2);
        }else{
            if(getPlayerCurY() == 0){
                aooni.setAooniCurY(Room.mapSize - 2);
            }
            else{
                aooni.setAooniCurY(1);
            }
            aooni.setAooniCurX(Room.mapSize / 2);
        }
        setChangeRoomCount(0);
    }

    private boolean isAtExit() {
        return currentMap[getPlayerCurY()][getPlayerCurX()].equals("O");
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
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
                        return true;
                    } else if (isSameFloor && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'r') {
                        updateState(key);
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
                        return true;
                    }
                    break;
                case 'r':
                    if (isSameFloor && room.getRoomState() == 'r' && currentRoom.getRoomState() == 'c') {
                        updateState(key);
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
                        return true;
                    } else if (isSameFloor && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'l') {
                        updateState(key);
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
                        return true;
                    }
                    break;
                case 'd':
                    if (room.getFloor() == currentRoom.getFloor() - 1 && room.getRoomState() == 'c') {
                        updateState(key);
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
                        return true;
                    }
                    break;
                case 'u':
                    if (room.getFloor() == currentRoom.getFloor() + 1 && room.getRoomState() == 'c') {
                        updateState(key);
                        setPlayerCurX(newX);
                        setPlayerCurY(newY);
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
