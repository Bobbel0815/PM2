package kap05_threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein Torwart bekommt von verschiedenen Spielern kontinuiertlich Torschüsse ab.
 * 
 * @author Philipp Jenke
 * 
 */
public class Keeper {

  /**
   * Anzahl der kassierten Tore.
   */
  protected int anzahlTore = 0;

  /**
   * Ein Spieler schiesst auf das Tor (und trifft)
   */
  public void score() {
    anzahlTore++;
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return "Anzahl Tore: " + anzahlTore;
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    Keeper keeper = new Keeper();
    List<Spieler> spieler = new ArrayList<Spieler>();
    for (int i = 0; i < 10; i++) {
      spieler.add(new Spieler(keeper, "Spieler " + i));
    }
    for (int i = 0; i < spieler.size(); i++) {
      spieler.get(i).start();
    }
    for (int i = 0; i < spieler.size(); i++) {
      try {
        spieler.get(i).join();
      } catch (InterruptedException e) {
        // Interrupt sollte hier nicht auftreten
      }
    }
    System.err.println("Spiel zuende, " + keeper);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out
        .println("Zeit gesamt:: " + (elapsedTime / 1000.0) + " Sekunden.");
  }

}
