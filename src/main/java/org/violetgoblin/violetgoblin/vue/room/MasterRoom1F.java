package org.violetgoblin.violetgoblin.vue.room;

public class MasterRoom1F implements Room {
    private String[][] room = {{"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"ㅁ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "ㅁ"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}};
    int[][] door = new int[][]{{10, 5}, {0, 5}, {5, 10}, {5, 0}};

    @Override
    public void moveRoom() {

    }

    @Override
    public String[][] getRoom() {
        return this.room;
    }

    public void setRoom(String[][] room) {
        this.room = room;
    }
}
