package model;

import javafx.scene.shape.Circle;

public class TrainMovementController {

    public TrainMovementController() {
    }

    public void moveTrain(Train train) {
        switch (train.getInitialPosition()) {
            case 0:
                moveTrainPosition0(train);
                break;
            case 1:
                moveTrainPosition1(train);
                break;
            case 2:
                moveTrainPosition2(train);
                break;
            case 3:
                moveTrainPosition3(train);
                break;
            default:
            break;
        }
    }
    
    public boolean checkColision(Train trem, Circle criticalzone) {

       if(trem.getTrainImage().getBoundsInParent().intersects(criticalzone.getBoundsInParent())){
           return true;
       }else{
            return false;
       }
        
    }

    private static void moveTrainPosition0(Train train) {
        // Logic for position 0
        if(train.getTrainImage().getLayoutY() < 30){
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 30 && train.getTrainImage().getLayoutY() < 145){
            train.getTrainImage().setRotate(250);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 145 && train.getTrainImage().getLayoutY() < 183){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 183 && train.getTrainImage().getLayoutY() < 300){
            train.getTrainImage().setRotate(245);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 300 && train.getTrainImage().getLayoutY() < 380){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 380 && train.getTrainImage().getLayoutY() < 480){
            train.getTrainImage().setRotate(310);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 480 && train.getTrainImage().getLayoutY() < 510){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 510 && train.getTrainImage().getLayoutY() < 590){
            train.getTrainImage().setRotate(320);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 590 && train.getTrainImage().getLayoutY() < 630){
            train.getTrainImage().setRotate(310);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());


        }else if(train.getTrainImage().getLayoutY() >= 630 && train.getTrainImage().getLayoutY() < 730){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 730){
            train.getTrainImage().setRotate(265);
            train.getTrainImage().setLayoutY(-76);
            train.getTrainImage().setLayoutX(203);
        }
    }

    private static void moveTrainPosition1(Train train) {
        // Logic for position 1
        if(train.getTrainImage().getLayoutY() < 30){
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 30 && train.getTrainImage().getLayoutY() < 145){
            train.getTrainImage().setRotate(285);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 145 && train.getTrainImage().getLayoutY() < 200){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 200 && train.getTrainImage().getLayoutY() < 290){
            train.getTrainImage().setRotate(295);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 290 && train.getTrainImage().getLayoutY() < 380){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 380 && train.getTrainImage().getLayoutY() < 480){
            train.getTrainImage().setRotate(230);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 480 && train.getTrainImage().getLayoutY() < 510){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 510 && train .getTrainImage().getLayoutY() < 585){
            train.getTrainImage().setRotate(220);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() >= 585 && train.getTrainImage().getLayoutY() < 620){
            train.getTrainImage().setRotate(230);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());
        }else if(train.getTrainImage().getLayoutY() >= 620 && train.getTrainImage().getLayoutY() < 730){
            train.getTrainImage().setRotate(270);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() + train.getSpeed());
        }else if(train.getTrainImage().getLayoutY() >= 730){
            train.getTrainImage().setRotate(275);
            train.getTrainImage().setLayoutY(-76);
            train.getTrainImage().setLayoutX(437);
        }
    }

    private static void moveTrainPosition2(Train train) {
        // Logic for position 2
        if(train.getTrainImage().getLayoutY() > 615){
            train.getTrainImage().setRotate(95);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 615 && train.getTrainImage().getLayoutY() > 500){
            train.getTrainImage().setRotate(145);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 500 && train.getTrainImage().getLayoutY() > 485){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 485 && train.getTrainImage().getLayoutY() > 380){
            train.getTrainImage().setRotate(135);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 380 && train.getTrainImage().getLayoutY() > 290){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 290 && train.getTrainImage().getLayoutY() > 180){
            train.getTrainImage().setRotate(45);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 180 && train.getTrainImage().getLayoutY() > 160){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 160 && train.getTrainImage().getLayoutY() > 45){
            train.getTrainImage().setRotate(40);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 45 && train.getTrainImage().getLayoutY() > -76){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= -76){
            train.getTrainImage().setRotate(95);
            train.getTrainImage().setLayoutY(719);
            train.getTrainImage().setLayoutX(210);
        }
    }

    private static void moveTrainPosition3(Train train) {
        // Logic for position 3
        if(train.getTrainImage().getLayoutY() > 615){
            train.getTrainImage().setRotate(85);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 615 && train.getTrainImage().getLayoutY() > 500){
            train.getTrainImage().setRotate(45);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 500 && train.getTrainImage().getLayoutY() > 485){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 485 && train.getTrainImage().getLayoutY() > 380){
            train.getTrainImage().setRotate(45);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 380 && train.getTrainImage().getLayoutY() > 290){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 290 && train.getTrainImage().getLayoutY() > 195){
            train.getTrainImage().setRotate(135);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 195 && train.getTrainImage().getLayoutY() > 160){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 160 && train.getTrainImage().getLayoutY() > 55){
            train.getTrainImage().setRotate(140);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());
            train.getTrainImage().setLayoutX(train.getTrainImage().getLayoutX() + train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= 55 && train.getTrainImage().getLayoutY() > -76){
            train.getTrainImage().setRotate(90);
            train.getTrainImage().setLayoutY(train.getTrainImage().getLayoutY() - train.getSpeed());

        }else if(train.getTrainImage().getLayoutY() <= -76){
            train.getTrainImage().setRotate(85);
            train.getTrainImage().setLayoutY(719);
            train.getTrainImage().setLayoutX(447);
        }
    }

}
