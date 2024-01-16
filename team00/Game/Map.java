package Game;
import Game.Enemy;
import java.util.Random;

public class Map {

    public Map(int x, int y, int walls, int enemy) {
        sizeX = x;
        sizeY = y;
        enemies = enemy;
        obstacles = walls;
        map = new char[sizeX][sizeY];
        arr = new Enemy[enemy];
    }

    public void setSizeX(int x) { sizeX = x; }
    public void setSizeY(int y) { sizeY = y; }
    public void setObstacles(int count) { obstacles = count; }
    public void setEnemies(int count) { enemies = count; }

    public void setMapPosPlayer(int x, int y) { map[x][y] = 'o'; }
    public void setMapPosEnemy(int x, int y) { map[x][y] = 'X'; }
    public void setMapPreviosTurn(int x, int y) { map[x][y] = '.'; }
    public int getMapSize() { return sizeX; }
    public char getMapPos(int x, int y) { return map[x][y]; }
    public Enemy getEnemyArr(int i) { return arr[i]; }
    public int getEnemy() { return enemies; }

    private int sizeX;
    private int sizeY;
    private int obstacles;
    private int enemies;
    private char map[][];
    private Enemy arr[];

    public void printMap() {
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                if (getMapPos(i, j) == 'X') {
                    System.out.print("\u001B[41m");
                } else if (getMapPos(i, j) == 'o') {
                    System.out.print("\u001B[42m");
                } else if (getMapPos(i, j) == '#') {
                    System.out.print("\u001B[45m");
                } else if (getMapPos(i, j) == '0') {
                    System.out.print("\u001B[44m");
                } else if (getMapPos(i, j) == '.') {
                    System.out.print("\u001B[43m");
                }
                    System.out.print(map[i][j]);
            }
            System.out.print("\033[0m" + "\n");
        }
        }


    public void generateMap() {
        for (int i = 0; i < sizeX; ++i) {
            for (int j = 0; j < sizeY; ++j) {
                map[i][j] = '.';
            }
        }
        generateWalls(map);
        generatePlayer(map);
        generateTarget(map);
    }

    public void generateWalls(char map[][]) {
        Random n = new Random();
        for (int i = 0; i < obstacles; ++i) {
                map[n.nextInt(sizeX - 3) + 1][n.nextInt(sizeX - 3) + 1] = '#';
        }
    }

    public void generatePlayer(char map[][]) {
        Random n = new Random();
        int playerStart = Math.abs(n.nextInt(3));
        int pos = n.nextInt(sizeY);
        switch (playerStart) {
            case 0:
                map[0][pos] = 'o';
                Player.getPlayer().setPosX(0);
                Player.getPlayer().setPosY(pos);
                break;
            case 1:
                map[pos][sizeY - 1] = 'o';
                Player.getPlayer().setPosX(pos);
                Player.getPlayer().setPosY(sizeY - 1);
                break;
            case 2:
                map[sizeX - 1][pos] = 'o';
                Player.getPlayer().setPosX(sizeX - 1);
                Player.getPlayer().setPosY(pos);
                break;
            case 3:
                map[pos][0] = 'o';
                Player.getPlayer().setPosX(pos);
                Player.getPlayer().setPosY(0);
                break;
        }
        generateEnemies(playerStart, map);
    }

    public void generateEnemies(int playerStart, char map[][]) {
        Random n = new Random();
        int k = 0;
        int enemyCount = enemies;
        while (enemyCount > 0) {
            int enemyStart = Math.abs(n.nextInt(3));
            if (enemyStart != playerStart) {
                for (int j = 0; j < 2; ++j) {
                    if (enemyCount == 0) {
                        break;
                    }
                    int pos = n.nextInt(sizeY);
                    if (sizeY == pos) pos -= 1;
                    switch (enemyStart) {
                        case 0:
                            if (map[0][pos] == 'X') break;
                            map[0][pos] = 'X';
                            Enemy enemy = new Enemy(0, pos);
                            arr[k] = enemy;
                            k++;
                            --enemyCount;
                            break;
                        case 1:
                            if (map[pos][sizeY - 1] == 'X') break;
                            map[pos][sizeY - 1] = 'X';
                            Enemy enemy1 = new Enemy(pos, sizeY - 1);
                            arr[k] = enemy1;
                            k++;
                            --enemyCount;
                            break;
                        case 2:
                            if (map[sizeX - 1][pos] == 'X') break;
                            map[sizeX - 1][pos] = 'X';
                            Enemy enemy2 = new Enemy(sizeX - 1, pos);
                            arr[k] = enemy2;
                            k++;
                            --enemyCount;
                            break;
                        case 3:
                            if (map[pos][0] == 'X') break;
                            map[pos][0] = 'X';
                            Enemy enemy3 = new Enemy(pos, 0);
                            arr[k] = enemy3;
                            k++;
                            --enemyCount;
                            break;
                    }
                }
            }
        }
    }

    public void generateTarget(char map[][]) {
        Random n = new Random();
        while(true) {
            int x = n.nextInt(sizeX - 3) + 1;
            int y = n.nextInt(sizeX - 3) + 1;
            if (map[x][y] != '#') {
                map[x][y] = '0';
                break;
            }
        }
    }
}



