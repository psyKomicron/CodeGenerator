/**
 * 
 */
package julie.alphaNumGen;

import java.io.IOException;
import java.util.ArrayList;

import julie.alphabet.Alphabet;
import julie.codeGenerator.IGenerator;
import julie.codeGenerator.generators.CodeGenerator;

/**
 * @author julie
 *
 */
public class AlphaNumGenerator extends CodeGenerator implements IGenerator {
	private Alphabet alphabet = new Alphabet();
	
	private final static int codeLength = 10;

	public AlphaNumGenerator() {
		super();
		Rndm.setAlphabetSize(32);
		Rndm.setRandomInterval(10);
	}

	@Override
	public void generate() {
		String code = "";
		Math.random();
		Rndm.generateRndmNum();
		while (code.length() < codeLength) {
			if (isNumber()) {
				code += Rndm.generateRndmNum();
			} else {
				code += alphabet.getAlphabet().get(Rndm.generateRndmChar());
			}
		}
		setCode(code);
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
	public void shake() {
		ArrayList<Character> _arrayOfChar = new ArrayList<>();
		for (@SuppressWarnings("unused") Character _c : alphabet.getAlphabet()) {
			char _rndmChar = alphabet.getAlphabet().get(Rndm.generateRndmChar());
			while (_arrayOfChar.contains(_rndmChar)) {
				_rndmChar = alphabet.getAlphabet().get(Rndm.generateRndmChar());
			}
		}
		alphabet = new Alphabet(_arrayOfChar);
	}

	@Override
	public void setCodeLength(int length) {	}
	
	@Override
	public void writeCode(String _code, String _fileName) throws IOException {
	}

}
