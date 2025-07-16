package controllers;

import models.PlayerModel;

public class PlayerController {
    final private PlayerModel model;

    public PlayerController(PlayerModel model) {
        this.model = model;
    }

    public char[][] getBody() {
        return model.getBody();
    }

}
