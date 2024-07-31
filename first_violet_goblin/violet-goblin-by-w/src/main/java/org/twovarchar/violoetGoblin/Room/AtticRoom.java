package org.twovarchar.violoetGoblin.Room;



public class AtticRoom implements Room {

    private static int floor = 3;
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
        AtticRoom.floor = floor;
    }
    
    public AtticRoom() {

    }
    
    @Override
    public void createMap(String[][] setRoom) {
        int mapSizeC = Room.mapSize;
        setRoom = new String[mapSizeC][mapSizeC];

        for(int i=0; i<mapSizeC; i++){
            for(int j=0; j<mapSizeC; j++){
                /* 설명. 아래에 출구 생성 */
                if(i== mapSizeC / 2 && j== mapSizeC -1){
                    setRoom[i][j] = "O";
                    continue;
                }
                /* 설명. 테두리 설정 */
                if(i==0 || j==0 || i== mapSizeC -1 || j == mapSizeC -1){
                    setRoom[i][j] = "*";
                }
            }
            System.out.println();
        }
    }
}
