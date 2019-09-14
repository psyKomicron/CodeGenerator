package julie.codeGenerator;

import java.io.IOException;

public interface IGenerator {

	String getCode();
	
	void shake();
	
	void generate();
	
	void writeCode(String code, String fileName) throws IOException;
	
	void setCodeLength(int length);
}
