package models;

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

    public String buildBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.height; i++) {
            for(int j = 0; j < this.width; j++) {
                sb.append(this.board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
