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
//
//    private final HashMap<String, Room> myRoom = new HashMap<>();
//    private final HashMap<String, String[][]> myMap = new HashMap<>();
//    private String[][] currentMap;
//    private String currentMapKey;
//    private Room currentRoom;
//    private int curX = Room.mapSize / 2;
//    private int curY = Room.mapSize - 2;
//
//    public Room getCurrentRoom() {
//        return currentRoom;
//    }
//
//    public void setCurrentRoom(Room currentRoom) {
//        this.currentRoom = currentRoom;
//    }
//
//    public int getCurY() {
//        return curY;
//    }
//
//    public void setCurY(int curY) {
//        this.curY = curY;
//    }
//
//    public int getCurX() {
//        return curX;
//    }
//
//    public void setCurX(int curX) {
//        this.curX = curX;
//    }
//
//    public String getCurrentMapKey() {
//        return currentMapKey;
//    }
//
//    public void setCurrentMapKey(String currentMapKey) {
//        this.currentMapKey = currentMapKey;
//    }
//
//    public String[][] getCurrentMap() {
//        return currentMap;
//    }
//
//    public void setCurrentMap(String[][] currentMap) {
//        this.currentMap = currentMap;
//    }
//
//    public PlayerRepository() {
//        myRoom.put("MasterRoom", new MasterRoom());
//        myRoom.put("GuestRoom", new GuestRoom());
//        myRoom.put("HallwayRoom", new HallwayRoom());
//        myRoom.put("AtticRoom", new AtticRoom());
//        myRoom.put("LaboratoryRoom", new LaboratoryRoom());
//        myRoom.put("MainRoom", new MainRoom());
//        myRoom.put("StoreRoom", new StoreRoom());
//        myRoom.put("KitchenRoom", new KitchenRoom());
//        myRoom.put("TerraceRoom", new TerraceRoom());
//        myRoom.put("TortureRoom", new TortureRoom());
//        myRoom.put("SecretRoom", new SecretRoom());
//
//        for (String key : myRoom.keySet()) {
//            myMap.put(key, myRoom.get(key).createMap());
//        }
//
//        updateState("MasterRoom");
//    }
//
//    public void printMap(String key) {
//        updateState(key);
//
//        for (int i = 0; i < currentMap.length; i++) {
//            for (int j = 0; j < currentMap[i].length; j++) {
//                if (i == getCurY() && j == getCurX()) {
//                    System.out.print("P");
//                } else {
//                    System.out.print(currentMap[i][j]);
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.println("W: 상, A: 좌, S: 하, D: 우");
//        System.out.println();
//    }
//
//    private void updateState(String key) {
//        setCurrentRoom(myRoom.get(key));
//        setCurrentMap(myMap.get(key));
//        setCurrentMapKey(key);
//    }
//
//    public int[] controlPlayer(char cmd) {
//        int[] tempArray = new int[2];
//
//        switch (cmd) {
//            case 'W':
//                tempArray[1] = -1;
//                break;
//            case 'S':
//                tempArray[1] = 1;
//                break;
//            case 'A':
//                tempArray[0] = -1;
//                break;
//            case 'D':
//                tempArray[0] = 1;
//                break;
//            default:
//                break;
//        }
//        return tempArray;
//    }
//
//    public int checkPlayerState(int[] changeIndex) {
//        int checkX = getCurX() + changeIndex[0];
//        int checkY = getCurY() + changeIndex[1];
//
//        if (isExit(getCurX(), getCurY())) {
//            if (checkX == -1 || checkX == Room.mapSize || checkY == -1 || checkY == Room.mapSize) {
//                changeRoom(checkX, checkY);
//                return 1;
//            }
//        }
//
//        if (isWall(checkX, checkY)) {
//            return 2;
//        }
//
//        setCurX(checkX);
//        setCurY(checkY);
//        return 3;
//    }
//
//    private boolean isExit(int x, int y) {
//        return currentMap[y][x].equals("O");
//    }
//
//    private boolean isWall(int x, int y) {
//        return currentMap[y][x].equals("#");
//    }
//
//    private void changeRoom(int checkX, int checkY) {
//        for (String key : myRoom.keySet()) {
//            Room room = myRoom.get(key);
//            boolean isSameFloor = room.getFloor() == currentRoom.getFloor();
//
//            // 디버깅을 위한 출력
//            System.out.println("Current Room: " + currentMapKey + ", Checking Room: " + key);
//            System.out.println("CheckX: " + checkX + ", CheckY: " + checkY);
//            System.out.println("RoomState: " + room.getRoomState() + ", CurrentRoomState: " + currentRoom.getRoomState());
//
//            // 방 이동 조건 확인
//            if (isSameFloor) {
//                if (checkX == -1 && room.getRoomState() == 'l' && currentRoom.getRoomState() == 'c') {
//                    updateState(key);
//                    setCurX(Room.mapSize - 1);
//                    setCurY(Room.mapSize / 2);
//                    System.out.println("Moved to Room (Left): " + key);
//                    break;
//                } else if (checkX == Room.mapSize && room.getRoomState() == 'r' && currentRoom.getRoomState() == 'c') {
//                    updateState(key);
//                    setCurX(0);
//                    setCurY(Room.mapSize / 2);
//                    System.out.println("Moved to Room (Right): " + key);
//                    break;
//                } else if (checkX == -1 && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'l') {
//                    updateState(key);
//                    setCurX(Room.mapSize - 1);
//                    setCurY(Room.mapSize / 2);
//                    System.out.println("Moved to Room (Left2): " + key);
//                    break;
//                } else if (checkX == Room.mapSize && room.getRoomState() == 'c' && currentRoom.getRoomState() == 'r') {
//                    updateState(key);
//                    setCurX(0);
//                    setCurY(Room.mapSize / 2);
//                    System.out.println("Moved to Room (Right2): " + key);
//                    break;
//                }
//            }
//            /* 설명. 다른 층으로 이동하는 경우 */
//            else {
//                /* 설명. 아래층으로 이동할 때*/
//                if (checkY == Room.mapSize && room.getFloor() == currentRoom.getFloor() - 1 && room.getRoomState() == 'c') {
//                    updateState(key);
//                    setCurX(Room.mapSize / 2);
//                    setCurY(0);
//                    System.out.println("Moved to Room (Down, different floor): " + key);
//                    break;
//                } else if (checkY == -1 && room.getFloor() == currentRoom.getFloor() + 1 && room.getRoomState() == 'c') {
//                    updateState(key);
//                    setCurX(Room.mapSize / 2);
//                    setCurY(Room.mapSize - 1);
//                    System.out.println("Moved to Room (Up, different floor): " + key);
//                    break;
//                }
//            }
//        }
//    }
//
//}
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

    /* 설명. printMap에 key를 방이 바뀌는 등 연산을 계속 줘야한다.
     *  currnetMap, Room 등이 여기서 되고 있기 때문
     *  */
    public void printMap(String key) {
        /* 설명. 깊은 복사*/
        updateState(key);

        for (int i = 0; i < currentMap.length; i++) {
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
        System.out.println();
    }

    private void updateState(String key) {
        setCurrentRoom(myRoom.get(key));
        setCurrentMap(myMap.get(key));
        setCurrentMapKey(key);
    }

    public int[] controlPlayer(char cmd) {
        /* 설명. tempArray[0]은 x값, tempArray[1]은 y값 */
        int[] tempArray = new int[2];

        if (cmd == 'W') {
            tempArray[1] = -1;
        } else if (cmd == 'S') {
            tempArray[1] = 1;
        } else if (cmd == 'A') {
            tempArray[0] = -1;
        } else if (cmd == 'D') {
            tempArray[0] = 1;
        }
        return tempArray;
    }

    public int checkPlayerState(int[] changeIndex) {
        /* 설명.
         *  1. 출구에서 방이 바뀔 때. (추후 누를 수 있는 키를 추가?)
         *  2. 벽에 부딪힐 경우
         *  3. 다 아닌 경우
         * */
        int checkX = getCurX() + changeIndex[0];
        int checkY = getCurY() + changeIndex[1];

        /* 설명. 1. 출구에서 , (방 옮겨다니는 것 수정) */
        if (currentMap[getCurY()][getCurX()].equals("O")) {
            /* 설명. index가 0미만, mapSize이상일 때 제대로 된 키 입력 했다고 볼 수 있음 */
            if (checkX == -1) {
                /* 설명. 왼쪽방으로 바꾸고 초기 위치 지정 */
                for (String key : myRoom.keySet()) {
                    if (myRoom.get(key).getFloor() == currentRoom.getFloor()) {
                        if ((currentRoom.getRoomState() == 'c' && myRoom.get(key).getRoomState() == 'l') || (currentRoom.getRoomState() == 'r' && myRoom.get(key).getRoomState() == 'c')) {
                            updateState(key);
                            /* 설명. 여기서부터 초기 위치 지정 */
                            setCurX(Room.mapSize - 1);
                            setCurY(Room.mapSize / 2);
                            System.out.println(key);
                            break;
                        }
                    }
                }
            } else if (checkX == Room.mapSize) {
                /* 설명. 오른방으로 바꾸고 초기 위치 지정 */
                for (String key : myRoom.keySet()) {
                    if (myRoom.get(key).getFloor() == currentRoom.getFloor()) {
                        if ((currentRoom.getRoomState() == 'l' && myRoom.get(key).getRoomState() == 'c') || (currentRoom.getRoomState() == 'c' && myRoom.get(key).getRoomState() == 'r')) {
                            updateState(key);
                            /* 설명. 여기서부터 초기 위치 지정 */
                            setCurX(0);
                            setCurY(Room.mapSize / 2);
                            System.out.println(key);
                            break;
                        }
                    }
                }
            } else if (checkY == Room.mapSize) {
                /* 설명. 아래방으로 바꾸고 초기 위치 지정 */
                for (String key : myRoom.keySet()) {
                    if ((myRoom.get(key).getFloor() == (currentRoom.getFloor() - 1)) && (myRoom.get(key).getRoomState() == 'c')) {
                        updateState(key);
                        /* 설명. 여기서부터 초기 위치 지정 */
                        setCurX(Room.mapSize / 2);
                        setCurY(0);
                        System.out.println(key);
                        System.out.println("찾은 것" + myRoom.get(key).getFloor() + " :" + key);
                        System.out.println("원래 것" + currentRoom.getFloor());
                        break;
                    }
                }
            } else if (checkY == -1) {
                /* 설명. 위방으로 바꾸고 초기 위치 지정*/
                for (String key : myRoom.keySet()) {
                    if ((myRoom.get(key).getFloor() == currentRoom.getFloor() + 1) && (myRoom.get(key).getRoomState() == 'c')) {
                        updateState(key);
                        /* 설명. 여기서부터 초기 위치 지정 */
                        setCurX(Room.mapSize / 2);
                        setCurY(Room.mapSize - 1);
                        System.out.println(key);
                        break;
                    }
                }
            } else if (checkX == 1 || checkY == 1 || checkX == Room.mapSize - 2 || checkY == Room.mapSize - 2) {
                setCurX(checkX);
                setCurY(checkY);
                return 3;
            }
            return 1;
        }

        System.out.println("출구에서 통과 ");
        /* 설명. 2. 벽에 부딪힐 경우*/
        System.out.println("x: " + checkX + " y: " + checkY);
        if (checkX == 0 || checkY == 0 || checkX == Room.mapSize - 1 || checkY == Room.mapSize - 1) {
            if (currentMap[checkY][checkX].equals("O")) {
                System.out.println("출구로 향하는 중");
                setCurX(checkX);
                setCurY(checkY);
                return 3;
            }
            return 2;
        }
        System.out.println("벽에 부딪혀서 통과");
        /* 설명. 3번 정상적인 행동 */
        setCurX(checkX);
        setCurY(checkY);
        return 3;
    }
}
