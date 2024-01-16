package edu.school21.app.tanks;

import edu.school21.app.tanks.models.Player;
import edu.school21.app.tanks.models.Shoot;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import static java.lang.System.out;

public class Program extends Application {
    public static Stage mainStage;
    public static Canvas canvas;
    public static Player player;
    public static Player enemy;
    public static GraphicsContext gc;
    private static final int SPEED = 10;
    public static String lastKey = "s";
    public static AnimationTimer animationTimer;
    private static BufferedReader in;
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public static boolean canPlay = true;
    public static boolean canConnect= false;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setTitle("Tanks");

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        canvas = new Canvas(1024, 1024);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.DARKRED);
        Image background = new Image("field.png");
        gc.drawImage(background, 0, 0);
        player = new Player("player.png", 480, 850, root, 20, 980, gc);
        enemy = new Player("enemy.png", 480, 72, root, 700, 20, gc);
        stage.show();

        scene.setOnKeyPressed(event -> {
            String code = event.getCode().toString();
            keys.put(event.getCode(), true);
            lastKey = code;
        });
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                try {
                    if (canPlay) {
                        if (!enemy.checkLife()) {
                            enemy.kill();
                            End("win.png");
                        } else if (!player.checkLife()) {
                            player.kill();
                            End("lose.png");
                        }
                        updatePlayer();
                        updateEnemy();
                        updateBullet();
                        gc.clearRect(0, 0, 1024, 1024);
                        gc.drawImage(background, 0, 0);
                        player.render(gc);
                        enemy.render(gc);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        animationTimer.start();
    }


    public void updatePlayer() throws IOException {
        if (player.canMove("right") && (isPressed(KeyCode.D))) {
            player.moveRight(SPEED);
            out.println("right");
        } else if (player.canMove("left") && (isPressed(KeyCode.A))) {
            player.moveLeft(SPEED);
            out.println("left");
        }
    }

    private void updateBullet() throws IOException {
        if (keys.containsKey(KeyCode.SPACE)) {
            outShoot("playerBullet.png", player, enemy, 0);
            keys.remove(KeyCode.SPACE);
            out.println("shoot");
        } else if (keys.containsKey(KeyCode.SHIFT)) {
            outShoot("enemyBullet.png", enemy, player, 100);
            keys.remove(KeyCode.SHIFT);
            out.println("shoot");
        }
    }

    private void outShoot(String img, Player player, Player enemy, double forCorrect) {
        Shoot shoot = new Shoot(player, img, gc, enemy, forCorrect);
        shoot.start();
    }

    public void updateEnemy() throws IOException {
        if (enemy.canMove("right") && isPressed(KeyCode.RIGHT)) {
            enemy.moveRight(SPEED);
            out.println("right");
        } else if (enemy.canMove("left") && isPressed(KeyCode.LEFT)) {
            enemy.moveLeft(SPEED);
            out.println("left");
        }
    }

    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    public void End(String image) {
        animationTimer.stop();
        Stage stage = new Stage();
        stage.setTitle("Tanks");
        stage.setX(mainStage.getX());
        stage.setY(mainStage.getY());
        mainStage.close();

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        canvas = new Canvas(1024, 1024);
        root.getChildren().add(canvas);

        Image background = new Image("field.png");
        GraphicsContext gc2 = canvas.getGraphicsContext2D();
        gc2.drawImage(background, 0, 0);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                if (image.equals("win.png")) {
                    gc2.drawImage(new Image("boom.png"), enemy.getPositionX(), enemy.getPositionY());
                    gc2.drawImage(new Image("player.png"), player.getPositionX(), player.getPositionY());
                } else {
                    gc2.drawImage(new Image("boom.png"), player.getPositionX(), player.getPositionY());
                    gc2.drawImage(new Image("enemy.png"), enemy.getPositionX(), enemy.getPositionY());
                }
                gc2.drawImage(new Image(image), 350, 350);
            }
        }.start();
        stage.show();
    }

    public static void main(String[] args) { launch();}

}