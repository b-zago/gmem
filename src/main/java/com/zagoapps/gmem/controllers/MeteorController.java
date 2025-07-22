package com.zagoapps.gmem.controllers;

import com.zagoapps.gmem.enums.Directions;
import com.zagoapps.gmem.models.MeteorModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MeteorController {
    private boolean shouldSpawn;
    private boolean shouldMove;
    private int toSpawnCounter;
    private int meteorRate;
    private int meteorSpeed;
    private int meteorToMoveCounter;
    private BoardController boardController;
    private ArrayList<MeteorModel> meteors;

    private char[][] meteorBody;

    public MeteorController(BoardController boardController, int meteorRate, int meteorSpeed) {
        this.meteorRate = meteorRate;
        this.meteorSpeed = meteorSpeed;
        this.shouldSpawn = true;
        this.shouldMove = false;
        this.meteorToMoveCounter = 0;
        this.toSpawnCounter = 0;
        this.boardController = boardController;
        this.meteors = new ArrayList<>();

        this.meteorBody = new char[1][1];
        this.meteorBody[0][0] = '*';
    }

    public void handleMeteors() {

        //move all meteors and check if any needs to be removed
        if(shouldMove) {
            for(int i = meteors.size()-1; i >= 0; i--) {


                MeteorModel m = meteors.get(i);

                boardController.clearPrevMovement(m,m.getDirection());
                m.move();

                switch(m.getDirection()) {
                    case UP:
                        if(m.getY() == 0) {
                            meteors.remove(i);
                            continue;
                        }
                        break;
                    case RIGHT:
                        if(m.getX() == boardController.getBoardWidth()-1) {
                            meteors.remove(i);
                            continue;
                        }
                        break;
                    case DOWN:
                        if(m.getY() == boardController.getBoardHeight()-1) {
                            meteors.remove(i);
                            continue;
                        }
                        break;
                    case LEFT:
                        if(m.getX() == 0) {
                            meteors.remove(i);
                            continue;
                        }
                        break;
                }



                boardController.drawEntity(m);
            }
            this.shouldMove = false;
        }

        if(this.meteorToMoveCounter == this.meteorSpeed) {
            this.meteorToMoveCounter = 0;
            this.shouldMove = true;
        }


        if(this.toSpawnCounter == this.meteorRate) {
            this.toSpawnCounter = 0;
            this.shouldSpawn = true;
        }

        this.meteorToMoveCounter++;

        if(shouldSpawn) {
            Directions dir = Directions.values()[(int)(Math.random() * Directions.values().length)];

            int x = 0;
            int y = 0;

            switch(dir) {
                case UP:
                    y = boardController.getBoardHeight()-2;
                    x = 1 + (int)(Math.random() * (boardController.getBoardWidth() - 2));
                    meteors.add(new MeteorModel(x,y,meteorBody,dir));
                    break;
                case RIGHT:
                    x = 1;
                    y = 1 + (int)(Math.random() * (boardController.getBoardHeight() - 2));
                    meteors.add(new MeteorModel(x,y,meteorBody,dir));
                    break;
                case DOWN:
                    y = 1;
                    x = 1 + (int)(Math.random() * (boardController.getBoardWidth() - 2));
                    meteors.add(new MeteorModel(x,y,meteorBody,dir));
                    break;
                case LEFT:
                    x = boardController.getBoardWidth()-2;
                    y = 1 + (int)(Math.random() * (boardController.getBoardHeight() - 2));
                    meteors.add(new MeteorModel(x,y,meteorBody,dir));
                    break;
            }

            boardController.drawEntity(meteors.get(meteors.size()-1));

//            int x = (int) (Math.random() * boardController.getBoardWidth());
//            int y = (int) (Math.random() * boardController.getBoardHeight());

            //meteors.add(new MeteorModel(x,y,meteorBody,dir));

            this.shouldSpawn = false;

            return;
        }

        this.toSpawnCounter++;
    }

}
