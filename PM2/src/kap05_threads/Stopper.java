package kap05_threads;

import java.util.Scanner;

/**
 * Der Thread zählt und endet, wenn eine Tastatureingabe erfolgte.
 * 
 * @author Philipp Jenke
 *
 */
public class Stopper extends Thread {
  @Override
  public void run() {
    double zaehler = 0;
    while (!interrupted()) {
      zaehler += 1e-5;
    }
    System.err.format("Zählerstand: %.2f", zaehler);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.err.println("Bitte Zeichen eingeben und Enter drücken.");
    Stopper stopper = new Stopper();
    stopper.start();
    scanner.next();
    stopper.interrupt();
    scanner.close();
  }
}
