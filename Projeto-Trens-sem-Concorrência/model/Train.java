package model;

import javafx.scene.image.ImageView;

public class Train {
    
    private double speed;
    private ImageView trainImage;
    private int initialPosition;
    private boolean inCriticalZone = false;

    public Train( ImageView trainImage, int initialPosition) {
        this.trainImage = trainImage;
        this.initialPosition = initialPosition;

        switch (this.initialPosition) {
            case 0:
                trainImage.setLayoutX(203);
                trainImage.setLayoutY(-76);
                trainImage.setRotate(265);
                break;
            case 1:
                trainImage.setLayoutX(437);
                trainImage.setLayoutY(-78);
                trainImage.setRotate(275);
                break;
            case 2:
                trainImage.setLayoutX(210);
                trainImage.setLayoutY(719);
                trainImage.setRotate(95);
                break;
            case 3:
                trainImage.setLayoutX(447);
                trainImage.setLayoutY(719);
                trainImage.setRotate(85);
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public ImageView getTrainImage() {
        return trainImage;
    }

    public int getInitialPosition() {
        return initialPosition;
    }

    public boolean isInCriticalZone() {
        return inCriticalZone;
    }

    public void setInCriticalZone(boolean inCriticalZone) {
        this.inCriticalZone = inCriticalZone;
    }



}
