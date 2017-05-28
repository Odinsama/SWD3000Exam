package logic;

import java.util.ArrayList;
import java.util.HashMap;

import controller.RaceController;
import gui.domain.ResultPane;
import models.*;

public class ProducerConsumerRunner {


	public ProducerConsumerRunner(int producerCount, int consumerCount, int productsPerProducer,
								  int productsPerConsumer, int productionInterval, int consumptionInterval,
								  ICallable caller) {
		RaceController.resetComplaints();
		final ArrayList<ProductStackObserver> productStackObservers = new ArrayList<>();
		productStackObservers.add(new ProductStackObserver(caller, producerCount * productsPerProducer));
		Market market = new Market(productStackObservers);
		Producer[] producers = new Producer[producerCount];
		Consumer[] consumers = new Consumer[consumerCount];

		for (int i = 0; i < producerCount; i++) {
			producers[i] = new Producer(market, productsPerProducer, productionInterval);
		}

		for (int i = 0; i < consumerCount; i++) {
			consumers[i] = new Consumer(market, productsPerConsumer, consumptionInterval);
		}

		for (int i = 0; i < producerCount; i++) {
			try {
				producers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < consumerCount; i++) {
			try {
				consumers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
