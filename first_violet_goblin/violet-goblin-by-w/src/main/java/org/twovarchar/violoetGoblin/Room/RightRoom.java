package org.twovarchar.violoetGoblin.Room;

public class RightRoom implements Room{

    protected char roomState = 'r';

    public char getRoomState() {
        return roomState;
    }

    public void setRoomState(char roomState) {
        this.roomState = roomState;
    }

    @Override
    public void createMap(String[][] setRoom) {
        int mapSizeR = Room.mapSize;
        setRoom = new String[mapSizeR][mapSizeR];

        for(int i=0; i<mapSizeR; i++){
            for(int j=0; j<mapSizeR; j++){
                /* 설명. 오른쪽에 출구 생성 */
                if(i== 0 && j== mapSizeR / 2){
                    setRoom[i][j] = "O";
                    continue;
                }
                /* 설명. 테두리 설정 */
                if(i==0 || j==0 || i== mapSizeR -1 || j == mapSizeR -1){
                    setRoom[i][j] = "*";
                }
            }
            System.out.println();
        }
    }

}
