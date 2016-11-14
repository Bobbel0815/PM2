package kap05_threads;

/**
 * Wird eine Interrupted-Exception gefangen, dann wird damit das Interrupt-Flag
 * zurückgesetzt (muss falls nötig neu gesetzt werden).
 * 
 * @author Philipp Jenke
 */
public class InterruptFlag extends Thread {

  @Override
  public void run() {
    int i = 0;
    while (!isInterrupted()) {
      System.err.println(i++);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.err.println("Thread wurde durch Interrupt geweckt!");
        interrupt();
      }
    }
    System.err.println("Thread wird beendet!");
  }

  public static void main(String[] args) {
    InterruptFlag thread = new InterruptFlag();
    thread.start();
    try {
      // Für 2012,8 ms anhalten
      Thread.sleep(2012, 800);
    } catch (InterruptedException e) {
      System.err.println(e.getStackTrace());
    }
    // Thread unterbrechen (Interrupt-Flag setzen)
    thread.interrupt();
    System.err.println("Es wurde gestoppt!");
  }
}
