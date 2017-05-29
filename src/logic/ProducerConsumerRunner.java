package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import controller.RaceController;
import gui.domain.ResultPane;
import models.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ProducerConsumerRunner {


	public ProducerConsumerRunner(int producerCount, int consumerCount, int productsPerProducer,
								  int productsPerConsumer, int productionInterval, int consumptionInterval,
								  ICallable caller) {
		ExecutorService executor = Executors.newCachedThreadPool();
		RaceController.resetComplaints();
		final ArrayList<ProductStackObserver> productStackObservers = new ArrayList<>();
		productStackObservers.add(new ProductStackObserver(caller, producerCount * productsPerProducer));
		Market market = new Market(productStackObservers);

		for (int i = 0; i < producerCount; i++) {
			executor.submit(new Producer(market, productsPerProducer, productionInterval));
		}

		for (int i = 0; i < consumerCount; i++) {
			executor.submit(new Consumer(market, productsPerConsumer, consumptionInterval));
		}
		executor.shutdown();
		try {
			executor.awaitTermination(10, SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			RaceController.raceFinished();
		}
	}

}
