package com.zagoapps.gmem.controllers;

import com.zagoapps.gmem.Main;
import com.zagoapps.gmem.enums.Directions;
import com.zagoapps.gmem.models.PlayerModel;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.io.Reader;

public class PlayerController implements Runnable {
    final private PlayerModel model;
    final private BoardController boardController;
    final private int playerSpeed;
    private int toMoveCounter;
    private boolean shouldMove;
    private volatile char playerInput;

    public PlayerController(PlayerModel model, BoardController boardController, int playerSpeed) {
        this.playerSpeed = playerSpeed;
        this.model = model;
        this.boardController = boardController;
        this.toMoveCounter = 0;
        this.shouldMove = false;

        boardController.drawEntity(this.model);

        Thread inputThread = new Thread(this);
        inputThread.start();
    }

    public PlayerModel getPlayerModel() {
        return model;
    }

    public void handleMovement() {

        switch (this.playerInput) {
            case 'w':
                if(model.getY() > 1)
                {
                    if(shouldMove)
                    {
                        this.boardController.clearPrevMovement(model,Directions.UP);
                        this.model.move(Directions.UP);
                        this.boardController.drawEntity(model);
                        this.shouldMove = false;
                    }
                    this.toMoveCounter++;
                }
                break;
            case 'a':
                if(model.getX() > 1)
                {
                    if(shouldMove) {
                        this.boardController.clearPrevMovement(model, Directions.LEFT);
                        this.model.move(Directions.LEFT);
                        this.boardController.drawEntity(model);
                        this.shouldMove = false;
                    }
                    this.toMoveCounter++;
                }
                break;
            case 's':
                if(model.getY()+ model.getHeight() < boardController.getBoardHeight()-1)
                {
                    if(shouldMove) {
                        this.boardController.clearPrevMovement(model, Directions.DOWN);
                        this.model.move(Directions.DOWN);
                        this.boardController.drawEntity(model);
                        this.shouldMove = false;
                    }
                    this.toMoveCounter++;
                }
                break;
            case 'd':
                if(model.getX()+ model.getWidth() < boardController.getBoardWidth()-1)
                {
                    if(shouldMove) {
                        this.boardController.clearPrevMovement(model, Directions.RIGHT);
                        this.model.move(Directions.RIGHT);
                        this.boardController.drawEntity(model);
                        this.shouldMove = false;
                    }
                    this.toMoveCounter++;
                }
                break;
        }

        if(this.toMoveCounter == this.playerSpeed)
        {
            this.shouldMove = true;
            this.toMoveCounter = 0;
        }
    }


    @Override
    public void run() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            terminal.enterRawMode();

            // Read characters
            int c;
            while (true) {

                c = terminal.reader().read();
                this.playerInput = (char) c;
                Thread.sleep(10);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
