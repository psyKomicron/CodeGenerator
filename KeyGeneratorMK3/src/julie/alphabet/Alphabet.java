/**
 * 
 */
package julie.alphabet;

import java.util.ArrayList;

/**
 * @author julie
 *
 */
public class Alphabet {
	private final ArrayList<Character> alphabet;
	
	public Alphabet() {
		alphabet = new ArrayList<>();
		for (int i=Ascii.getCapStart(); i<Ascii.getCapEnd(); i++) {
			alphabet.add((char)i);
		}
		for (int j=Ascii.getLowStart(); j<Ascii.getLowEnd(); j++) {
			alphabet.add((char)j);
		}
	}
	
	public Alphabet(ArrayList<Character> _array) {
		alphabet = _array;
	}
	
	public ArrayList<Character> getAlphabet() {
		return alphabet;
	}
	
	@Override
	public String toString() {
		String _str = "";
		for (Character _c : alphabet) {
			_str += _c;
		}
		return _str;
	}

	
	private static class Ascii {
		private static int getCapStart() {
			return 65;
		}
		private static int getCapEnd() {
			return 91;
		}
		private static int getLowStart() {
			return 97;
		}
		private static int getLowEnd() {
			return 123;
		}
	}
	
}
