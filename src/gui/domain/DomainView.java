package gui.domain;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class DomainView extends JPanel {
	private FormPane formPane = new FormPane();
	private ResultPane resultPane = new ResultPane();

	public DomainView() {
		setLayout(new BorderLayout());
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLeftComponent(formPane);
		splitPane.setRightComponent(resultPane);
		add(splitPane);
	}

	public void toggleStatus() {
		resultPane.toggleStatus();
		formPane.toggleInputs();
	}

    public void fileComplaint() {
		resultPane.addComplaint();
    }

    public void initProducerConsumerProblem(int producers, int consumers, int productsPerProducer,
											int productsPerConsumer, int productionInterval, int consumptionInterval) {
		resultPane.initProducerConsumerProblem(producers, consumers, productsPerProducer, productsPerConsumer,
				productionInterval, consumptionInterval);

	}

	public void resetComplaints() {
		resultPane.resetComplaints();
	}
}
