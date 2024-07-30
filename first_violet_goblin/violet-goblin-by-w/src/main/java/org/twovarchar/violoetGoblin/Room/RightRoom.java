package org.twovarchar.violoetGoblin.Room;

public class RightRoom implements Room{

    @Override
    public void createMap() {
        int mapSizeR = Room.mapSize;
        String[][] leftRoom = new String[mapSizeR][mapSizeR];

        for(int i=0; i<mapSizeR; i++){
            for(int j=0; j<mapSizeR; j++){
                /* 설명. 오른쪽에 출구 생성 */
                if(i== 0 && j== mapSizeR / 2){
                    leftRoom[i][j] = "O";
                    continue;
                }
                /* 설명. 테두리 설정 */
                if(i==0 || j==0 || i== mapSizeR -1 || j == mapSizeR -1){
                    leftRoom[i][j] = "*";
                }
            }
            System.out.println();
        }
    }

}
