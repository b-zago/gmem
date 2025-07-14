import models.BoardModel;
import views.BoardView;

public class Main {
    public static void main(String[] args) {
        new BoardView(new BoardModel(64,16));
    }
}