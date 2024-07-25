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

        Opening opening = new Opening();
        opening.runGame();
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

    private static void playGame() {
        System.out.println("게임을 실행 합니다.");
        PlayerService ps = new PlayerService();

    }
}
