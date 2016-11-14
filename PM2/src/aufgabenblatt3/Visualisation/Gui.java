package aufgabenblatt3.Visualisation;


import java.util.Observable;
import java.util.Observer;

import aufgabenblatt3.Rangierbahnhof.Rangierbahnhof;
import aufgabenblatt3.Simulation.Simulation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Gui extends Application implements Observer{

	
	private int anzahlGleise = 10;
	private Rangierbahnhof bahnhof;
	private Pane root;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		bahnhof = new Rangierbahnhof(anzahlGleise);
		bahnhof.addObserver(this);
		Thread simulation = new Thread(new Simulation(bahnhof));
		simulation.start();
		primaryStage.setTitle("Simulation");
		root = new VBox();
		
		int rectangleHeight = 480 / anzahlGleise;
		Rectangle rectangle;
		for(int i = 0; i < anzahlGleise; i++){
			rectangle = new Rectangle(0,i*rectangleHeight+i,120,rectangleHeight);
			rectangle.setFill(Color.GREEN);
			rectangle.setStroke(Color.BLACK);
			root.getChildren().add(rectangle);
		}
		((Shape) root.getChildren().get(2)).setFill(Color.GREEN);
		primaryStage.setScene(new Scene(root,120,480));
		primaryStage.show();
	}

	@Override
	public void update(Observable obs, Object obj) {
		int change = bahnhof.getChange();
		Rectangle rect;
		if(change%2 == 1){
			rect = (Rectangle) (root.getChildren().get(change/10));
			if(rect != null){
				rect.setFill(Color.RED);
			}
		}
		else{
			rect = (Rectangle) (root.getChildren().get(change/10));
			if(rect != null){
				rect.setFill(Color.GREEN);
			}
		}
	}

}
