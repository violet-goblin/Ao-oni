package org.violetgoblin.violetgoblin.player.service;

import org.violetgoblin.violetgoblin.aooni.aggregate.AooniStatus;
import org.violetgoblin.violetgoblin.aooni.service.AooniService;
import org.violetgoblin.violetgoblin.player.aggregate.RoomObj;
import org.violetgoblin.violetgoblin.player.repository.PlayerRepository;
import org.violetgoblin.violetgoblin.vue.room.*;

public class PlayerService {

    PlayerRepository pr = new PlayerRepository();
    AooniService as = new AooniService();
    AooniStatus aooni = new AooniStatus();
    public static RoomObj room = new RoomObj(new MasterRoom1F(), "Master Room(1F)", new int[]{9, 5});
    public static String[][] map = room.getRoomObj().getRoomMap();

    /* 게임 시작! */
    public PlayerService() {
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        as.makeAooni(aooni);
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

    /* 플레이어 한칸 움직일 때 사용 */
    private void pMoveLoc(int[] pTmpLoc) {
        map[room.getLoc()[0]][room.getLoc()[1]] = " ";
        room.setLoc(pTmpLoc);
    }

    /* 아오오니 한칸 움직일 때 사용 */
    private void aMoveLoc(int[] aTmpLoc) {
        map[aooni.getLoc()[0]][aooni.getLoc()[1]] = " ";
        aooni.setLoc(aTmpLoc);
    }

    /* 벽인지 체크 */
    private boolean checkWall(int[] tmpLoc) {
        // 벽 O -> return false, 벽 X -> return true
        return !map[tmpLoc[0]][tmpLoc[1]].equals("#");
    }

    private boolean checkAooni() {
        if (((aooni.getLoc()[0] >= room.getLoc()[0] - 1) && (aooni.getLoc()[0] <= room.getLoc()[0] + 1))
                && ((aooni.getLoc()[1] >= room.getLoc()[1] - 1) && (aooni.getLoc()[1] <= room.getLoc()[1] + 1))) {
            return false;        // Game Over~~~
        }
        return true;
    }

    /* 버튼 'W' 눌렀을 경우*/
    public boolean pressKeyW() {
        int[] pTmpLoc = {room.getLoc()[0] - 1, room.getLoc()[1]};
        int[] aTmpLoc = as.moveAooni(aooni);    // 아오오니 랜덤으로 움직임
//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(pTmpLoc)) {
            if (checkDoor(pTmpLoc)) {
                pMoveLoc(pTmpLoc);
            }
        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";

        if (checkWall(aTmpLoc)) {
            if (checkDoor(aTmpLoc)) {
                aMoveLoc(aTmpLoc);
            }
        }
        map[aooni.getLoc()[0]][aooni.getLoc()[1]] = "A";
        showMap(map);
        return !checkAooni();    // Game Over
    }

    /* 버튼 'S' 눌렀을 경우*/
    public boolean pressKeyS() {
        int[] tmpLoc = {room.getLoc()[0] + 1, room.getLoc()[1]};
        int[] aTmpLoc = as.moveAooni(aooni);    // 아오오니 랜덤으로 움직임
//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                pMoveLoc(tmpLoc);
            }
        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";

        if (checkWall(aTmpLoc)) {
            if (checkDoor(aTmpLoc)) {
                aMoveLoc(aTmpLoc);
            }
        }
        map[aooni.getLoc()[0]][aooni.getLoc()[1]] = "A";
        showMap(map);
        return !checkAooni();    // Game Over
    }

    /* 버튼 'A' 눌렀을 경우*/
    public boolean pressKeyA() {
        int[] tmpLoc = {room.getLoc()[0], room.getLoc()[1] - 1};
        int[] aTmpLoc = as.moveAooni(aooni);    // 아오오니 랜덤으로 움직임
//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                pMoveLoc(tmpLoc);
            }
        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        if (checkWall(aTmpLoc)) {
            if (checkDoor(aTmpLoc)) {
                aMoveLoc(aTmpLoc);
            }
        }
        map[aooni.getLoc()[0]][aooni.getLoc()[1]] = "A";
        showMap(map);
        return !checkAooni();    // Game Over
    }

    /* 버튼 'D' 눌렀을 경우*/
    public boolean pressKeyD() {
        int[] tmpLoc = {room.getLoc()[0], room.getLoc()[1] + 1};
        int[] aTmpLoc = as.moveAooni(aooni);    // 아오오니 랜덤으로 움직임
//        1. 벽 2. 아오오니 3. 문 == 4. 미션
        if (checkWall(tmpLoc)) {
            if (checkDoor(tmpLoc)) {
                pMoveLoc(tmpLoc);
            }
        }
        map = room.getRoomObj().getRoomMap().clone();
        map[room.getLoc()[0]][room.getLoc()[1]] = "P";
        if (checkWall(aTmpLoc)) {
            if (checkDoor(aTmpLoc)) {
                aMoveLoc(aTmpLoc);
            }
        }
        map[aooni.getLoc()[0]][aooni.getLoc()[1]] = "A";
        showMap(map);
        return !checkAooni();    // Game Over
    }

    /* 다음 방 설정 */
    private void nextRoom(int[] tmpLoc) {
        String curDoorLoc = tmpLoc[0] + "-" + tmpLoc[1];
        room = room.getRoomObj().changeRoom(curDoorLoc, room);
    }
}
