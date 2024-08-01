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
        System.out.println(pr.checkPlayerState(pr.controlPlayer(cmd)));
//        switch(pr.checkPlayerState(pr.controlPlayer(cmd))){
//            /* 설명. 1. 출구에서 방향에 따른 똑같은 방향키를 누를 경우 */
//            case 1:
//                break;
//            /* 설명. 2. 벽에 부딪힐 경우 */
//            case 2:
//                break;
//            /* 설명. 3. 정상 작동 */
//            case 3:
//                break;
//        }
    }
}
