/**
 * 
 */
package julie.app.performance;

import java.util.ArrayList;

import julie.alphaNumGen.AlphaNumGenerator;
import julie.codeGenerator.IGenerator;

/**
 * @author julie
 *
 */
public class CodeGeneratorPerformanceTester implements Runnable {
	
	private IGenerator generator;
	
	private boolean withArray = false;
	
	private long[] result;
	
	private long seconds;

	public CodeGeneratorPerformanceTester(IGenerator generator) {
		this.generator = generator;
	}
	
	public CodeGeneratorPerformanceTester(IGenerator generator, long seconds) {
		this.generator = generator;
		this.seconds = seconds;
	}
	
	/**
	 * 
	 * @param seconds Delay before stopping code generation (in seconds)
	 * @return [0] : generation, [1] time
	 */
	public long[] getGenerationTimePerformance() {
		return result;
	}
	
	public void setDelay(long seconds) {
		this.seconds = seconds;
	}
	
	public void withArray(boolean b) {
		withArray = b;
	}
	
	public boolean isUsingArray() {
		return withArray;
	}

	@Override
	public void run() {
		generator = new AlphaNumGenerator();
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		long n = 0;
		if (!withArray) {
			while (endTime - startTime < seconds) {
				generator.generate();
//				generator.getCode();
				endTime = System.nanoTime();
				n++;
			}
		}
		else {
			ArrayList<String> array = new ArrayList<>();
			while (endTime - startTime < seconds) {
				generator.generate();
				array.add(generator.getCode());
				endTime = System.nanoTime();
				n++;
			}
		}
		long[] result = new long[3];
		result[0] = n;
		result[1] = endTime - startTime;
	}
	
}
