package Game;
import java.util.ArrayList;

public class Enemy {

    public Enemy(int x, int y) {
        enemyPosX = x;
        enemyPosY = y;
    }

    private int enemyPosX;
    private int enemyPosY;

    public int getEnemyPosX() { return enemyPosX; }
    public int getEnemyPosY() { return enemyPosY; }

    public void setEnemyPosX(int x) { enemyPosX = x; }
    public void setEnemyPosY(int y) { enemyPosY = y; }
}