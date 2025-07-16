import controllers.PlayerController;
import models.BoardModel;
import models.PlayerModel;
import views.BoardView;

public class Main {
    public static void main(String[] args) {
        BoardModel model = new BoardModel(64,16);

        char[][] entity = new char[2][2];
        entity[0][0] = 'A';
        entity[0][1] = 'C';
        entity[1][0] = 'B';
        entity[1][1] = 'D';

        PlayerModel playerModel = new PlayerModel(5,5,entity);
        //PlayerController player = new PlayerController(playerModel);

        model.drawEntity(playerModel);

        //System.out.println(entity.length);
        //System.out.println(entity[0].length);

        BoardView view = new BoardView(model);
    }
}