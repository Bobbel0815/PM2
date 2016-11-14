package kap05_threads;

/**
 * Ein Zähler (1 ... 10) als Runnable umgesetzt.
 * 
 * @author Philipp Jenke
 *
 */
public class ZaehlerRunnable implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.err.println(i);
    }
  }

  public static void main(String[] args) {
    Thread zaehlerThread = new Thread(new ZaehlerRunnable());
    zaehlerThread.start();
    System.err.println("Main Ende");
  }
}
