/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package kap05_threads;

import java.util.Scanner;

/**
 * Eingabe einer Zeichenkette in einem parallelen Thread.
 */
class AnwenderEingabeThread extends Thread {

  @Override
  public void run() {
    Scanner scanner = new Scanner(System.in);
    System.err.print("Bitte Text eingeben: ");
    String eingabe = scanner.nextLine();
    System.err.println("Eingabe: " + eingabe);
    scanner.close();
    System.err.println("run() zuende.");
  }

  public static void main(String[] args) {
    AnwenderEingabeThread eingabeThread = new AnwenderEingabeThread();
    eingabeThread.start();
    System.err.println("main() zuende.");
  }
}
