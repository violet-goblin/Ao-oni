package org.twovarchar.violoetGoblin.Room;

public interface Room {
    /* 설명. map size 설정 */
    public final static int mapSize = 11;
    /* 설명. 방의 위치를 알려주는 변수(현재는 초기값). */
    public char roomState = 'c';
    public int floor = '1';

    /* 설명. 출구 설정*/
    public abstract void createMap();

    /* 설명. 방 초기화 코드.*/
//    private void initRoom(char[][] room){
//        for(int i=0;i<room.length;i++){
//            for(int j=0;j<room[0].length;j++){
//                /* 설명. 바깥열은 *로 감싸기(11로 선언하였으니 패딩값이 된다. */
//                if(i==0 || j==0 || i==10 || j == 10){
//                    room[i][j] = '*';
//                }
//                else{
//                    room[i][j] = 'O';
//                }
//            }
//        }
//    }


}


