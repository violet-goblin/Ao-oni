package org.violetgoblin.violetgoblin.player.service;

import org.violetgoblin.violetgoblin.player.repository.PlayerRepository;
import org.violetgoblin.violetgoblin.vue.room.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayerService {

    PlayerRepository pr = new PlayerRepository();
    int[] loc = {9, 5};        // player init location
    static Room room = new MasterRoom1F();     // 게임 시작 방
    String[][] map = room.getRoom();
    static String roomName = "MasterRoom";

    /* 게임 시작! */
    public PlayerService() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = room.getRoom();
        map[loc[0]][loc[1]] = "P";

        showMap(map);
    }

    /* 맵 그리기 */
    private static void showMap(String[][] map) {
        System.out.println("=====================");
        System.out.println(roomName + "(0: 메뉴로 돌아가기)");
        System.out.println("=====================");
        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    /* 문 체크용 */
    private boolean checkDoor(int[] tmpLoc) {
        if (room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("ㅁ")) {
            map[loc[0]][loc[1]] = " ";
            nextRoom(tmpLoc);           // 다음 방으로 넘어간다.
            return false;
        } else {
            return true;
        }
    }

    /* 한칸 움직일 때 사용 */
    private void moveLoc(int[] tmpLoc) {
        map[loc[0]][loc[1]] = " ";
        loc[0] = tmpLoc[0];
        loc[1] = tmpLoc[1];
    }

    /* 벽인지 체크 */
    private boolean checkWall(int[] tmpLoc) {
        // 벽 O -> return false, 벽 X -> return true
        return !room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("#");
    }

    /* 버튼 'W' 눌렀을 경우*/
    public void pressKeyW() {
        int[] tmpLoc = {loc[0] - 1, loc[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoom().clone();
        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 버튼 'S' 눌렀을 경우*/
    public void pressKeyS() {
        int[] tmpLoc = {loc[0] + 1, loc[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoom().clone();
        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 버튼 'A' 눌렀을 경우*/
    public void pressKeyA() {
        int[] tmpLoc = {loc[0], loc[1] - 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoom().clone();
        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 버튼 'D' 눌렀을 경우*/
    public void pressKeyD() {
        int[] tmpLoc = {loc[0], loc[1] + 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoom().clone();
        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 다음 방 설정 */
    private void nextRoom(int[] tmpLoc) {
        String l = tmpLoc[0] + "-" + tmpLoc[1];
        if (room instanceof MasterRoom1F) {
            changeMasterRoom1F(l);
        } else if (room instanceof MainRoom1F) {
            changeMainRoom1F(l);
        } else if (room instanceof KitchenRoom1F) {
            changeKitchenRoom1F(l);
        } else if (room instanceof LaboratoryRoomB1) {
            changeLaboratoryRoomB1(l);
        } else if (room instanceof HallwayRoomB1) {
            changeHallwayRoomB1(l);
        } else if (room instanceof TortureRoomB1) {
            changeTortureRoomB1(l);
        } else if (room instanceof StoreRoom2F) {
            changeStoreRoom2F(l);
        } else if (room instanceof GuestRoom2F) {
            changeGuestRoom2F(l);
        } else if (room instanceof TerraceRoom2F) {
            changeTerraceRoom2F(l);
        } else if (room instanceof AtticRoom3F) {
            changeAtticRoom3F(l);
        } else if (room instanceof SecretRoom3F) {
            changeSecretRoom3F(l);
        }
    }

    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
    /* 궁금. 왜 이건 jck 17에선 안되누..*/
//    private void nextRoom(int[] tmpLoc) {
//        String l = tmpLoc[0] + "-" + tmpLoc[1];
//        switch (room) {
//            case MasterRoom1F m -> {
//                changeMasterRoom1F(l);
//            }
//            case MainRoom1F m -> {
//                changeMainRoom1F(l);
//            }
//            case KitchenRoom1F m -> {
//                changeKitchenRoom1F(l);
//            }
//            case LaboratoryRoomB1 m -> {
//                changeLaboratoryRoomB1(l);
//            }
//            case HallwayRoomB1 m -> {
//                changeHallwayRoomB1(l);
//            }
//            case TortureRoomB1 m -> {
//                changeTortureRoomB1(l);
//            }
//            case StoreRoom2F m -> {
//                changeStoreRoom2F(l);
//            }
//            case GuestRoom2F m -> {
//                changeGuestRoom2F(l);
//            }
//            case TerraceRoom2F m -> {
//                changeTerraceRoom2F(l);
//            }
//            case AtticRoom3F m -> {
//                changeAtticRoom3F(l);
//            }
//            case SecretRoom3F m -> {
//                changeSecretRoom3F(l);
//            }
//        }
//    }
    /* 다음 방 선언 */
    private void changeSecretRoom3F(String l) {
        if (l.equals("5-0")) {
            room = new AtticRoom3F();
            roomName = "Attic Room";
            loc[0] = 5;
            loc[1] = 9;
        }
    }

    /* 다음 방 선언 */
    private void changeAtticRoom3F(String l) {
        switch (l) {
            case "5-10":
                room = new SecretRoom3F();
                roomName = "Secret Room";
                loc[0] = 5;
                loc[1] = 1;
                break;
            case "10-5":
                room = new GuestRoom2F();
                roomName = "Guest Room";
                loc[0] = 1;
                loc[1] = 5;
                break;
        }
    }

    /* 다음 방 선언 */
    private void changeTerraceRoom2F(String l) {
        if (l.equals("5-0")) {
            room = new GuestRoom2F();
            roomName = "Guest Room";
            loc[0] = 5;
            loc[1] = 9;
        }
    }

    /* 다음 방 선언 */
    private void changeGuestRoom2F(String l) {
        switch (l) {
            case "5-10":
                room = new TerraceRoom2F();
                roomName = "Terrace Room";
                loc[0] = 5;
                loc[1] = 1;
                break;
            case "0-5":
                room = new AtticRoom3F();
                roomName = "Attic Room";
                loc[0] = 9;
                loc[1] = 5;
                break;
            case "5-0":
                room = new StoreRoom2F();
                roomName = "Store Room";
                loc[0] = 5;
                loc[1] = 9;
                break;
            case "10-5":
                room = new MasterRoom1F();
                roomName = "Master Room";
                loc[0] = 1;
                loc[1] = 5;
                break;
        }
    }

    /* 다음 방 선언 */
    private void changeStoreRoom2F(String l) {
        if (l.equals("5-10")) {
            room = new GuestRoom2F();
            roomName = "Guest Room";
            loc[0] = 5;
            loc[1] = 1;
        }
    }

    /* 다음 방 선언 */
    private void changeTortureRoomB1(String l) {
        if (l.equals("5-0")) {
            room = new HallwayRoomB1();
            roomName = "Hallway Room";
            loc[0] = 5;
            loc[1] = 9;
        }
    }

    /* 다음 방 선언 */
    private void changeHallwayRoomB1(String l) {
        switch (l) {
            case "5-10":
                room = new TortureRoomB1();
                roomName = "Torture Room";
                loc[0] = 5;
                loc[1] = 1;
                break;
            case "0-5":
                room = new MasterRoom1F();
                roomName = "Master Room";
                loc[0] = 9;
                loc[1] = 5;
                break;
            case "5-0":
                room = new LaboratoryRoomB1();
                roomName = "Laboratory Room";
                loc[0] = 5;
                loc[1] = 9;
                break;
        }
    }

    /* 다음 방 선언 */
    private void changeLaboratoryRoomB1(String l) {
        if (l.equals("5-10")) {
            room = new HallwayRoomB1();
            roomName = "Hallway Room";
            loc[0] = 5;
            loc[1] = 1;
        }
    }

    /* 다음 방 선언 */
    private void changeKitchenRoom1F(String l) {
        if (l.equals("5-0")) {
            room = new MasterRoom1F();
            roomName = "Master Room";
            loc[0] = 5;
            loc[1] = 9;
        }
    }

    /* 다음 방 선언 */
    private void changeMainRoom1F(String l) {
        if (l.equals("5-10")) {
            room = new MasterRoom1F();
            roomName = "Master Room";
            loc[0] = 5;
            loc[1] = 1;
        }
    }

    /* 다음 방 선언 */
    private void changeMasterRoom1F(String l) {
        switch (l) {
            case "5-10":
                room = new KitchenRoom1F();
                roomName = "Kichen Room";
                loc[0] = 5;
                loc[1] = 1;
                break;
            case "0-5":
                room = new GuestRoom2F();
                roomName = "Guest Room";
                loc[0] = 9;
                loc[1] = 5;
                break;
            case "5-0":
                room = new MainRoom1F();
                roomName = "Main Room";
                loc[0] = 5;
                loc[1] = 9;
                break;
            case "10-5":
                room = new HallwayRoomB1();
                roomName = "Hallway Room";
                loc[0] = 1;
                loc[1] = 5;
                break;
        }
    }
}
