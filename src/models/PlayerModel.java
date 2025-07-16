package models;

import abstracts.Entity;

public class PlayerModel extends Entity {
    private int moveDirection;

    public PlayerModel(int x, int y, char[][] body) {
        super(x, y, body);
    }


    public void move(int moveDirection) {
        this.moveDirection = moveDirection;
    }
}
