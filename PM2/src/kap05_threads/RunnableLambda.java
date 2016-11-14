package kap05_threads;

public class RunnableLambda {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.err.println(i);
			}
		});
		thread.start();
		System.err.println("main()-Ende");
	}

}
