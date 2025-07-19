package com.zagoapps.gmem;

import com.zagoapps.gmem.controllers.BoardController;
import com.zagoapps.gmem.controllers.PlayerController;
import com.zagoapps.gmem.models.PlayerModel;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;


public class Main implements Runnable {
    private BoardController boardController;
    private PlayerController playerController;

    public Main() {
        this.boardController = new BoardController(64,16);

        //example
        char[][] entity = new char[2][2];
        entity[0][0] = 'A';
        entity[0][1] = 'C';
        entity[1][0] = 'B';
        entity[1][1] = 'D';

        this.playerController = new PlayerController(new PlayerModel(5,5,entity),this.boardController,250);
    }


    public static void main(String[] args) {
        Main game = new Main();

        Thread gameThread = new Thread(game);
        gameThread.start();
    }

    //game loop
    @Override
    public void run() {
        while (true) {
            this.playerController.handleMovement();
            this.boardController.updateBoard();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}