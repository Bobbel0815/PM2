package kap05_threads;

import java.util.ArrayList;
import java.util.List;

/**
 * Testklasse für die Priorisierung von Threads
 * 
 * @author Philipp Jenke
 */
public class Prioritaet extends Thread {

  private int anzahlAufrufe = 0;

  @Override
  public void run() {
    while (!isInterrupted()) {
      System.err.println("Anzahl Aufrufe: " + anzahlAufrufe);
      anzahlAufrufe++;
    }
  }

  public int getAnzahlAufrufe() {
    return anzahlAufrufe;
  }

  /**
   * Program entry point.
   */
  public static void main(String[] args) {
    List<Prioritaet> threads = new ArrayList<Prioritaet>();
    for (int i = 0; i < 100; i++) {
      boolean isLowPrio = Math.random() < 0.5;
      Prioritaet thread;
      if (isLowPrio) {
        thread = new Prioritaet();
        thread.setName("Niedrige Priorität");
        thread.setPriority(Thread.MIN_PRIORITY);
      } else {
        thread = new Prioritaet();
        thread.setName("Hohe Priorität");
        thread.setPriority(Thread.MAX_PRIORITY);
      }
      threads.add(thread);
    }
    for (int i = 0; i < threads.size(); i++) {
      threads.get(i).start();
    }
    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      System.err.println(e.getStackTrace());
    }
    for (int i = 0; i < threads.size(); i++) {
      threads.get(i).interrupt();
    }
    for (int i = 0; i < threads.size(); i++) {
      System.err.println("Anzahl Aufrufe: (" + threads.get(i).getName() + "): "
          + threads.get(i).getAnzahlAufrufe());
    }
  }
}
