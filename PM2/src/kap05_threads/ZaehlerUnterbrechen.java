package kap05_threads;

/**
 * Thread wird als Zähler gestartet (ohne Grenze). Paralell wird in der
 * main()-Methode gezählt (bis 10). Dann wird der Zähler-Thread unterbrochen.
 * 
 * @author Philipp Jenke
 * 
 */
public class ZaehlerUnterbrechen extends Thread {

  @Override
  public void run() {
    int zahl = 0;
    while (!isInterrupted()) {
      System.err.println("Zähler-Thread:" + zahl);
      zahl++;
    }
    System.err.println("Zähler-Thread beendet.");
  }

  public static void main(String[] args) {
    ZaehlerUnterbrechen zaehlerThread = new ZaehlerUnterbrechen();
    zaehlerThread.start();
    for (int zahl = 0; zahl < 100; zahl++) {
      System.err.println("main()-Zähler: " + zahl);
    }
    zaehlerThread.interrupt();
    System.err.println("Ende der main()-Methode.");
  }
}