/**
 * 
 */
package julie.visual.assets.buttons.menuwindow;

import julie.visual.assets.buttons.ActionButton;
import julie.visual.assets.buttons.IMenuButton;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class NumButton extends ActionButton implements IMenuButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param _text
	 */
	public NumButton(String _text) {
		super(_text);
	}

	@Override
	public boolean checkToDispose(MenuWindow mw) {
		if (isEnabled() & !(mw.getAlphButton().isEnabled()) | !isEnabled() & mw.getAlphButton().isEnabled()) {
			return true;
		} else return false;
	}

}
