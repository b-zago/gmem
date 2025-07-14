package views;

import models.BoardModel;

public class BoardView {
    public BoardView(BoardModel board) {
        System.out.println(board.buildBoard());
    }
}
