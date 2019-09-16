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
public class QuitButtonListener extends ActionButtonListener {

	public QuitButtonListener(MenuWindow parent) {
		super(parent);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		getParentWindow().getGenerateWindow().setCodeGeneratorMode("");
		getParentWindow().getGenerateWindow().setCodeGenerationNumber(10);
		this.askToDispose(arg0);
	}
	
}
