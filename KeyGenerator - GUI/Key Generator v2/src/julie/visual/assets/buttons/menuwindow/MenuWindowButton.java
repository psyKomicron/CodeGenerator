/**
 * 
 */
package julie.visual.assets.buttons.menuwindow;

import julie.visual.assets.buttons.WindowButton;

/**
 * @author julie
 *
 */
public abstract class MenuWindowButton extends WindowButton {
	
	private boolean pressed;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuWindowButton(String _text) {
		super(_text);
	}
	
	public boolean checkToDispose() {
		return false;
	}
	
	public boolean isPressed() {
		return pressed;
	}

	public void setPressed() {
		pressed = true;
	}
	
}
