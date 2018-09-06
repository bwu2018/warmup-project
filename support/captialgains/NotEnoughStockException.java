package captialgains;

/**
 * An {@link NotEnoughStock} is thrown when a {@link CapitalGainsInterface} does not
 * have enough stocks to execute a sell
 * @author jddevaug
 *
 */
public class NotEnoughStockException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughStockException(){

	}

	public NotEnoughStockException(String message){
		super(message);
	}

}

