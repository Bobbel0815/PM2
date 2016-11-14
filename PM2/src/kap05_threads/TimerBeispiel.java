package kap05_threads;

import java.util.Timer;

/**
 * Timer testing class
 * 
 * @author Philipp Jenke
 */
class TimerBeispiel {

  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new TimerTaskBeispiel(), 2000, 2000);
    try {
      Thread.sleep(11000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    timer.cancel();
    System.err.println("Fertig.");
  }
}
