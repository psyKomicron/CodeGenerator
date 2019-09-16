package julie.visual.assets.buttons.listeners.classes;

import java.awt.event.ActionEvent;

import julie.visual.assets.buttons.listeners.ActionButtonListener;
import julie.visual.windows.menuwindow.MenuWindow;

/**
 * @author julie
 *
 */
public class NumButtonListener extends ActionButtonListener {

	public NumButtonListener(MenuWindow generateWindow) {
		super(generateWindow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getParentWindow().getGenerateWindow().setCodeGeneratorMode("Numerical");
		getParentWindow().setup();
		askToDispose(e);
	}

}
