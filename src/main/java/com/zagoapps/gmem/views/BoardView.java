package com.zagoapps.gmem.views;

import com.zagoapps.gmem.models.BoardModel;

public class BoardView {
    //private final BoardModel board;
    private String board;
    public BoardView(String board) {
        this.board = board;
        //System.out.print(this.board.getStringBoard());

    }


    public void updateBoard(String board) {
        this.board = board;
        System.out.print("\033[" + "H");
        System.out.print(board);
    }
}
