package org.violetgoblin.violetgoblin.player.service;

import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;
import org.violetgoblin.violetgoblin.player.repository.PlayerRepository;
import org.violetgoblin.violetgoblin.vue.room.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlayerService {

    PlayerRepository pr = new PlayerRepository();
    static RoomObj room = new RoomObj(new MasterRoom1F(), "Master Room(1F)", new int[]{9, 5});
    static String[][] map = room.getRoomObj().getRoomMap();

    /* 게임 시작! */
    public PlayerService() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";

        showMap(map);
    }

    /* 맵 그리기 */
    private static void showMap(String[][] map) {
        System.out.println("=====================");
        System.out.println(room.getRoomName() + "(0: 메뉴로 돌아가기)");
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
        if (map[tmpLoc[0]][tmpLoc[1]].equals("ㅁ")) {
            map[room.getLoc()[0]][room.getLoc()[1]] = " ";
            nextRoom(tmpLoc);           // 다음 방으로 넘어간다.
            return false;
        } else {
            return true;
        }
    }

    /* 한칸 움직일 때 사용 */
    private void moveLoc(int[] tmpLoc) {
        map[room.getLoc()[0]][room.getLoc()[1]] = " ";
        room.setLoc(tmpLoc);
    }

    /* 벽인지 체크 */
    private boolean checkWall(int[] tmpLoc) {
        // 벽 O -> return false, 벽 X -> return true
        return !map[tmpLoc[0]][tmpLoc[1]].equals("#");
    }

    /* 버튼 'W' 눌렀을 경우*/
    public void pressKeyW() {
        int[] tmpLoc = {room.getLoc()[0]-1,room.getLoc()[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        showMap(map);
    }

    /* 버튼 'S' 눌렀을 경우*/
    public void pressKeyS() {
        int[] tmpLoc = {room.getLoc()[0] + 1, room.getLoc()[1]};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        showMap(map);
    }

    /* 버튼 'A' 눌렀을 경우*/
    public void pressKeyA() {
        int[] tmpLoc = {room.getLoc()[0], room.getLoc()[1] - 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        showMap(map);
    }

    /* 버튼 'D' 눌렀을 경우*/
    public void pressKeyD() {
        int[] tmpLoc = {room.getLoc()[0], room.getLoc()[1] + 1};

//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                moveLoc(tmpLoc);
            }
//        checkAooni(tmpLoc); -> GameOver

        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        showMap(map);
    }

    /* 다음 방 설정 */
    private void nextRoom(int[] tmpLoc) {
        String curDoorLoc = tmpLoc[0] + "-" + tmpLoc[1];
        room = room.getRoomObj().changeRoom(curDoorLoc, room);
    }
}
