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
public class ConfirmButton extends ActionButton implements IMenuButton {

	private boolean pressed = false; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param text
	 */
	public ConfirmButton(String text) {
		super(text);
	}

	@Override
	public boolean checkToDispose(MenuWindow mw) {
		if (pressed) {
			return true;
		} else return false;
	}

	public void setPressed(boolean b) {
		pressed = b;
	}
	
	public boolean isPressed() {
		return pressed;
	}
}
