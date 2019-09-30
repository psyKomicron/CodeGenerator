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
public class QuitButtonListener extends WindowButtonListener {

	public QuitButtonListener(MenuWindow menuWindow) {
		super(menuWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getParentWindow().getGenerateWindow().setCodeGeneratorMode("");
		getParentWindow().getGenerateWindow().setCodeGenerationNumber(10);
		this.askToDispose(e);
	}
	
}
