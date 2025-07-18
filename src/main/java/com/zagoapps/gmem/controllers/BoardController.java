package com.zagoapps.gmem.controllers;

import com.zagoapps.gmem.abstracts.Entity;
import com.zagoapps.gmem.enums.Directions;
import com.zagoapps.gmem.models.BoardModel;
import com.zagoapps.gmem.views.BoardView;

public class BoardController implements Runnable {
    private BoardModel model;
    private BoardView view;


    public BoardController(int width, int height) {
        this.model = new BoardModel(width, height);
        this.view = new BoardView(this.model.getStringBoard());

        Thread boardThread = new Thread(this);
        boardThread.start();
    }

    public int getBoardWidth() {
        return model.getWidth();
    }

    public int getBoardHeight() {
        return model.getHeight();
    }

    public void drawEntity(Entity entity) { //this is cool
        model.drawEntity(entity);
        //view.updateBoard(model.getStringBoard());
    }

    public void clearPrevMovement(Entity entity, Directions direction) {
        model.clearPrevMovement(entity, direction);
    }

    public void run() {
        while (true) {
            view.updateBoard(model.getStringBoard());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
