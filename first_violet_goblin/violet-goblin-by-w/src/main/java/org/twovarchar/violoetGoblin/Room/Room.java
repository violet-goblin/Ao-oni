package org.twovarchar.violoetGoblin.Room;

public class Room {
    /* 설명. ArrayList로 저장할 것이다. */
//    private static char[][] thirdFloorCenterAtticRoom = new char[11][11];
//    private static char[][] thirdFloorRightSecretRoom = new char[11][11];
//    private static char[][] secondFloorLeftStoreRoom = new char[11][11];
//    private static char[][] secondFloorCenterGuestRoom = new char[11][11];
//    private static char[][] secondFloorRightTerraceRoom = new char[11][11];
//    private static char[][] firstFloorLeftMainRoom = new char[11][11];
//    private static char[][] firstFloorCenterMasterRoom = new char[11][11];
//    private static char[][] firstFloorRightKitchenRoom = new char[11][11];
//    private static char[][] basementFloorLeftLaboratoryRoom = new char[11][11];
//    private static char[][] basementFloorCenterHallwayRoom = new char[11][11];
//    private static char[][] basementFloorTortureRoom = new char[11][11];
    private
    public Room() {
        initRoom
    }
//
//    private void allInitRoom() {
//        /* 설명. ArrayList iterator로 initRoom 진행할 것*/
//        initRoom(thirdFloorCenterAtticRoom);
//        initRoom(thirdFloorRightSecretRoom);
//        initRoom(secondFloorLeftStoreRoom);
//        initRoom(secondFloorCenterGuestRoom);
//        initRoom(secondFloorRightTerraceRoom);
//        initRoom(firstFloorLeftMainRoom);
//        initRoom(firstFloorCenterMasterRoom);
//        initRoom(firstFloorRightKitchenRoom);
//        initRoom(basementFloorLeftLaboratoryRoom);
//        initRoom(basementFloorCenterHallwayRoom);
//        initRoom(basementFloorTortureRoom);
//
//        setEscape();
//    }

    /* 설명. 방 초기화 코드.*/
    private void initRoom(char[][] room){
        for(int i=0;i<room.length;i++){
            for(int j=0;j<room[0].length;j++){
                /* 설명. 바깥열은 *로 감싸기(11로 선언하였으니 패딩값이 된다. */
                if(i==0 || j==0 || i==10 || j == 10){
                    room[i][j] = '*';
                }
                else{
                    room[i][j] = 'O';
                }
            }
        }
    }

    /* 설명. 각 방 별 출구 설정 */
    private void setEscape(){
        /* 설명. 출구 value값은 '1' */
        thirdFloorCenterAtticRoom[9][5] = '1';
        thirdFloorCenterAtticRoom[5][9] = '1';
        thirdFloorRightSecretRoom[1][5] = '1';
        
        secondFloorLeftStoreRoom[9][5] = '1';
        
        secondFloorCenterGuestRoom[1][5] = '1';
        secondFloorCenterGuestRoom[9][5] = '1';
        secondFloorCenterGuestRoom[5][1] = '1';
        secondFloorCenterGuestRoom[5][9] = '1';

        secondFloorRightTerraceRoom[1][5] = '1';

        firstFloorLeftMainRoom[9][5] = '1';

        firstFloorCenterMasterRoom[1][5] = '1';
        firstFloorCenterMasterRoom[9][5] = '1';
        firstFloorCenterMasterRoom[5][1] = '1';
        firstFloorCenterMasterRoom[5][9] = '1';

        firstFloorRightKitchenRoom[1][5] = '1';

        basementFloorLeftLaboratoryRoom[9][5] = '1';

        basementFloorCenterHallwayRoom[5][1] = '1';
        basementFloorCenterHallwayRoom[1][5] = '1';
        basementFloorCenterHallwayRoom[9][5] = '1';

        basementFloorTortureRoom[1][5] = '1';
    }


}
