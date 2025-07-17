package com.zagoapps.gmem;

import com.zagoapps.gmem.controllers.BoardController;
import com.zagoapps.gmem.controllers.PlayerController;
import com.zagoapps.gmem.models.PlayerModel;


public class Main {
    public static void main(String[] args) {
        BoardController boardController = new BoardController(64,16);

        char[][] entity = new char[2][2];
        entity[0][0] = 'A';
        entity[0][1] = 'C';
        entity[1][0] = 'B';
        entity[1][1] = 'D';

        PlayerController player = new PlayerController(new PlayerModel(5,5,entity),boardController,250);



        //PlayerModel playerModel = new PlayerModel(5,5,entity);
        //PlayerController player = new PlayerController(playerModel);

        //boardController.drawEntity(playerModel);

        //System.out.println(entity.length);
        //System.out.println(entity[0].length);




    }
}