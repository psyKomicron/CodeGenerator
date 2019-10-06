package julie.visual.assets.buttons.listeners.classes;

import java.awt.event.ActionEvent;

import julie.visual.assets.buttons.listeners.WindowButtonListener;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class AlphButtonListener extends WindowButtonListener {

	public AlphButtonListener(MenuWindow menuWindow) {
		super(menuWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getParentWindow().getGenerateWindow().setCodeGeneratorMode("Alphanumerical");
		getParentWindow().setup();
		askToDispose(e);
	}
	
}
