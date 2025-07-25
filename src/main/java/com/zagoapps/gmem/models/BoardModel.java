package com.zagoapps.gmem.models;

import com.zagoapps.gmem.abstracts.Entity;
import com.zagoapps.gmem.enums.Directions;

import java.util.HashMap;

public class BoardModel {
    private final char[][] board;
    private final int width;
    private final int height;

    public BoardModel(int width, int height) {
        this.board = new char[height][width];
        this.width = width;
        this.height = height;

        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(i==0 || i==height-1) {
                    board[i][j] = '-';
                }
                else if(j==0 || j==width-1) {
                    board[i][j] = '|';
                }
                else {
                    board[i][j] = ' ';
                }
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void drawEntity(Entity entity) {
        for(int i = 0; i < entity.getHeight(); i++) {
            for(int j = 0; j < entity.getWidth(); j++) {
                this.board[entity.getY()+i][entity.getX()+j] = entity.getBody()[i][j];
            }
        }
    }

    public void clearPrevMovement(Entity entity, Directions direction) {
        HashMap<String, Integer> borderIndexes = new HashMap<>();

        borderIndexes.put("bottom", entity.getY()+entity.getHeight()-1);
        borderIndexes.put("top", entity.getY());
        borderIndexes.put("left", entity.getX());
        borderIndexes.put("right", entity.getX()+entity.getWidth()-1);

        switch(direction) {
            case UP:
                for(int i = 0; i < entity.getWidth(); i++) {
                    this.board[borderIndexes.get("bottom")][entity.getX()+i] = ' ';
                }
                break;
            case DOWN:
                for(int i = 0; i < entity.getWidth(); i++) {
                    this.board[borderIndexes.get("top")][entity.getX()+i] = ' ';
                }
                break;
            case LEFT:
                for(int i = 0; i < entity.getHeight(); i++) {
                    this.board[entity.getY()+i][borderIndexes.get("right")] = ' ';
                }
                break;
            case RIGHT:
                for(int i = 0; i < entity.getHeight(); i++) {
                    this.board[entity.getY()+i][borderIndexes.get("left")] = ' ';
                }
                break;
        }

        }


    public String getStringBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.height; i++) {
            for(int j = 0; j < this.width; j++) {
                sb.append(this.board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //AABB Collision detection
    public boolean checkCollision(Entity entity1, Entity entity2) {
        if(entity1.getX() < entity2.getX() + entity2.getWidth() &&
                entity1.getX() + entity1.getWidth() > entity2.getX() &&
                entity1.getY() < entity2.getY() + entity2.getHeight() &&
                entity1.getY() + entity1.getHeight() > entity2.getY()) {
            return true;
        }


        return false;
    }
}
