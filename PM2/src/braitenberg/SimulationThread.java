package braitenberg;

import braitenberg.braitenbergvehikel.BVSimulation;
/**
 * Repärsentiert einen Thread, welcher 200ms schläft und mit einem FLag beendet werden kann.
 */
public class SimulationThread extends Thread {

	private BVSimulation simulation;
/**
 * Variable zum verlassen der while-Schleife
 */
	private boolean alive;

	public SimulationThread(BVSimulation simulation) {
		this.simulation = simulation;
		alive = true;
	}
	/**
	 * Flag zum Beenden des Threads.
	 */
	void setDead(){
		alive = false;
	}
	
	public void run() {
		while (alive) {
			simulation.simulationsSchritt();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}

}
