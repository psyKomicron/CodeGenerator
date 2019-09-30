/**
 * 
 */
package julie.visual.assets.buttons.listeners.classes;

import java.awt.event.ActionEvent;

import julie.visual.assets.buttons.listeners.WindowButtonListener;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class ConfirmButtonListener extends WindowButtonListener {

	public ConfirmButtonListener(MenuWindow menuWindow) {
		super(menuWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = getParentWindow().getTextField().getText();
		if (!"".equals(text)) {
			getParentWindow().getGenerateWindow().setCodeGenerationNumber(Integer.parseInt(text));
			askToDispose(e);
		}
	}
	
}
