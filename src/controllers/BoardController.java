package controllers;

import abstracts.Entity;
import models.BoardModel;
import views.BoardView;

public class BoardController {
    private BoardModel model;
    private BoardView view;

    public BoardController(int width, int height) {
        this.model = new BoardModel(width, height);
        this.view = new BoardView(this.model);
    }

    public void drawEntity(Entity entity) { //this is cool
        model.drawEntity(entity);
        view.drawBoard();
    }
}
