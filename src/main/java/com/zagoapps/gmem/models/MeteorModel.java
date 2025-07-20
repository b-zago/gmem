package com.zagoapps.gmem.models;

import com.zagoapps.gmem.abstracts.Entity;
import com.zagoapps.gmem.enums.Directions;

public class MeteorModel extends Entity {
    private Directions direction;

    public MeteorModel(int x, int y, char[][] body, Directions direction) {
        super(x, y, body);
        this.direction = direction;
    }

    public void move() {
        switch (this.direction) {
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
