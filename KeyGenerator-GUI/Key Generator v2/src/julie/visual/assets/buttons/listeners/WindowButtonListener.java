/**
 * 
 */
package julie.visual.assets.buttons.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import julie.visual.assets.buttons.menuwindow.MenuWindowButton;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public abstract class WindowButtonListener implements ActionListener {

	private MenuWindow parentWindow = null;
	
	public WindowButtonListener(MenuWindow menuWindow) {
		super();
		this.parentWindow = menuWindow;
	}
	
	public MenuWindow getParentWindow() {
		return parentWindow;
	}
	
	protected void askToDispose(ActionEvent arg) {
		MenuWindowButton button = (MenuWindowButton) arg.getSource();
		button.setPressed();
		parentWindow.canDispose();
	}
}
