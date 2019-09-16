/**
 * 
 */
package julie.visual.assets.buttons.menuwindow;

import java.awt.Dimension;

import julie.visual.assets.buttons.ActionButton;
import julie.visual.assets.buttons.IMenuButton;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class QuitMenuButton extends ActionButton implements IMenuButton {

	private static final long serialVersionUID = 1L;

	/**
	 * @param _text
	 */
	public QuitMenuButton(String _text, Dimension d) {
		super(_text);
		setSize(d);
		isDynamic(false);
	}

	@Override
	public boolean checkToDispose(MenuWindow mw) {
		return true;
	}

}
