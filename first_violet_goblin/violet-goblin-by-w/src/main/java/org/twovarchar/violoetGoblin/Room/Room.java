package org.twovarchar.violoetGoblin.Room;

public interface Room {
    /* 설명. map size 설정 */
    public final static int mapSize = 11;
    /* 설명. 방의 위치를 알려주는 변수(현재는 초기값). */
//    char roomState = 'c';
//    int floor = 1;

    /* 설명. 출구 설정*/
//    public abstract void createMap(Object setRoom);
    void createMap(String[][] setRoom);



}


