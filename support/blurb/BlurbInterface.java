package blurb;
public interface BlurbInterface {
	
	
	/**
	 * In the language of an alien race, all words take the form of Blurbs.
	 * A Blurb is a Whoozit followed by one or more Whatzits. 
	 * A Whoozit is the character ‘x’ followed by zero or more ‘y’s. 
	 * A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’, followed by a Whoozit. 
	 * This method should be recursive
	 * @return a valid Blurb
	 */
	public String generateBlurb();
	
	/**
	 * Determines if {@code blurb} is a valid blurb as defined by {@code BlurbGenerator}
	 * This method should be recursive 
	 * @param blurb
	 * 				the String to be tested
	 * @return {@code true} if this {@code blurb} is a valid blurb and
	 *         {@code false} otherwise.
	 */
	public boolean isBlurb(String blurb);
	

}
