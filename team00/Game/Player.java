package Game;
public class Player {

    private static Player player;

    private Player() { 
        playerPosX = 0;
        playerPosY = 0;
    }

    public static Player getPlayer() {
        if (player == null) player = new Player();
        return player;
    }

    public void setPosX(int x) { playerPosX = x; }
    public void setPosY(int y) { playerPosY = y; }

    public int getPosX() { return playerPosX; }
    public int getPosY() { return playerPosY; }

    private int playerPosX;
    private int playerPosY;
}