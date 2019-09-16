/**
 * 
 */
package julie.visual.assets.buttons.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public abstract class ActionButtonListener implements ActionListener {

	private MenuWindow parentWindow = null;
	
	public ActionButtonListener(MenuWindow parentWindow) {
		super();
		this.parentWindow = parentWindow;
	}
	
	public MenuWindow getParentWindow() {
		return parentWindow;
	}
	
	protected void askToDispose(ActionEvent arg) {
		parentWindow.canDispose();
	}
}
