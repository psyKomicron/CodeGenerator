/**
 * 
 */
package julie.visual.windows.assets;

import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * @author julie
 *
 */
public class AppWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;

	
	public AppWindow(String _name) {
		super(_name);
	}
	
	/**
	 *  ? find a way to know the size of any screen
	 * @param r
	 * @return int
	 */
	private int getCenterX(Rectangle r) {
		return 960-r.width/2;
	}
	
	/**
	 * ? find a way to know the size of any screen
	 * @param r
	 * @return int
	 */
	private int getCenterY(Rectangle r) {
		return 450-r.height/2;
	}
	
	/**
	 * ? find a way to know the size of any screen
	 * @param frameSize size
	 */
	public void centerOnScreen(Rectangle frameSize) {
		int x = getCenterX(frameSize);
		int y = getCenterY(frameSize);
		setLocation(x, y);
		revalidate();
	}
}
