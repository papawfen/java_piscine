package ChaseLogic;
import Game.*;

public class EnemyMove {
    public EnemyMove() {}

    private int px;
    private int py;

    public void EnemyMoves(Map map) {
        
        px = Player.getPlayer().getPosX();
        py = Player.getPlayer().getPosY();
        for (int i = 0; i < map.getEnemy(); ++i) {
            int x = map.getEnemyArr(i).getEnemyPosX();
            int y = map.getEnemyArr(i).getEnemyPosY();
            checkStartPosX(map, x ,y, i);
        }
    }

    public void checkStartPosX(Map map, int x, int y, int i) {
        if (x == map.getMapSize() - 1) {
            if (checkWalls(map, x - 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x - 1, y);
            map.getEnemyArr(i).setEnemyPosX(x - 1);
        } else if (y == 0) {
            if (checkWalls(map, x, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y + 1);
            map.getEnemyArr(i).setEnemyPosY(y + 1);
        } else if (y == map.getMapSize() - 1) {
            if (checkWalls(map, x, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y - 1);
            map.getEnemyArr(i).setEnemyPosY(y - 1);
        } else if (x == 0) {
            if (checkWalls(map, x, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x + 1, y);
            map.getEnemyArr(i).setEnemyPosX(x + 1);
        } else {
            checkNextPos(map, x, y, i);
        }
    }

    public boolean checkWalls(Map map, int x, int y) {
        boolean result = false;
        if (map.getMapPos(x, y) == 'o') {
            System.out.println("LOOSER!");
            System.exit(1);
        } if (map.getMapPos(x, y) == '#' || map.getMapPos(x, y) == '0' || map.getMapPos(x, y) == 'X') {
            result = true;
        }
        return result;
    }

    public void checkNextPos(Map map, int x, int y, int i) {
        if (px <= map.getMapSize() / 2 && py <= map.getMapSize() / 2) {
            enemyCheckPos(map, x, y, 0, i);
        } else if (px <= map.getMapSize() / 2 && py >= map.getMapSize() / 2) {
            enemyCheckPos(map, x, y, 1, i);
        } else if (px >= map.getMapSize() / 2 && py <= map.getMapSize() / 2) {
            enemyCheckPos(map, x, y, 2, i);
        } else if (px >= map.getMapSize() / 2 && py >= map.getMapSize() / 2) {
            enemyCheckPos(map, x, y, 3, i);
        }
    }

    public void enemyCheckPos(Map map, int x, int y, int playerQuarter, int i) {
        if (x <= map.getMapSize() / 2 && y <= map.getMapSize() / 2) {
            enemyMovePos(map, x, y, playerQuarter, 0, i);
        } else if (x <= map.getMapSize() / 2 && y >= map.getMapSize() / 2) {
            enemyMovePos(map, x, y, playerQuarter, 1, i);
        } else if (x >= map.getMapSize() / 2 && y <= map.getMapSize() / 2) {
            enemyMovePos(map, x, y, playerQuarter, 2, i);
        } else if (x >= map.getMapSize() / 2 && y >= map.getMapSize() / 2) {
            enemyMovePos(map, x, y, playerQuarter, 3, i);
        }
    }

    public void enemyMovePos(Map map, int x, int y, int playerQuarter, int enemyQuarter, int i) {
        if (playerQuarter == enemyQuarter) {
            if (checkWalls(map, x, y)) return;

        } else if (playerQuarter == 0 && enemyQuarter == 1 ) {
            if (checkWalls(map, x, y - 1)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y - 1);
            map.getEnemyArr(i).setEnemyPosY(y - 1);
        } else if (playerQuarter == 0 && enemyQuarter == 2) {
            if (checkWalls(map, x - 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x - 1, y);
            map.getEnemyArr(i).setEnemyPosX(x - 1);
        } else if (playerQuarter == 0 && enemyQuarter == 3) {
            if (checkWalls(map, x, y + 1)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y + 1);
            map.getEnemyArr(i).setEnemyPosY(y + 1);
        } else if (playerQuarter == 1 && enemyQuarter == 0) {
            if (checkWalls(map, x, y + 1)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y + 1);
            map.getEnemyArr(i).setEnemyPosY(y + 1);
        } else if (playerQuarter == 1 && enemyQuarter == 2) {
            if (checkWalls(map, x + 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x + 1, y);
            map.getEnemyArr(i).setEnemyPosX(x + 1);
        } else if (playerQuarter == 1 && enemyQuarter == 3) {
            if (checkWalls(map, x - 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x - 1, y);
            map.getEnemyArr(i).setEnemyPosX(x - 1);
        } else if (playerQuarter == 2 && enemyQuarter == 0) {
            if (checkWalls(map, x - 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x - 1, y);
            map.getEnemyArr(i).setEnemyPosX(x + 1);
        } else if (playerQuarter == 2 && enemyQuarter == 1) {
            if (checkWalls(map, x + 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x + 1, y);
            map.getEnemyArr(i).setEnemyPosX(x + 1);
        } else if (playerQuarter == 2 && enemyQuarter == 3) {
            if (checkWalls(map, x, y - 1)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x, y - 1);
            map.getEnemyArr(i).setEnemyPosY(y - 1);
        } else if (playerQuarter == 3 && enemyQuarter == 0) {
            if (checkWalls(map, x - 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x - 1, y);
            map.getEnemyArr(i).setEnemyPosX(x - 1);
        } else if (playerQuarter == 3 && enemyQuarter == 1) {
            if (checkWalls(map, x + 1, y)) return;
            map.setMapPreviosTurn(x, y);
            map.setMapPosEnemy(x + 1, y);
            map.getEnemyArr(i).setEnemyPosX(x + 1);
        } else if (playerQuarter == 3 && enemyQuarter == 2) {
            map.setMapPreviosTurn(x, y + 1);
            map.setMapPosEnemy(x, y + 1);
            map.getEnemyArr(i).setEnemyPosY(y + 1);
        }
    }
}