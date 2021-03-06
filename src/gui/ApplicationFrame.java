package gui;

import javax.swing.JFrame;

import controller.IRaceUI;
import controller.RaceController;
import gui.domain.DomainView;

public class ApplicationFrame extends JFrame implements IRaceUI {
	private final DomainView domainView = new DomainView();

	public ApplicationFrame() {
		GuiController.init(this);
		RaceController.init(this);
		setTitle("Producer Consumer Problem");
		add(domainView);
		setSize(500, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


	void toggleStatus() {
		domainView.toggleStatus();
	}

    public void fileComplaint() {
		domainView.fileComplaint();
    }

	@Override
	public void resetComplaints() {
		domainView.resetComplaints();
	}

	@Override
	public void raceFinished() {
		toggleStatus();
	}

	void initProducerConsumerProblem(int producers, int consumers, int productsPerProducer, int productsPerConsumer,
									 int productionInterval, int consumptionInterval) {
		domainView.initProducerConsumerProblem(producers, consumers, productsPerProducer, productsPerConsumer,
				productionInterval, consumptionInterval);
	}
}
