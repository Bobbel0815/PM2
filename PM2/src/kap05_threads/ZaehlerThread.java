package kap05_threads;

/**
 * Ein Zähler (1 ... 10) als Thread umgesetzt.
 * 
 * @author Philipp Jenke
 *
 */
public class ZaehlerThread extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      // Ausgabe mit System.err, weil die sofort erfolgt (anders bei
      // System.out).
      System.err.println(i);
    }
  }

  public static void main(String[] args) {
    ZaehlerThread zaehlerThread = new ZaehlerThread();
    zaehlerThread.start();

    System.err.println("Ende der main()-Methode.");
  }

}
