package com.zagoapps.gmem.controllers;

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

    public PlayerController(PlayerModel model, BoardController boardController, int playerSpeed) {
        this.playerSpeed = playerSpeed;
        this.model = model;
        this.boardController = boardController;

        boardController.drawEntity(this.model);

        Thread inputThread = new Thread(this);
        inputThread.start();
    }

    @Override
    public void run() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            NonBlockingReader reader = terminal.reader();
            
            // Read characters
            int c;
            while (true) {
                c = reader.read(this.playerSpeed);

                if (c == 'q') break;

                if (c == -1) {
                    //No input
                    continue;
                }

                switch (c) {
                    //ASCII w
                    case 'w':
                        this.boardController.clearPrevMovement(model,Directions.UP);
                        this.model.move(Directions.UP);
                        this.boardController.drawEntity(model);
                        break;
                    //ASCII a
                    case 'a':
                        this.boardController.clearPrevMovement(model,Directions.LEFT);
                        this.model.move(Directions.LEFT);
                        this.boardController.drawEntity(model);
                        break;
                    //ASCII s
                    case 's':
                        this.boardController.clearPrevMovement(model,Directions.DOWN);
                        this.model.move(Directions.DOWN);
                        this.boardController.drawEntity(model);
                        break;
                    //ASCII d
                    case 'd':
                        this.boardController.clearPrevMovement(model,Directions.RIGHT);
                        this.model.move(Directions.RIGHT);
                        this.boardController.drawEntity(model);
                        break;
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
