/**
 * 
 */
package julie.visual.assets.buttons.generatewindow;

import java.awt.Dimension;

import julie.visual.assets.buttons.WindowButton;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class GenerateWindowButton extends WindowButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenerateWindowButton(String text) {
		super(text);
		setPreferredSize(new Dimension(200, 50));
	}
	
}
