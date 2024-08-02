package org.twovarchar.violoetGoblin.Room;



public class AtticRoom implements Room {

    private int floor = 3;
    private char roomState = 'c';

    public char getRoomState() {
        return roomState;
    }

    public void setRoomState(char roomState) {
        this.roomState = roomState;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    
    public AtticRoom() {

    }
    
    @Override
    public String[][] createMap() {
        int mapSizeC = Room.mapSize;
        String[][] setRoom = new String[mapSizeC][mapSizeC];

        for(int i=0; i<mapSizeC; i++){
            for(int j=0; j<mapSizeC; j++){
                /* 설명. 하, 우에 출구 생성 */
                if((((i == mapSizeC -1) && (j == mapSizeC / 2)) || (i== mapSizeC / 2) && (j== mapSizeC -1))){
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
