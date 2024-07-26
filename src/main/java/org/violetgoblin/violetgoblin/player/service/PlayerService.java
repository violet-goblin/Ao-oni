package org.violetgoblin.violetgoblin.player.service;

import org.violetgoblin.violetgoblin.player.repository.PlayerRepository;
import org.violetgoblin.violetgoblin.vue.room.MasterRoom1F;
import org.violetgoblin.violetgoblin.vue.room.Room;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayerService {

    PlayerRepository pr = new PlayerRepository();
    int[] loc = {9, 5};        // player init location
    Room room = new MasterRoom1F();     // 게임 시작 방
    String[][] map = room.getRoom();


    /* 게임 시작! */
    public PlayerService() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = ((MasterRoom1F) room).getRoom();
        map[loc[0]][loc[1]] = "P";

        showMap(map);
    }

    /* 맵 그리기 */
    private static void showMap(String[][] map1) {
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[i].length; j++) {
                System.out.print(map1[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkDoor(int[] tmpLoc) {
        if (room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("ㅁ")) {
            return false;
        } else {
            return true;
        }
    }

    private void moveLoc(int[] tmpLoc) {
        map[loc[0]][loc[1]] = " ";
        loc[0] = tmpLoc[0];
        loc[1] = tmpLoc[1];
    }

    private boolean checkWall(int[] tmpLoc) {
        if (room.getRoom()[tmpLoc[0]][tmpLoc[1]].equals("#")) {
            return false;
        } else {
            return true;
        }
    }

    /* 버튼 W눌렀을 경우*/
    public void pressKeyW() {
        int[] tmpLoc = {loc[0] - 1, loc[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc) && checkDoor(tmpLoc)) {
//        checkAooni(tmpLoc); -> GameOver
            moveLoc(tmpLoc);
        }

        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }
    
    /* 버튼 S눌렀을 경우*/
    public void pressKeyS() {
        int[] tmpLoc = {loc[0] + 1, loc[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc) && checkDoor(tmpLoc)) {
//        checkAooni(tmpLoc); -> GameOver
            moveLoc(tmpLoc);
        }

        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 버튼 A눌렀을 경우*/
    public void pressKeyA() {
        int[] tmpLoc = {loc[0], loc[1] - 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc) && checkDoor(tmpLoc)) {
//        checkAooni(tmpLoc); -> GameOver
            moveLoc(tmpLoc);
        }

        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }

    /* 버튼 D눌렀을 경우*/
    public void pressKeyD() {
        int[] tmpLoc = {loc[0], loc[1] + 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc) && checkDoor(tmpLoc)) {
//        checkAooni(tmpLoc); -> GameOver
            moveLoc(tmpLoc);
        }

        map[loc[0]][loc[1]] = "P";
        showMap(map);
    }
}
