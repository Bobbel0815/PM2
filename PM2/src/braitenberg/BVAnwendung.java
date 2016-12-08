/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package braitenberg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import braitenberg.braitenbergvehikel.BVBewegungAbstossung;
import braitenberg.braitenbergvehikel.BVBewegungAttraktion;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;
import braitenberg.view.BVCanvas;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */

public class BVAnwendung extends Application {

	private SimulationThread simulationsThread;

	@Override
	public void start(Stage primaryStage) {
		// Simulation zusammenstellen
		BVSimulation sim = erzeugeSimulationsszene();

		// Canvas setzen
		BVCanvas canvas = new BVCanvas(600, 600, sim);

		canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sim.setSignal(event.getX() - (canvas.getWidth() / 2), (canvas.getHeight() / 2) - event.getY());
			}

		});

		canvas.zeichneSimulation();

		// Szenengraph aufbauen
		primaryStage.setTitle("Braitenberg-Vehikel!");
		BorderPane wurzel = new BorderPane();
		VBox vbox = new VBox();
		wurzel.setCenter(canvas);
 		//Positionieren der vbox
		vbox.setPadding(new Insets(25, 50, 25, 0));
		vbox.setSpacing(15);
		wurzel.setRight(vbox);
		//Button erstellen
		Button simulationButton = new Button("Simuliere!");
		simulationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				sim.simulationsSchritt();
			}
		});
		vbox.getChildren().add(simulationButton);
		//Checkbox erstellen
		CheckBox simulationCheckBox = new CheckBox("Simulation");
		simulationCheckBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (simulationCheckBox.isSelected()) {
					simulationsThread = new SimulationThread(sim);
					simulationsThread.start();
				} else {
					simulationsThread.setDead();
					simulationsThread = null;
				}
			}
		});
		vbox.getChildren().add(simulationCheckBox);
		
		//Hbox und Combobox erstellen für "Susi"
		
		HBox hbox = new HBox();
		//Label erstellen und positionieren
		Label label = new Label("Susi");
		label.setPadding(new Insets(5, 5, 5, 0));
		hbox.setSpacing(5);
		//Combobox mit "Attraktion" und "Abstossung" erstellen 
		ComboBox<String> comboBox1 = new ComboBox<String>();
		comboBox1.getItems().addAll("ATTRAKTION", "ABSTOSSUNG");
		comboBox1.getSelectionModel().select(0);
		comboBox1.setOnAction(new EventHandler<ActionEvent>() {
		//Bewegungsmuster mit Hilfe der Combobox den Fahrzeugen übergeben
			@Override
			public void handle(ActionEvent event) {
				String bewegung = comboBox1.getSelectionModel().getSelectedItem();
				if (bewegung.equals("ATTRAKTION")) {
					sim.getVehikel(0).setBewegung(new BVBewegungAttraktion());
				} else {
					sim.getVehikel(0).setBewegung(new BVBewegungAbstossung());
				}
			}

		});
		//Label und Combobox in die hbox legen
		hbox.getChildren().add(label);
		hbox.getChildren().add(comboBox1);
		//Hbox in die vbox legen
		vbox.getChildren().add(hbox);
		
		//Hbox und Combobox erstellen für "Mike"
		
		hbox = new HBox();
		label = new Label("Mike");
		label.setPadding(new Insets(5, 5, 5, 0));
		hbox.setSpacing(5);
		//Combobox mit "Attraktion" und "Abstossung" erstellen 
		ComboBox<String> comboBox2 = new ComboBox<String>();
		comboBox2.getItems().addAll("ATTRAKTION", "ABSTOSSUNG");
		comboBox2.getSelectionModel().select(1);
		comboBox2.setOnAction(new EventHandler<ActionEvent>() {
		//Bewegungsmuster mit Hilfe der Combobox den Fahrzeugen übergeben
			@Override
			public void handle(ActionEvent event) {
				String bewegung = comboBox2.getSelectionModel().getSelectedItem();
				if (bewegung.equals("ATTRAKTION")) {
					sim.getVehikel(1).setBewegung(new BVBewegungAttraktion());
				} else {
					sim.getVehikel(1).setBewegung(new BVBewegungAbstossung());
				}
			}

		});
		//Label und Combobox in die hbox legen
		hbox.getChildren().add(label);
		hbox.getChildren().add(comboBox2);
		//Hbox in die vbox legen
		vbox.getChildren().add(hbox);

		primaryStage.setScene(new Scene(wurzel, 850, 600));
		primaryStage.show();
		//Eventhandler zum Beenden der Threads beim schließen des Fensters
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				if (simulationsThread != null) {
					simulationsThread.setDead();
					simulationsThread = null;
				}
			}

		});

	}

	/**
	 * Erzeugt eine Simulationsszene zum Testen.
	 */
	public BVSimulation erzeugeSimulationsszene() {
		BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi", new BVBewegungAttraktion());
		BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike", new BVBewegungAbstossung(), new Vektor2(-100, 100),
				new Vektor2(1, 0));
		BVSimulation sim = new BVSimulation();
		sim.vehikelHinzufuegen(vehikel1);
		sim.vehikelHinzufuegen(vehikel2);
		return sim;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
