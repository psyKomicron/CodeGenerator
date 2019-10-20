/**
 * 
 */
package julie.visual.assets.fileloader;

import java.io.File;

/**
 * @author MonsieurJ
 *
 */
public interface IFileLoader {

	void load(File f);
	
	void save(File f);
	
	void append(File f);
	
}
