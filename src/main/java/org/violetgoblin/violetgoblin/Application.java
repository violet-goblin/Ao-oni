package org.violetgoblin.violetgoblin;

import org.violetgoblin.violetgoblin.player.service.PlayerService;
import org.violetgoblin.violetgoblin.vue.ending.Ending;
import org.violetgoblin.violetgoblin.vue.opening.Opening;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Opening opening = new Opening();   // 오프닝 메세지 출력
        /* 메뉴 값 입력 받기 */
        while (true){
            opening.runGame();
            int num = Integer.valueOf(br.readLine());
            switch (num){
                case 1:
                    playGame();
                    break;
                case 2:
                    break;
                case 9:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }



    }

    /* 게임 시작하면  */
    private static void playGame() throws IOException {
        System.out.println("게임을 실행 합니다.");
        PlayerService ps = new PlayerService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine().toLowerCase();
            switch (input){
                case "w":
                    ps.pressKeyW();
                    break;
                case "s":
                    ps.pressKeyS();
                    break;
                case "a":
                    ps.pressKeyA();
                    break;
                case "d":
                    ps.pressKeyD();
                    break;
                case "0":
                    System.out.println("메뉴로 돌아갑니다.");
                    return;
            }

        }

    }
}
