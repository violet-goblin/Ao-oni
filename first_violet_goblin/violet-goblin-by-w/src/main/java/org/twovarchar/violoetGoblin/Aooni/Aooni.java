package org.twovarchar.violoetGoblin.Aooni;

import org.twovarchar.violoetGoblin.Player.PlayerRepository;
import org.twovarchar.violoetGoblin.Room.Room;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Aooni {
    private static int aooniCurX;
    private static int aooniCurY;

    private static final int[] dx = {0,1,0,-1};
    private static final int[] dy = {1,0,-1,0};
    private static int[][] visited;
    private static int[][][] predecessor;
    private static final ArrayDeque<int[]> queue = new ArrayDeque<>();

    public Aooni() {
    }

    public static int getAooniCurX() {
        return aooniCurX;
    }

    public static void setAooniCurX(int aooniCurX) {
        Aooni.aooniCurX = aooniCurX;
    }

    public static int getAooniCurY() {
        return aooniCurY;
    }

    public static void setAooniCurY(int aooniCurY) {
        Aooni.aooniCurY = aooniCurY;
    }

    public static boolean crashPlayer(){
//        bfs(getAooniCurX(), getAooniCurY());
//
//        if(visited[PlayerRepository.getPlayerCurY()][PlayerRepository.getPlayerCurX()] == 1){
//            return false;
//        }

        int playerX = PlayerRepository.getPlayerCurX();
        int playerY = PlayerRepository.getPlayerCurY();
        int calDis;
        if(bfs(getAooniCurX(), getAooniCurY(), playerX, playerY)){
//            System.out.println("bfs 넘어가기");
            /* 설명. 아오오니 현 위치 */
//            System.out.println(getAooniCurX() + " " + getAooniCurY());
//            System.out.println("back_track 시작");
            back_track(getAooniCurX(), getAooniCurY(), playerX, playerY);
            calDis = Math.abs(playerY - getAooniCurY()) + Math.abs(playerX - getAooniCurX());
            return calDis >= 2;
        }
        else{
            return false;
        }
    }

    private static boolean bfs(int startX, int startY, int goalX, int goalY) {
        visited = new int[Room.mapSize][Room.mapSize];
        predecessor = new int[Room.mapSize][Room.mapSize][2];
        /* 설명. 방문하지 않은 노드로 만들기 */
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        /* 설명. 최단 거리 경로 저장 */
        for (int i = 0; i < predecessor.length; i++) {
            for (int j = 0; j < predecessor.length; j++) {
                predecessor[i][j][0] = -1;
                predecessor[i][j][1] = -1;
            }
        }

        queue.clear();
        queue.offer(new int[]{startX, startY});
        visited[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == goalX && y == goalY) {
//                System.out.println("도달");
                return true; // 목표 위치에 도달
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidMove(nx, ny) && visited[ny][nx] == -1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.offer(new int[]{nx, ny});
                    /* 설명. predecessor 0은 x 1은 y */
                    predecessor[ny][nx][0] = x;
                    predecessor[ny][nx][1] = y;
//                    System.out.println("저장된 값 x,y순" + predecessor[ny][nx][0] + " " + predecessor[ny][nx][1]);
                }
            }
        }
//        System.out.println("도달 x");
        return false; // 목표 위치에 도달할 수 없음
    }

    /* 설명. 시작점이 골이어야함*/
    private static void back_track(int startX, int startY, int goalX, int goalY){
        /* 설명. current_state를 저장하기 위한 변수 */
//        System.out.println("back_track 함수 안");
        int tempX = goalX;
        int tempY = goalY;
        int ansY, ansX;
//        System.out.println(predecessor[tempY][tempX][0] != startX);
//        System.out.println(predecessor[tempY][tempX][1] != startY);

//        System.out.println("조건문 확인");
//        System.out.println(predecessor[tempY][tempX][0] != startX && predecessor[tempY][tempX][1] != startY);
        /* 설명. 다음 찾을 location이 startX일 때 tempX는 그 다음값(ansX)이 된다. */
        while(predecessor[tempY][tempX][0] != startX || predecessor[tempY][tempX][1] != startY){
            ansY = predecessor[tempY][tempX][1];
            ansX = predecessor[tempY][tempX][0];
//            System.out.println("tempX: " + tempX + " tempY: " + tempY);
            tempY = ansY;
            tempX = ansX;
        }

        setAooniCurX(tempX);
        setAooniCurY(tempY);
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < Room.mapSize && y >= 0 && y < Room.mapSize;
    }
}

//
//        for(int i = 0; i<visited.length; i++){
//            for(int j = 0; j<visited[i].length; j++){
//                if(visited[i][j] == 1){
//                    /* 설명. 최단 거리 측정 후 거리가 1일 때를 aooni 현재 위치*/
//                    setAooniCurY(i);
//                    setAooniCurX(j);
//                    break;
//                }
//            }
//        }
//        /* 설명. 메모리 초기화.*/
//        for(int i=0 ; i<visited.length ; i++){
//            Arrays.fill(visited[i], 0);
//            Arrays.fill(board[i], 0);
//        }
//        queue.clear();
//
//        return true;
//    }
