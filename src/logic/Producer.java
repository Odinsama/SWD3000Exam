package logic;

import java.util.Stack;

import models.Product;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class Producer implements Runnable {
	private final Market market;
	private final Stack<Product> productsInStock = new Stack<>();
	private final int numOfProducts;
	private final long producerInterval;

	Producer(Market market, int numOfProducts, long producerInterval) {
		this.market = market;
		this.numOfProducts = numOfProducts;
		this.producerInterval = producerInterval;
		for (int i = 0; i < this.numOfProducts; i++) {
			productsInStock.push(new Product("Product " + i + " by " + Thread.currentThread().getId()));
		}
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
