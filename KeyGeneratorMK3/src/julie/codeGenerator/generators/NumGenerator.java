/**
 * 
 */
package julie.codeGenerator.generators;

import java.io.IOException;

import julie.codeGenerator.IGenerator;

/**
 * @author julie
 *
 */
public class NumGenerator extends CodeGenerator implements IGenerator {
	
	private final static int codeLength = 8;

	public NumGenerator() {
		super();
		Rndm.setRandomInterval(10);
	}

	@Override
	public void shake() { }

	@Override
	public void generate() {
		String code = "";
		Math.random();
		Rndm.generateRndmNum();
		while (code.length() < codeLength) {
			code += Rndm.generateRndmNum();
		}
		setCode(code);
	}

	@Override
	public void writeCode(String code, String fileName) throws IOException { }

	@Override
	public void setCodeLength(int length) { }

	
}
