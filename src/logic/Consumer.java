package logic;

import java.util.EmptyStackException;
import java.util.Stack;

import controller.RaceController;
import models.Product;

class Consumer implements Runnable {
	private final Market market;
	private final Stack<Product> products = new Stack<>();
	private final int productsToGet;
	private final long finishedTime;

	Consumer(Market market, int productsToGet, long time) {
		this.market = market;
		this.productsToGet = productsToGet;
		finishedTime = System.currentTimeMillis() + time;
	}

	public void run() {
		while (!isFinished() && hasTime()) {
			if (!market.isEmpty()) {
				try {
					purchaseProduct();
				} catch (EmptyStackException e) {
					RaceController.fileComplaint();
				}
			}
		}
		System.out.println(toString());
		
	}

	private boolean hasTime() {
		return System.currentTimeMillis() < finishedTime;
	}

	private boolean isFinished() {
		return products.size() >= productsToGet;
	}
	
	private void purchaseProduct() {
		products.push(getOneProduct());
	}
	
	private Product getOneProduct() {
		return market.getOneProduct();
	}


	@Override
	public String toString() {
		return "Consumer " + Thread.currentThread().getId() + ", has " + products.size() + " products";
	}

}
