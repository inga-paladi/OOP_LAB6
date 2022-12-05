import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class RestaurantApp {

	ExecutorService m_executor;
	boolean m_running;
	OOP_View m_view;

	public RestaurantApp(OOP_View view) {
		this.m_view = view;
		m_executor = Executors.newFixedThreadPool(5);
		m_running = true;
	}

	public void start() {
		Thread thread = new Thread(() -> {
			m_view.Println("Worker thread created");
			Random random = new Random();
			while (m_running) {
				m_executor.execute(new ClientSimulation(this.m_view));
				try {
					TimeUnit.SECONDS.sleep(random.nextInt(10));
				} catch (Exception exception) { }
			}
		});

		thread.start();

		m_view.AskForString();
		m_view.Println("Stopping...");

		try {
			m_executor.shutdownNow();
			while (!m_executor.isTerminated());
		} catch (Exception exception) { }
	}

}
