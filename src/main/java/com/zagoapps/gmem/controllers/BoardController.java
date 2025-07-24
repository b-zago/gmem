package com.zagoapps.gmem.controllers;

import com.zagoapps.gmem.abstracts.Entity;
import com.zagoapps.gmem.enums.Directions;
import com.zagoapps.gmem.models.BoardModel;
import com.zagoapps.gmem.views.BoardView;

public class BoardController {
    private BoardModel model;
    private BoardView view;


    public BoardController(int width, int height) {
        this.model = new BoardModel(width, height);
        this.view = new BoardView(this.model.getStringBoard());

    }

    public int getBoardWidth() {
        return model.getWidth();
    }

    public int getBoardHeight() {
        return model.getHeight();
    }

    public void drawEntity(Entity entity) { //this is cool
        model.drawEntity(entity);
    }

    public void updateBoard() {
        view.updateBoard(model.getStringBoard());
    }

    public void clearPrevMovement(Entity entity, Directions direction) {
        model.clearPrevMovement(entity, direction);
    }

    public boolean checkCollision(Entity entity1, Entity entity2) {
        return model.checkCollision(entity1, entity2);
    }

}
