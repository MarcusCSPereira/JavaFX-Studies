package model;

import javafx.scene.paint.Color;

public class Data {

    private static final Data instance = new Data();

    private String text;
    private Color color;


    private Data() {
    }

    public static Data getInstance() {
        return instance;
    }

    public void setColor(Color color){this.color = color;}

    public Color getColor(){return this.color;}

    public void setText(String text) {this.text = text;}

    public String getText() {return this.text;}
}
