package com.zagoapps.gmem;

import com.zagoapps.gmem.controllers.BoardController;
import com.zagoapps.gmem.controllers.MeteorController;
import com.zagoapps.gmem.controllers.PlayerController;
import com.zagoapps.gmem.models.MeteorModel;
import com.zagoapps.gmem.models.PlayerModel;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;


public class Main {
    private BoardController boardController;
    private PlayerController playerController;
    private MeteorController meteorController;

    public Main() {
        this.boardController = new BoardController(32,16);

        //example
        char[][] entity = new char[2][2];
        entity[0][0] = 'A';
        entity[0][1] = 'A';
        entity[1][0] = 'A';
        entity[1][1] = 'A';

        //the more the speed the slower
        this.playerController = new PlayerController(new PlayerModel(5,5,entity),this.boardController,2);
        this.meteorController = new MeteorController(this.boardController, 20,3);
    }


    public static void main(String[] args) {
        Main game = new Main();

        boolean running = true;

        while (running) {

            for(MeteorModel m : game.meteorController.getMeteors()) {
                if(game.boardController.checkCollision(game.playerController.getPlayerModel(), m)) {
                    running = false;
                    break;
                }
            }

            game.meteorController.handleMeteors();
            game.playerController.handleMovement();
            game.boardController.updateBoard();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Game over");


    }


}