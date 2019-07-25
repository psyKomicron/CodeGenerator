/**
 * 
 */
package julie.alphaNumGen;

import java.io.IOException;
import java.util.ArrayList;

import julie.alphabet.Alphabet;
import julie.codeGenerator.CodeGenerator;

/**
 * @author julie
 *
 */
public class AlphaNumGenerator extends CodeGenerator {

	public AlphaNumGenerator(Alphabet _alphabet) {
		super(_alphabet);
		Rndm.setAlphabetSize(32);
		Rndm.setRandomInterval(10);
	}

	@Override
	public void generate() {
		code = "";
		Alphabet _alphabet = getAlphabet();
		Math.random();
		Rndm.generateRndmNum();
		while (code.length() < 11) {
			if (isNumber()) {
				code += Rndm.generateRndmNum();
			} else {
				code += _alphabet.getAlphabet().get(Rndm.generateRndmChar());
			}
		}
	}
	
	private boolean isNumber() {
		Math.random();
		double random = Math.random();
		if (random*100. > 50) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void writeCode(String _code, String _fileName) throws IOException {
	}

	@Override
	public void shake() {
		ArrayList<Character> _arrayOfChar = new ArrayList<>();
		Alphabet _a = getAlphabet();
		for (@SuppressWarnings("unused") Character _c : _a.getAlphabet()) {
			char _rndmChar = _a.getAlphabet().get(Rndm.generateRndmChar());
			while (_arrayOfChar.contains(_rndmChar)) {
				_rndmChar = _a.getAlphabet().get(Rndm.generateRndmChar());
			}
		}
		setAlphabet(new Alphabet(_arrayOfChar));
	}

}
