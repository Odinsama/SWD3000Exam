package gui.domain;

import gui.BorderedInput;
import gui.GuiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class FormPane extends JPanel implements ActionListener {
	private final static int COL_WIDTH = 15;
	private final JButton startButton = new JButton("Start race");
	private final ArrayList<BorderedInput> borderedInputs = new ArrayList<>();
	private boolean startEnabled = true;

	FormPane() {
		startButton.addActionListener(this);
		addInputsToList();
		addInputsToPanel();
		add(startButton);
	}

	void toggleInputs() {
		for (BorderedInput borderedInput : borderedInputs) {
			borderedInput.toggleInput();
		}
		startEnabled = !startEnabled;
		startButton.setEnabled(startEnabled);
	}

	private void addInputsToList() {
		borderedInputs.add(new BorderedInput(10, "Producers", COL_WIDTH));
		borderedInputs.add(new BorderedInput(10, "Consumers", COL_WIDTH));
		borderedInputs.add(new BorderedInput(20, "Products per producers", COL_WIDTH));
		borderedInputs.add(new BorderedInput(10, "Products per consumer", COL_WIDTH));
		borderedInputs.add(new BorderedInput(200, "Producer interval", COL_WIDTH));
		borderedInputs.add(new BorderedInput(5000, "Consumer interval", COL_WIDTH));
	}

	private void addInputsToPanel() {
		for (BorderedInput borderedInput : borderedInputs) {
			add(borderedInput);
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		int producers = borderedInputs.get(0).getValue(),
			consumers = borderedInputs.get(1).getValue(),
			productsPerProducer = borderedInputs.get(2).getValue(),
			productsPerConsumer = borderedInputs.get(3).getValue(),
			productionInterval = borderedInputs.get(4).getValue(),
			consumptionInterval = borderedInputs.get(5).getValue();
		GuiController.initProducerConsumerProblem(producers, consumers, productsPerProducer, productsPerConsumer,
				productionInterval, consumptionInterval);

	}

}
