package capitalgains;

import captialgains.CapitalGainsInterface;
import captialgains.NotEnoughStockException;
import structures.WuQueueInterface;

public class WuCapitalGainsInterface implements CapitalGainsInterface {

	private final WuQueueInterface<Stock> queue;
	public int day;
	public WuCapitalGainsInterface(){
		this.queue = new WuQueueInterface<Stock>(); 
		this.day = 0;
	}
	
	@Override
	public void buy(int shares, double price) {
		for(int i = 0; i < shares; i++){
    		queue.enqueue(new Stock(price));
    	}
		day++;
	}
	
	@Override
	public double sell(int shares, double price) {
		if (queue.size() < shares) { 
			throw new NotEnoughStockException();
		}
		int sum = 0;
		for (int i = 0; i < shares; i++) { 
			sum += queue.dequeue().getPrice();
		}
		day ++;
		return shares*price - sum;
	}

	@Override
	public int getDay() {
		return day;
	}
   
	
}
