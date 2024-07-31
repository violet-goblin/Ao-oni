package org.twovarchar.violoetGoblin.Room;

public class LeftRoom implements Room {

    protected char roomState = 'l';

    public char getRoomState() {
        return roomState;
    }

    public void setRoomState(char roomState) {
        this.roomState = roomState;
    }

    @Override
    public void createMap(String[][] setRoom) {
        int mapSizeL = Room.mapSize;
        setRoom = new String[mapSizeL][mapSizeL];

        for(int i=0; i<mapSizeL; i++){
            for(int j=0; j<mapSizeL; j++){
                /* 설명. 오른쪽에 출구 생성 */
                if(i== mapSizeL-1 && j== mapSizeL / 2){
                    setRoom[i][j] = "O";
                    continue;
                }
                /* 설명. 테두리 설정 */
                if(i==0 || j==0 || i== mapSizeL -1 || j == mapSizeL -1){
                    setRoom[i][j] = "*";
                }
           }
        }
    }
}
