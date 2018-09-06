package config;
import blurb.WuBlurbInterface;
import capitalgains.WuCapitalGainsInterface;
import blurb.BlurbInterface;
import captialgains.CapitalGainsInterface;
import dropout.ArrayDropoutStack;
import dropout.DynamicArrayDropoutStack;
import structures.DropoutStackInterface;

/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when we grade your assignment.
 * 
 * @author jddevaug
 * 
 */
public class Configuration {
	
	/**
	 * Returns a new instance of the {@link BlurbInterface} that you want to be
	 * graded.
	 */
	public static BlurbInterface getBlurbInterface(){
		return new WuBlurbInterface();
	}
	
	/**
	 * Returns a new instance of the {@link CapitalGainsInterface} that you want to be
	 * graded.
	 */
	public static CapitalGainsInterface getCapitalGainsInterface(){
		return new WuCapitalGainsInterface();
	}
	
	/**
	 * Returns a new instance of the {@link DropoutStackInterface} that you want to be
	 * graded.
	 */
	public static DropoutStackInterface getDropoutStackInterface() { 
		return new ArrayDropoutStack(); 
	}
	
	public static DynamicArrayDropoutStack getDynamicDropoutStackInterface() { 
		return new DynamicArrayDropoutStack(); 
	}

}
