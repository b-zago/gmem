package com.zagoapps.gmem.controllers;

import com.zagoapps.gmem.enums.Directions;
import com.zagoapps.gmem.models.MeteorModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MeteorController {
    private boolean shouldSpawn;
    private int toSpawnCounter;
    private int meteorSpeed;
    private BoardController boardController;
    private Queue<MeteorModel> meteors;

    private char[][] meteorBody;

    public MeteorController(BoardController boardController) {
        this.shouldSpawn = true;
        this.toSpawnCounter = 0;
        this.boardController = boardController;
        this.meteors = new LinkedList<>();

        this.meteorBody = new char[1][1];
        this.meteorBody[0][0] = '*';
    }

    public void handleMeteors() {
        if(shouldSpawn) {
            Directions dir = Directions.values()[(int)(Math.random() * Directions.values().length)];
            int x = (int) (Math.random() * boardController.getBoardWidth());
            int y = (int) (Math.random() * boardController.getBoardHeight());

            meteors.add(new MeteorModel(x,y,meteorBody,dir));

            this.shouldSpawn = false;

            return;
        }

        if(meteors.size() > 0) {
            //move all meteors and check if any needs to be removed
        }

        if(this.toSpawnCounter == this.meteorSpeed) {
            this.toSpawnCounter = 0;
            this.shouldSpawn = true;
        }

        this.toSpawnCounter++;
    }






}
