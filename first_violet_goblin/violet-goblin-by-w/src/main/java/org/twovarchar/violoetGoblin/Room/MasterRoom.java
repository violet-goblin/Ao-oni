package org.twovarchar.violoetGoblin.Room;

public class MasterRoom implements Room {

    int floor = 1;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public char getRoomState() {
        return 0;
    }

    @Override
    public void setRoomState(char state) {

    }

    @Override
    public String[][] createMap() {
        int mapSizeC = Room.mapSize;
        String[][] setRoom = new String[mapSizeC][mapSizeC];

        for(int i=0; i<mapSizeC; i++){
            for(int j=0; j<mapSizeC; j++){
                /* 설명. 상하좌우에 출구 생성 */
                if((i== mapSizeC / 2 && j== mapSizeC -1) || (i == mapSizeC / 2 && j == 0) || (i == 0 && j == mapSizeC / 2) || (i == mapSizeC -1 && j == mapSizeC / 2)  ){
                    setRoom[i][j] = "O";
                    continue;
                }
                /* 설명. 테두리 설정 */
                if(i==0 || j==0 || i== mapSizeC -1 || j == mapSizeC -1){
                    setRoom[i][j] = "#";
                }
                else
                    setRoom[i][j] = "*";
            }
        }
        return setRoom;
    }


}
