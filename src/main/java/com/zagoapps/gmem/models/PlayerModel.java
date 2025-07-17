package com.zagoapps.gmem.models;

import com.zagoapps.gmem.abstracts.Entity;
import com.zagoapps.gmem.enums.Directions;

public class PlayerModel extends Entity {

    public PlayerModel(int x, int y, char[][] body) {
        super(x, y, body);
    }


    public void move(Directions direction) {
        switch (direction) {
            case UP:
                setY(getY() - 1);
                break;
            case DOWN:
                setY(getY() + 1);
                break;
            case LEFT:
                setX(getX() - 1);
                break;
            case RIGHT:
                setX(getX() + 1);
                break;
        }

    }


}
