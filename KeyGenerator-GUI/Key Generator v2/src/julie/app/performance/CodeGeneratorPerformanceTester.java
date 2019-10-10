/**
 * 
 */
package julie.app.performance;

import java.util.ArrayList;

import julie.codeGenerator.IGenerator;

/**
 * @author julie
 *
 */
public class CodeGeneratorPerformanceTester implements Runnable {
	
	private IGenerator generator;
	
	private boolean withArray = false;
	
	private long[] result = new long[2];
	
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
	
	public int getCodeLength() {
		return generator.getCodeLength();
	}
	
	public void setCodeLength(int n) {
		generator.setCodeLength(n);
	}

	@Override
	public void run() {
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		long n = 0;
		if (!withArray) {
			while (endTime - startTime < seconds) {
				generator.generate();
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
		result[0] = n;
		result[1] = endTime - startTime;
	}
	
}
