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
public class AlphNumButton extends ActionButton implements IMenuButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlphNumButton(String text) {
		super(text);
	}
	
	@Override
	public boolean checkToDispose(MenuWindow mw) {
		if (isEnabled() & !(mw.getNumButton().isEnabled()) | !isEnabled() & mw.getNumButton().isEnabled()) {
			return true;
		} else return false;
	}
	
}
