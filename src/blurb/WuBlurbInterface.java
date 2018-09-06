package blurb;

import blurb.BlurbInterface;
import java.util.Random;

public class WuBlurbInterface implements BlurbInterface {
	
	public static int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	@Override
	public String generateBlurb() {
		/** A Blurb is a Whoozit followed by one or more Whatzits. **/ 
		String blurb = createWhoozit();
		blurbHelper(blurb);
		return blurb;
	}
	
	private String blurbHelper(String result) {
		int random = randInt(1,50); 
		if (random > 3) { 
			return blurbHelper(result + createWhatzit());
		} 
		return result; 
	}
	
	public String createWhoozit() {
		/** A Whoozit is the character ‘x’ followed by zero or more ‘y’s. **/ 
		int random = randInt(0,100); 
		String whoozit = "x"; 
		while (random >= 0) { 
			random -= 1; 
			whoozit += "y";
		}
		return whoozit;
	}
	
	public String createWhatzit() {
		/** A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’, followed by a Whoozit. **/ 
		int random = randInt(0,1);
		String whatzit = "q";
		if (random == 0) { 
			whatzit += "z";
		} else { 
			whatzit += "d"; 
		}
		whatzit += createWhoozit();
		return whatzit;
	}
	
	@Override
	public boolean isBlurb(String blurb) { 
		/** A Blurb is a Whoozit followed by one or more Whatzits. **/ 
		String test = blurb;
		test = removeWhoozit(test);
		while (!test.equals("")) { 
			if (test.substring(0,1).equals("f")) {
				return false;
			}
			test = removeWhatzit(test);
		}
		return true;
	}
	
	public String removeWhoozit(String whoozit) {
		/** A Whoozit is the character ‘x’ followed by zero or more ‘y’s. **/ 
		if (whoozit.equals("")) { 
			return "f";
		}
		if (whoozit.substring(0,1).equals("x")) { 
			whoozit = whoozit.substring(1);
			if (whoozit.equals("")) { 
				return whoozit;
			}
			while (whoozit.substring(0,1).equals("y")) {
				whoozit = whoozit.substring(1);
				if (whoozit.equals("")) { 
					return whoozit;
				}
			}
			return whoozit;
		}
		return "f";
	}
	
	public String removeWhatzit(String whatzit) {
		/** A Whatzit is a ‘q’ followed by either a ‘z’ or a ‘d’, followed by a Whoozit. **/
		if (whatzit.length() < 2) { 
			return "f";
		}
		if (whatzit.substring(0,2).equals("qz") || whatzit.substring(0,2).equals("qd")) { 
			whatzit = whatzit.substring(2);
			if (whatzit.equals("")) { 
				return "f";
			}
			whatzit = removeWhoozit(whatzit);
			return whatzit;
		}
		return "f";
	}
}
