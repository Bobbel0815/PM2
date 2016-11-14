package kap05_threads;

import java.time.LocalTime;
import java.util.TimerTask;

/**
 * Ein einfacher Timer-Task: Ausgabe der aktuellen Sekunde.
 * 
 * @author Philipp Jenke
 *
 */
class TimerTaskBeispiel extends TimerTask {
  @Override
  public void run() {
    System.err.println("Aktuelle Sekunde: " + LocalTime.now().getSecond());
  }
}
