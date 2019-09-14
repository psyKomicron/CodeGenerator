/**
 * 
 */
package julie.codeGenerator.generators;

/**
 * @author julie
 *
 */
public abstract class CodeGenerator {
	private String code;
	
	public CodeGenerator() {
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
