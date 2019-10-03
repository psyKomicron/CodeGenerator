/**
 * 
 */
package julie.app;

import julie.visual.windows.generatewindow.GenerateWindow;
import julie.visual.windows.performanceWindow.PerformanceWindow;

/**
 * @author julie
 *
 */
public class KeyGenerator_v2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// algo
		// interface
		GenerateWindow _gw = new GenerateWindow();
		PerformanceWindow pw = new PerformanceWindow("Performance Window");
		_gw.run();
		pw.run();
	}

}
