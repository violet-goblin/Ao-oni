package org.twovarchar.violoetGoblin;

import org.twovarchar.violoetGoblin.Player.PlayerService;

import java.util.Scanner;

public class Application {
    /* 설명. Player service와 항상 연관이 되도록 */
    private static final PlayerService ps = new PlayerService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 설명. 오프닝
         * **************************************
         * *   아오오니 초기 스토리라인 따오기        *
         * *          따와서 시뮬                 *
         * **************************************
         *
        * */
        /* 설명. 게임 시작 (1층 마스터 시작, 플레이어 시작 위치 지정) */
        ps.initMap("MasterRoom");
        /* 설명. 움직일 위치 받을 변수 input */
        char input;
        /* 2. 시작. 종료 시 command 지정해야함 */
        while(true) {
            /* 설명. 입력받기(대문자 판별) */
            input = sc.next().toUpperCase().charAt(0);

            if(input == 'Q') {
                System.exit(0);
            }

            switch (input) {
                case 'W':
                    ps.movePlayer('W');
                    break;
                case 'A':
                    ps.movePlayer('A');
                    break;
                case 'S':
                    ps.movePlayer('S');
                    break;
                case 'D':
                    ps.movePlayer('D');
                    break;
                default:
            }
            boolean check = ps.writeMap();
            if(!check){
                System.out.println("GAME OVER");
                System.exit(0);
            }
        }
    }
}

