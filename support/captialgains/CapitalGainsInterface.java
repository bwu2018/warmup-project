package captialgains;


public interface CapitalGainsInterface {
	/**
	 * Buys certain number of shares at certain price
	 * 
	 * @param shares
	 *            number of shares sold
	 * @param price 
	 * 				price of each share
	 */
	public void buy(int shares, double price);
	
	/**
	 * Returns the capital gains 
	 * 
	 * @param shares
	 *            number of shares sold
	 * @param price 
	 * 				price of each share
	 * @throws NotEnoughStockException
	 *             if there is not enough stock to execute the transaction
	 * @return the capital gains for the transaction
	 */
	public double sell(int shares, double price);
	
	/**
	 * Getter for the number of the days 
	 * @return the number of days you've been trading this stock actively
	 */
	public int getDay();

}
