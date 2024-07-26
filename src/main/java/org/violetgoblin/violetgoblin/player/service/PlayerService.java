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
        System.out.println(roomName);
        System.out.println("=====================");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkDoor(int[] tmpLoc) {
        if (room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("ㅁ")) {
            map[loc[0]][loc[1]] = " ";
            nextRoom(tmpLoc);           // 다음 방으로 넘어간다.
            return false;
        } else {
            return true;
        }
    }

    private void nextRoom(int[] tmpLoc) {
        // 다음 방 선언해야함. like
        checkRoom(tmpLoc);
    }

    private void moveLoc(int[] tmpLoc) {
        map[loc[0]][loc[1]] = " ";
        loc[0] = tmpLoc[0];
        loc[1] = tmpLoc[1];
    }

    private boolean checkWall(int[] tmpLoc) {
        if (room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("#")) {
            return false;   // 벽 이야.
        } else {
            return true;    // 벽 아니야.
        }
    }

    /* 버튼 W눌렀을 경우*/

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
    /* 버튼 S눌렀을 경우*/

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
    /* 버튼 A눌렀을 경우*/

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
    /* 버튼 D눌렀을 경우*/

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


    private void checkRoom(int[] tmpLoc) {
        if (room instanceof MasterRoom1F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-10":
                    room = new KichenRoom1F();
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
        } else if (room instanceof MainRoom1F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-10":
                    room = new MasterRoom1F();
                    roomName = "Master Room";
                    loc[0] = 5;
                    loc[1] = 1;
                    break;
            }
        } else if (room instanceof KichenRoom1F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-0":
                    room = new MasterRoom1F();
                    roomName = "Master Room";
                    loc[0] = 5;
                    loc[1] = 9;
                    break;

            }
        } else if (room instanceof LaboratoryRoomB1) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-10":
                    room = new HallwayRoomB1();
                    roomName = "Hallway Room";
                    loc[0] = 5;
                    loc[1] = 1;
                    break;
            }
        } else if (room instanceof HallwayRoomB1) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
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
        } else if (room instanceof TortureRoomB1) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-0":
                    room = new HallwayRoomB1();
                    roomName = "Hallway Room";
                    loc[0] = 5;
                    loc[1] = 9;
                    break;
            }
        } else if (room instanceof StoreRoom2F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-10":
                    room = new GuestRoom2F();
                    roomName = "Guest Room";
                    loc[0] = 5;
                    loc[1] = 1;
                    break;
            }
        } else if (room instanceof GuestRoom2F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
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
        } else if (room instanceof TerraceRoom2F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-0":
                    room = new GuestRoom2F();
                    roomName = "Guest Room";
                    loc[0] = 5;
                    loc[1] = 9;
                    break;
            }
        } else if (room instanceof AtticRoom3F) {

            String l = tmpLoc[0] + "-" + tmpLoc[1];
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
        } else if (room instanceof SecretRoom3F) {
            String l = tmpLoc[0] + "-" + tmpLoc[1];
            switch (l) {
                case "5-0":
                    room = new AtticRoom3F();
                    roomName = "Attic Room";
                    loc[0] = 5;
                    loc[1] = 9;
                    break;

            }
        }
    }
}
