package org.twovarchar.violoetGoblin.Aooni;

import org.twovarchar.violoetGoblin.Player.PlayerRepository;
import org.twovarchar.violoetGoblin.Room.Room;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Aooni {
    private static int aooniCurX;
    private static int aooniCurY;

    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int[][] board = new int[Room.mapSize][Room.mapSize];
    private static int[][] visited = new int[Room.mapSize][Room.mapSize];
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();

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
        bfs(getAooniCurX(), getAooniCurY());

        if(visited[PlayerRepository.getPlayerCurY()-1][PlayerRepository.getPlayerCurX()-1] == 1){
            return false;
        }

        for(int i = 0; i<visited.length; i++){
            for(int j = 0; j<visited[i].length; j++){
                if(visited[i][j] == 1){
                    /* 설명. 최단 거리 측정 후 거리가 1일 때를 aooni 현재 위치*/
                    setAooniCurY(i);
                    setAooniCurX(j);
                    break;
                }
            }
        }
        /* 설명. 메모리 초기화.*/
        for(int i=0 ; i<visited.length ; i++){
            Arrays.fill(visited, 0);
            Arrays.fill(board, 0);
            queue.clear();
        }

        return true;
    }

    public static void bfs(int sx, int sy) {
        queue.offer(new int[]{sx, sy});
        visited[sy][sx] = 1;
        board[sy][sx] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < PlayerRepository.getPlayerCurX() && 0 <= ny && ny < PlayerRepository.getPlayerCurY() && visited[ny][nx] == 0 && board[ny][nx] == 1) {
                    visited[ny][nx] = visited[y][x] + 1;
                    board[ny][nx] = 0;
                    queue.offer(new int[]{nx, ny});

                }
            }
        }
    }
}
