package kap05_threads;

/**
 * Testklasse um zu zeigen, dass man stop() nicht zum Anhalten eines Threads
 * verwenden soll.
 * 
 * @author Philipp Jenke
 */
public class StopNichtVerwenden extends Thread {

  /**
   * Hochzählen und Zahlen ausgeben.
   */
  public void run() {
    int i = 0;
    while (true) {
      System.err.println(i++);
    }
  }

  @SuppressWarnings("deprecation")
  public static void main(String[] args) {
    StopNichtVerwenden thread = new StopNichtVerwenden();
    thread.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.err.println(e.getStackTrace());
    }
    thread.stop();
    System.err.println("Thread gestoppt.");
  }
}

/**
 * Representation of the thread.
 * 
 * @author Philipp Jenke
 * 
 */
class MyThread2 {

}
