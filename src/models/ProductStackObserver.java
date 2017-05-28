package models;

import java.awt.*;

public class ProductStackObserver {
	private int stackSize = 0;
	private ICallable caller;
	private int maxValue = 1;

	public ProductStackObserver(ICallable caller, int maxValue) {
		this.caller = caller;
		this.maxValue = maxValue;
	}

	void setStackSize(int stackSize) {
		if(stackSize < 0) {
			return;
		}
		
		this.stackSize = stackSize;
		update();
	}
	
	private void update(){
		Rectangle result = new Rectangle(10, 100, (stackSize * 150) / maxValue, (stackSize * 150) / maxValue);
		caller.updateRectangle(result);
	}
}
