package logic;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import models.*;

class Market {
	private ProductStackObservable productStackObservable = new ProductStackObservable();
	Market(ArrayList<ProductStackObserver> productStackObservers) {
		productStackObservable.populateWithProductStackObservers(productStackObservers);

	}

	synchronized void supplyProduct(Product product) {
		productStackObservable.push(product);
	}

	synchronized Product getOneProduct() throws EmptyStackException {
		return productStackObservable.getOneProduct();
	}

	boolean isEmpty() {
		return productStackObservable.isEmpty();
	}

}
