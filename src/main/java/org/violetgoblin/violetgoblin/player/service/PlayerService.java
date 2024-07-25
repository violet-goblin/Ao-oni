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


    public PlayerService() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] map = ((MasterRoom1F) room).getRoom();
        map[loc[0]][loc[1]] = "P";

        showMap(map);
    }

    private static void showMap(String[][] map1) {
        for (int i = 0; i < map1.length; i++) {
            for(int j = 0; j < map1[i].length; j++) {
                System.out.print(map1[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void pressKeyW() {
        int[] tmpLoc = {loc[0]-1, loc[1]};

//        checkAooni(tmpLoc); -> GameOver
        if(!checkWall(tmpLoc)){
            moveLoc(tmpLoc);
        }
        checkDoor(tmpLoc);

    }

    private boolean checkDoor(int[] tmpLoc) {

    }

    private void moveLoc(int[] tmpLoc) {
        loc[0]= tmpLoc[0];
        loc[1]= tmpLoc[1];
    }

    private boolean checkWall(int[] tmpLoc) {
        room
        return 0;
    }
}
