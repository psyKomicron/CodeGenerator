/**
 * 
 */
package julie.visual.assets.buttons.generatewindow;

import java.awt.Dimension;

import julie.visual.assets.buttons.ActionButton;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class GenerateWindowButton extends ActionButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenerateWindowButton(String text) {
		super(text);
		setPreferredSize(new Dimension(200, 50));
	}

	@Override
	public boolean checkToDispose(MenuWindow mw) {
		return false;
	}
}
