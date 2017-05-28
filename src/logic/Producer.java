package logic;

import java.util.Stack;

import models.Product;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Producer extends Thread {
	private Market market;
	private Stack<Product> productsInStock = new Stack<>();
	private int numOfProducts;
	private long producerInterval;

	Producer(Market market, int numOfProducs, long producerInterval) {
		this.market = market;
		this.numOfProducts = numOfProducs;
		this.producerInterval = producerInterval;
		for (int i = 0; i < numOfProducts; i++) {
			productsInStock.push(new Product("Product " + i + " by " + Thread.currentThread().getId()));
		}
		start();
	}

	public void run() {
		for (int i = 0; i < numOfProducts; i++) {
			try {
				prepareProduct();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			supplyProduct(productsInStock.pop());
		}
		System.out.println("Producer " + Thread.currentThread().getId() + " has finished supplying the market with " + numOfProducts + " products");
	}
	
	private void supplyProduct(Product product) {
		market.supplyProduct(product);
	}
	
	private void prepareProduct() throws InterruptedException {
		MILLISECONDS.sleep(producerInterval);
	}
}
