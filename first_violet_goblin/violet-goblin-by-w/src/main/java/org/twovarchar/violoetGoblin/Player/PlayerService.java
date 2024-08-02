package org.twovarchar.violoetGoblin.Player;

import org.twovarchar.violoetGoblin.Room.*;


public class PlayerService {
    /* 설명. Player repository와 항상 연관이 되도록 */
    private static final PlayerRepository pr = new PlayerRepository();

    public PlayerService() {
    }

    /* 설명. 맵 출력 서비스 */
    public void initMap(String mapName) {
        /* 설명. 1. (초기화면인 마스터룸 화면 출력)*/
        System.out.println("-------------아오오니-------------");
        pr.printMap(mapName);
    }

    public void writeMap() {
        /* 설명. 2. 지속적으로 맵 출력 */
        pr.printMap(pr.getCurrentMapKey());
    }

    /* 설명. 커맨드에 따른 플레이어 위치 옮기기 */
    public void movePlayer(char cmd) {
        pr.checkPlayerState(pr.controlPlayer(cmd));
    }
}
