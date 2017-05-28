package gui.domain;

import controller.RaceController;
import gui.GuiController;
import gui.BorderedInput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPane extends JPanel implements ActionListener {
	private final static int COL_WIDTH = 15;
	private JButton startButton = new JButton("Start race");
	private ArrayList<BorderedInput> borderedInputs = new ArrayList<>();

	FormPane() {
		startButton.addActionListener(this);
		addInputsToList();
		addInputsToPanel();
		add(startButton);
	}

	private void disableInputs() {
		for (BorderedInput borderedInput : borderedInputs) {
			borderedInput.disableInput();
		}
		startButton.setEnabled(false);
	}

	void enableInputs() {
		for (BorderedInput borderedInput : borderedInputs) {
			borderedInput.enableInput();
		}
		startButton.setEnabled(true);
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
		disableInputs();
		GuiController.toggleStatus();
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
