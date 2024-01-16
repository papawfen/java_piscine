package Game;
import ChaseLogic.*;
public class Program {

    
    public static void main(String[] args) {
        // --enemiesCount=10 --wallsCount=10 --size=30 --profile=production
        int enemy = Integer.parseInt(args[0].split("=")[1]);
        int walls = Integer.parseInt(args[1].split("=")[1]);
        int size = Integer.parseInt(args[2].split("=")[1]);

        Map map = new Map(size, size, walls, enemy);
        PlayerMove player = new PlayerMove();
        map.generateMap();
        player.scanMoves(map);
    }
}