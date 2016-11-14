package kap05_threads;

/**
 * Testet die join() und die isAlive()-Methode
 * 
 * @author Philipp Jenke
 * 
 */
public class ThreadsJoinIsAlive extends Thread {

  @Override
  public void run() {
    System.err.println("Name des ausgeführten Threads (in run()): "
        + Thread.currentThread().getName());
    for (int i = 0; i < 10; i++) {
      System.err.println("Thread-Zahl: " + i);
    }
    System.err.println("ThreadsJoinIsAlive beendet!");
  }

  /**
   * Program entry point.
   */
  public static void main(String[] args) {
    ThreadsJoinIsAlive testThread = new ThreadsJoinIsAlive();
    System.err.println("Name des ausgeführten Threads (in main()): "
        + Thread.currentThread().getName());
    System.err.println(
        "ThreadsJoinIsAlive isAlive() vor start()? " + testThread.isAlive());
    testThread.start();
    System.err.println(
        "ThreadsJoinIsAlive isAlive() nach start()? " + testThread.isAlive());

    try {
      testThread.join();
    } catch (InterruptedException e) {
      System.err.println("Interrupted Exception bei join()");
    }
    System.err.println(
        "ThreadsJoinIsAlive isAlive() Ende main()? " + testThread.isAlive());
    System.err.println("main()-Thread beendet");
  }
}
