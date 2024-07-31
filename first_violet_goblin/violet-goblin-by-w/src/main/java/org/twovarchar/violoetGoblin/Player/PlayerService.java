package org.twovarchar.violoetGoblin.Player;

import org.twovarchar.violoetGoblin.Room.*;


public class PlayerService {
    /* 설명. Player repository와 항상 연관이 되도록 */
    private static final PlayerRepository pr = new PlayerRepository();

    public PlayerService() {
    }

    /* 설명. 게임 시작 서비스*/
    public void initGame() {
        /* 설명. 1. (초기화면인 마스터룸 화면 출력)*/
        pr.writeMap("MasterRoom");
    }
}
