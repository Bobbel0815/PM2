package braitenberg;

import braitenberg.braitenbergvehikel.BVSimulation;

public class SimulationThread extends Thread {

	private BVSimulation simulation;
	private boolean alive;

	public SimulationThread(BVSimulation simulation) {
		this.simulation = simulation;
		alive = true;
	}
	
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
