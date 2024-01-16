package Game;
import Game.Map;
import ChaseLogic.*;
import java.util.Scanner;

public class PlayerMove {

    public PlayerMove() {}

    public void scanMoves(Map map) {
        String move = "";
        EnemyMove enemy = new EnemyMove();
        map.printMap();
        while(!move.equals("exit")) {
            Scanner input = new Scanner (System.in);
            move = input.nextLine();
            int x = Player.getPlayer().getPosX();
            int y = Player.getPlayer().getPosY();
            if (move.equals("w")) {
                if (x - 1 < 0) continue;
                if (checkMove(map, x - 1, y)) continue;
                map.setMapPreviosTurn(x, y);
                map.setMapPosPlayer(x - 1, y);
                Player.getPlayer().setPosX(x - 1);
            } else if (move.equals("a")) {
                if (y - 1 < 0) continue;
                if (checkMove(map, x, y - 1)) continue;
                map.setMapPreviosTurn(x, y);
                map.setMapPosPlayer(x, y - 1);
                Player.getPlayer().setPosY(y - 1);
            } else if (move.equals("s")) {
                if (x > map.getMapSize() - 1) continue;
                if (checkMove(map, x + 1, y)) continue;
                map.setMapPreviosTurn(x, y);
                map.setMapPosPlayer(x + 1, y);
                Player.getPlayer().setPosX(x + 1);
            } else if (move.equals("d")) {
                if (y > map.getMapSize() - 1) continue;
                if (checkMove(map, x, y + 1)) continue;
                map.setMapPreviosTurn(x, y);
                map.setMapPosPlayer(x, y + 1);
                Player.getPlayer().setPosY(y + 1);
            }
            enemy.EnemyMoves(map);
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            map.printMap();
        }
    }

    public boolean checkMove(Map map, int x, int y) {
        boolean result = false;
        if (map.getMapPos(x, y) == '0') {
            System.out.println("CONRATULTIONS!");
            System.exit(1);
        } else if (map.getMapPos(x, y) == 'X') {
            System.out.println("LOOSER!");
            System.exit(1);
        } if (map.getMapPos(x, y) == '#') {
            result = true;
        }
        return result;
    }
}