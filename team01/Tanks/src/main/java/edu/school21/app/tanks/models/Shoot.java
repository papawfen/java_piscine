package edu.school21.app.tanks.models;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Shoot extends AnimationTimer {
    private Image image;

    Player enemy;
    private double positionX;
    private double positionY;
    private double speed;
    private double width;
    private double height;
    private boolean isShooter;
    private GraphicsContext gc;

    public Shoot(Player player, String image, GraphicsContext gc, Player enemy, double forCorrect) {
        this.positionX = (player.getPositionX() + player.getBoundary().getMaxX()) / 2;
        this.positionY = player.getPositionY() + forCorrect;
        this.isShooter = forCorrect == 0;
        this.enemy = enemy;
        this.gc = gc;
        if (positionY == 850) {
            speed = -7;
        } else {
            speed = 7;
        }
        setImage(new Image(image));
    }

    public double getPositionY() {
        return positionY;
    }

    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void render()    {
        gc.drawImage( image, positionX, positionY );
    }

    public void move() {
        positionY += speed;
    }
    public Rectangle2D getBoundary()    {
        return new Rectangle2D(positionX,positionY,width,height);
    }


    @Override
    public void handle(long l) {
        if (this.getPositionY() + 10 >= 1042 || this.getPositionY() - 10 <= 0) {
            this.stop();
        } else if (enemy.getBoundary().intersects(this.getBoundary())) {
            enemy.takeDamage();
            if (isShooter)
                System.out.println("hit");
            if (!enemy.checkLife()) {
                this.stop();
            }
            this.stop();
        } else {
            this.move();
            this.render();
        }
    }

}
