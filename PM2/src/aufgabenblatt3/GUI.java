package aufgabenblatt3;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application implements Observer {

	/**
	 * Anzahl von Gleisen des Rangierbahnhofs.
	 */
	private int anzahlGleise = 10;

	private Rangierbahnhof bahnhof;
	/**
	 * Pane der Benutzeroberflaeche
	 */
	private Pane root;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Hauptmethode der Benutzeroberflaeche. Erzeugt ein Fenster mit Rechtecken,
	 * die Rot sind falls ein Gleis belegt, und Gruen wenn eins Frei ist.
	 * 
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		int rectangleHeight = 480 / anzahlGleise;
		Rectangle rectangle;
		root = new VBox();
		for (int i = 0; i < anzahlGleise; i++) {
			rectangle = new Rectangle(0, i * rectangleHeight + i, 120, rectangleHeight);
			rectangle.setFill(Color.GREEN);
			rectangle.setStroke(Color.BLACK);
			root.getChildren().add(rectangle);
		}
		primaryStage.setTitle("Simulation");
		primaryStage.setScene(new Scene(root, 120, 480));
		primaryStage.show();

		bahnhof = new Rangierbahnhof(anzahlGleise);
		bahnhof.addObserver(this);
		Thread simulation = new Thread(new Simulation(this,anzahlGleise));
		simulation.start();

	}

	/**
	 * Aktualisiert anhand der change Variablen, welches Gleis noetigfalls
	 * umgefaerbt werden muss.
	 * 
	 */
	@Override
	public void update(Observable obs, Object obj) {
		UpdateSpeicher change = (UpdateSpeicher) obj;
		Rectangle rect;
		if (change.getAufgabe() == Lokfuehrer.Aufgabe.EINFAHREN) {
			rect = (Rectangle) (root.getChildren().get(change.getGleis()));
			if (rect != null) {
				Platform.runLater(() -> {
					rect.setFill(Color.RED);
				});
			}
		} else {
			rect = (Rectangle) (root.getChildren().get(change.getGleis()));
			if (rect != null) {
				Platform.runLater(() -> {
					rect.setFill(Color.GREEN);
				});
			}
		}
	}

}
