package kap05_threads;

/**
 * Test the state of a thread.
 * 
 * @author Philipp Jenke
 */
public class ThreadZustand {
  public static void main(String[] args) {
    // Runnable runs until it is interrupted
    Runnable runnable = () -> {
      while (!Thread.currentThread().isInterrupted()) {
      }
    };
    Thread thread = new Thread(runnable);
    thread.start();
    System.err.println(thread.getState());
    thread.interrupt();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
    }
    System.err.println(thread.getState());
  }
}
