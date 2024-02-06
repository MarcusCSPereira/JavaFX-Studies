package model;

import javafx.scene.shape.Rectangle;

public class Component {

    private Rectangle rectangle;
    private int startPositionX;
    private int startPositionY;

    public Component(int size, int startPositionX, int startPositionY) {
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;
        rectangle = new Rectangle(startPositionX, startPositionY, size, size);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }
}