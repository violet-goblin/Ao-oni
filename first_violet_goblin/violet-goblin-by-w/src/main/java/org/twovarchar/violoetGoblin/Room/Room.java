package org.twovarchar.violoetGoblin.Room;

public interface Room {
    /* 설명. map size 설정 */
    public final static int mapSize = 11;



    /* 설명. 출구 설정*/
    String[][] createMap();

    void printMap(String[][] map);

}


