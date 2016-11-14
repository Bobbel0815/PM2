package kap05_threads;

/**
 * Ein Spieler ist ein Thread, der kontinuierlich auf das Tor (dern Keeper)
 * schiesst.
 * 
 * @author Philipp Jenke
 * 
 */
public class Spieler extends Thread {
  private final Keeper keeper;

  public Spieler(Keeper keeper, String name) {
    super(name);
    this.keeper = keeper;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      keeper.score();
      System.err.println(getName() + " hat ein Tor geschossen.");
    }
  }
}
