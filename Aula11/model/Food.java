package model;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Food {
    private Position position;
    private Rectangle rectangle;
    private Color color = Color.GREEN;
    private AnchorPane pane;
    private Random random = new Random();
    private int size;


    public Food(double xPos, double yPos, AnchorPane pane, double size) {
        this.pane = pane;
        this.size = (int) size;
        position = new Position(xPos,yPos);
        rectangle = new Rectangle(position.getXPos(),position.getYPos(),size,size);
        rectangle.setFill(color);
        pane.getChildren().add(rectangle);
    }

    public Position getPosition() {
        return position;
    }

    public void moveFood(){
        getRandomSpotForFood();
    }

    public void getRandomSpotForFood(){
        int positionX = random.nextInt(12);
        int positionY = random.nextInt(12);
        rectangle.setX(positionX * size);
        rectangle.setY(positionY * size);

        position.setXPos(positionX * size);
        position.setYPos(positionY * size);
    }
}