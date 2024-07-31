package org.twovarchar.violoetGoblin.Room;

public class HallwayRoom implements Room {
    private static int floor = -1;
    private static char roomState = 'c';

    public static char getRoomState() {
        return roomState;
    }

    public static void setRoomState(char roomState) {
        HallwayRoom.roomState = roomState;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        HallwayRoom.floor = floor;
    }

    @Override
    public void createMap(String[][] setRoom) {
        int mapSizeC = Room.mapSize;
        setRoom = new String[mapSizeC][mapSizeC];

        for(int i=0; i<mapSizeC; i++){
            for(int j=0; j<mapSizeC; j++){
                /* 설명. 상좌우에 출구 생성 */
                if((i == mapSizeC / 2 && j == 0) || (i == 0 && j == mapSizeC / 2) || (i == mapSizeC -1 && j == mapSizeC / 2)  ){
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
