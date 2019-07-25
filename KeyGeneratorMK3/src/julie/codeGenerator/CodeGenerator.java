/**
 * 
 */
package julie.codeGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import julie.alphabet.Alphabet;

/**
 * @author julie
 *
 */
public abstract class CodeGenerator {
	protected String code;
	private Alphabet alphabet;
	
	public CodeGenerator(Alphabet _alphabet) {
		alphabet = _alphabet;
		code = "";
	}
	
	public String getCode() {
		return code;
	}
	
	protected void setCode(String _code) {
		if (_code != null) {
			code = _code;
		}
	}
	
	public Alphabet getAlphabet() {
		return alphabet;
	}
	
	protected void setAlphabet(Alphabet _alphabet) {
		alphabet = _alphabet;
	}
		
	public void writeCode() throws IOException {
		BufferedWriter w = new BufferedWriter(new FileWriter("./key.txt"));
		w.write(code);
		w.close();
	}
	
	public abstract void shake();
	
	public abstract void generate();
	
	public abstract void writeCode(String _code, String _fileName) throws IOException;
	
	public static class Rndm {
		private static double interval;
		private static double alphSize;

		public static int generateRndmNum() {
			Math.random();
			return (int)(Math.random()*interval);
		}
		
		public static int generateRndmChar() {
			Math.random();
			return (int)(Math.random()*alphSize);
		}
		
		public static void setRandomInterval(int _n) {
			interval = (double)_n;
		}
		
		public static void setAlphabetSize(int _n) {
			alphSize = (double)_n;
		}
	}
}
