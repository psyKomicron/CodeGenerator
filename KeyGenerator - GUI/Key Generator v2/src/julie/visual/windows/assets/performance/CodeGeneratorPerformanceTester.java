/**
 * 
 */
package julie.visual.windows.assets.performance;

import julie.alphaNumGen.AlphaNumGenerator;
import julie.codeGenerator.IGenerator;

/**
 * @author julie
 *
 */
public class CodeGeneratorPerformanceTester {
	
	private IGenerator generator;

	public CodeGeneratorPerformanceTester(IGenerator generator) {
		this.generator = generator;
	}
	
	/**
	 * 
	 * @param seconds Delay before stopping code generation (in seconds)
	 * @return [0] : generation, [1] time
	 */
	public long[] getGenerationTimePerformance(long seconds) {
		generator = new AlphaNumGenerator();
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		long n = 0;
		while (endTime - startTime < seconds) {
			generator.generate();
			endTime = System.nanoTime();
			n++;
		}
		long[] result = new long[2];
		result[0] = n;
		result[1] = endTime - startTime;
		return result;
	}
}
