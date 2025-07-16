package views;

import models.BoardModel;

public class BoardView {
    private BoardModel board;
    public BoardView(BoardModel board) {
        this.board = board;
        System.out.println(this.board.drawBoard());
    }

    public void drawBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(this.board.drawBoard());
    }
}
