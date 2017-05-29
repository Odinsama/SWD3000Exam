package gui;

public class GuiController {

	private static ApplicationFrame applicationFrame;

	static void init(ApplicationFrame applicationFrame) {
		GuiController.applicationFrame = applicationFrame;
	}

	public static void toggleStatus() {
		applicationFrame.toggleStatus();
	}


	public static void initProducerConsumerProblem(int producers, int consumers, int productsPerProducer,
												   int productsPerConsumer, int productionInterval, int consumptionInterval) {
		applicationFrame.initProducerConsumerProblem(producers, consumers, productsPerProducer, productsPerConsumer,
				productionInterval, consumptionInterval);
	}
}
