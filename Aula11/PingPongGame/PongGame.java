package PingPongGame;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongGame extends Application {
	
	//variable
	private static final int width = 800;
	private static final int height = 600;
	private static final int PLAYER_HEIGHT = 100;
	private static final int PLAYER_WIDTH = 15;
	private static final double BALL_R = 15;
    private int ballbounce = 0;
	private int ballYSpeed = 1;
	private int ballXSpeed = 1;
	private double playerOneYPos = height / 2;
	private double playerTwoYPos = height / 2;
	private double ballXPos = width / 2;
	private double ballYPos = height / 2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	private boolean gameStarted;
	private int playerOneXPos = 0;
	private double playerTwoXPos = width - PLAYER_WIDTH;
		
	public void start(Stage stage) throws Exception {
		stage.setTitle("P O N G");
		//background size
		Canvas canvas = new Canvas(width, height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		//JavaFX Timeline = free form animation defined by KeyFrames and their duration 
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		//number of cycles in animation INDEFINITE = repeat indefinitely
		tl.setCycleCount(Timeline.INDEFINITE);
		
		//mouse control (move and click)
		canvas.setOnMouseMoved(e ->  playerOneYPos  = e.getY());
		canvas.setOnMouseClicked(e ->  gameStarted = true);
		stage.setScene(new Scene(new StackPane(canvas)));
		stage.show();
		tl.play();
	}

	private void run(GraphicsContext gc) {
		//set graphics
		//set background color
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, width, height);
		
		//set text
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if(gameStarted) {
			//set ball movement
			ballXPos+=ballXSpeed;
			ballYPos+=ballYSpeed;
			
			//simple computer opponent who is following the ball
            if (ballXPos < width - width / 4) {
                // Se a bola estiver na parte esquerda da tela, o jogador 2 seguirá diretamente a posição da bola
                playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
            } else {
                if (ballbounce > 3) {
                    playerTwoYPos = ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ? playerTwoYPos += 8.0 : playerTwoYPos - 10.0;
                }else if(ballbounce > 7){
                    playerTwoYPos = ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ? playerTwoYPos += 10.0 : playerTwoYPos - 10.0;
                }else if(ballbounce > 10){
                    playerTwoYPos = ballYPos > playerTwoYPos + PLAYER_HEIGHT / 2 ? playerTwoYPos += 12.0 : playerTwoYPos - 12.0;
                }else{
                    playerTwoYPos = ballYPos - PLAYER_HEIGHT / 2;
                }
            }
			//draw the ball
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
			
		} else {
			//set the start text
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click", width / 2, height / 2);
			
			//reset the ball start position 
			ballXPos = width / 2;
			ballYPos = height / 2;
			
			//reset the ball speed and the direction
			ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;

            //reset the ball bounce
            ballbounce = 0;
		}
		
		//makes sure the ball stays in the canvas
		if(ballYPos > height || ballYPos < 0) ballYSpeed *=-1;
		
		//if you miss the ball, computer gets a point
		if(ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreP2++;
			gameStarted = false;
		}
		
		//if the computer misses the ball, you get a point
		if(ballXPos > playerTwoXPos + PLAYER_WIDTH) {  
			scoreP1++;
			gameStarted = false;
		}
	
		//increase the speed after the ball hits the player
		if( ((ballXPos + BALL_R > playerTwoXPos) && ballYPos >= playerTwoYPos && ballYPos <= playerTwoYPos + PLAYER_HEIGHT) || 
			((ballXPos < playerOneXPos + PLAYER_WIDTH) && ballYPos >= playerOneYPos && ballYPos <= playerOneYPos + PLAYER_HEIGHT)) {
            ballbounce++;
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
            System.out.println("ballbounce: " + ballbounce);
			ballXSpeed *= -1;
		}
		
		//draw score
		gc.fillText(scoreP1 + "\t\t\t\t\t\t\t\t" + scoreP2, width / 2, 100);
		//draw player 1 & 2
		gc.fillRect(playerTwoXPos, playerTwoYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
		// start the application
		public static void main(String[] args) {
		launch(args);
		}
}