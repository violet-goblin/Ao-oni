package org.violetgoblin.violetgoblin.vue.room;

public class AtticRoom3F implements Room {
    private String[][] room = {{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "ㅁ"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"}
            , {"#", "#", "#", "#", "#", "ㅁ", "#", "#", "#", "#", "#"}};

    int[][] door = new int[][]{{5, 10}, {10, 5}};
                            // AtticRoom3F, GuestRoom


    @Override
    public void moveRoom() {

    }

    public String[][] getRoom() {
        return room;
    }

    public void setRoom(String[][] room) {
        this.room = room;
    }
}
