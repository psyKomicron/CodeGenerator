/**
 * 
 */
package julie.visual.assets.buttons.listeners.classes;

import java.awt.event.ActionEvent;

import julie.visual.assets.buttons.listeners.ActionButtonListener;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class ConfirmButtonListener extends ActionButtonListener {

	public ConfirmButtonListener(MenuWindow generateWindow) {
		super(generateWindow);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = getParentWindow().getTextField().getText();
		getParentWindow().getGenerateWindow().setCodeGenerationNumber(Integer.parseInt(text));
		askToDispose(arg0);
	}
	
}
