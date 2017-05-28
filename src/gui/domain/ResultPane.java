package gui.domain;

import gui.GuiController;
import gui.NavigationLamp;
import logic.ProducerConsumerRunner;
import models.ICallable;

import javax.swing.*;
import java.awt.*;

import java.util.concurrent.atomic.AtomicInteger;

public class ResultPane extends JPanel implements ICallable{
	
	private final int TOP_WIDTH = 150;
	private final int TOP_HEIGHT = 150;
	private final int X_OFFSET = 10;
	private final int Y_OFFSET = 100;
	private Rectangle rectangle = new Rectangle(X_OFFSET, Y_OFFSET, 0, 0);
	private AtomicInteger numberOfComplaints = new AtomicInteger(0);
	private NavigationLamp navigationLamp = new NavigationLamp();
	

	ResultPane() {
		JLabel lampDescription = new JLabel("Status: ");
		add(lampDescription);
		add(navigationLamp);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Stack size: " + String.valueOf(rectangle.width), X_OFFSET, TOP_HEIGHT - 55);
		g.drawString("Complaints: " + String.valueOf(numberOfComplaints), X_OFFSET, TOP_HEIGHT - 70);
		g.setColor(Color.BLUE);
		g.drawRect(X_OFFSET, Y_OFFSET, TOP_WIDTH, TOP_HEIGHT);
		g.fillOval(X_OFFSET, Y_OFFSET, rectangle.width, rectangle.height);
	}

	public void updateRectangle(Rectangle rectangle) {
		this.rectangle.setBounds(rectangle);
		repaint();
	}

	void toggleStatus() {
		navigationLamp.toggle();
	}
	
	void addComplaint() {
		numberOfComplaints.getAndIncrement();
		repaint();
	}

	void initProducerConsumerProblem(int producers, int consumers, int productsPerProducer, int productsPerConsumer, int productionInterval, int consumptionInterval) {
		new Thread(() -> {
			new ProducerConsumerRunner(producers, consumers, productsPerProducer, productsPerConsumer,
					productionInterval, consumptionInterval, this);
			GuiController.toggleStatus();
			GuiController.enableInputs();
		}).start();
	}

	void resetComplaints() {
		numberOfComplaints.set(0);
	}
}


