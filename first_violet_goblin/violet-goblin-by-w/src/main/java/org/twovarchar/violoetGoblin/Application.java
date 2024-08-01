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
        /* 설명. (press 'q') 게임 시작 (1층 마스터 시작, 플레이어 시작 위치 지정) */
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

            ps.writeMap();
        }
            /* 필기. 현재 위치해 있는 방이 어딨는지 판별하고, 방 바꾸기만 하면 될 듯.
             *  바꾸면 위치 초기화만 해주기.
             *  방을 바꿀 떄 조금 더 예쁘게 하는 방법? map을 이용하면 좋나?
            * */
//            if(printMap[currentRow][currentCol] == '1'){
//                /* 설명. 방의 좌표 값에 따른 커맨드인지 판별 (상, 하, 좌, 우 순)*/
//                if(currentCol == 5 && currentRow == 1 && moveRow == -1){
//                    /* 필기. 위층으로 가는 메소드 호출 */
//                }
//                else if(currentCol == 5 && currentRow == 9 && moveRow == 1){
//                    /* 필기. 아래층으로 가는 메소드 호출 */
//                }
//                else if(currentCol == 1 && currentRow == 5 && moveCol == 1){
//                    /* 필기. 왼방으로 가는 메소드 호출 */
//                }
//                else if(currentCol == 9 && currentRow == 5 && moveCol == -1){
//                    /* 필기. 오른방으로 가는 메소드 호출 */
//                }
//                /* 설명. 분기 넘어가기 */
//                continue;
//            }
//
//
//            /* 설명. 2. 방이 바뀌지 않을 시 방향키가 방 안에서 도는지 판별한다.*/
//            if(currentCol + moveCol > printMap[0].length-1 || currentCol + moveCol < 1
//                    || currentRow + moveRow > printMap.length -1 || currentRow + moveRow < 1){
//                /* 설명. 방 안에서 돌지 않을 시 무시할 것 (패딩값 고려 인덱스 쪼건 설정) */
//            }
//            else{
//                /* 설명. 충족할 시 위치값 바꿔주기 */
//                currentRow += moveRow;
//                currentCol += moveCol;
//            }
//
//
//            /* 설명. moveCol, moveRow 초기화*/
//            moveCol = 0;
//            moveRow = 0;
//        }

    }
}

