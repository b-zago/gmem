package abstracts;

public abstract class Entity {
    private int x;
    private int y;
    private char[][] body;

    public Entity(int x, int y, char[][] body) {
        this.x = x;
        this.y = y;
        this.body = body;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public char[][] getBody() {
        return body;
    }
}
