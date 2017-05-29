package models;

import java.util.ArrayList;
import java.util.Stack;

public class ProductStackObservable {
	private final Stack<Product> productStack = new Stack<>();
	private final ArrayList<ProductStackObserver> productStackObservers = new ArrayList<>();

	public void push(Product product) {
		productStack.push(product);
		notifyObservers();
	}
	
	public Product getOneProduct() {
		Product product = productStack.pop();
		notifyObservers();
		return product;
	}
	
	private void addProductStackObserver(ProductStackObserver productStackObserver) {
		productStackObservers.add(productStackObserver);
	}
	
	public void populateWithProductStackObservers(ArrayList<ProductStackObserver> productStackObservers) {
		if(productStackObservers != null) {
			for(ProductStackObserver productStackObserver: productStackObservers) {
				addProductStackObserver(productStackObserver);
			}
		}
	}
	
	public boolean isEmpty() {
		return productStack.isEmpty();
	}
	
	private void notifyObservers() {
		for(ProductStackObserver productStackObserver : productStackObservers) {
			productStackObserver.setStackSize(productStack.size());
		}
	}
	

}
