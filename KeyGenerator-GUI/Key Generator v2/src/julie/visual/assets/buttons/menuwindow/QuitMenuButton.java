/**
 * 
 */
package julie.visual.assets.buttons.menuwindow;

import java.awt.Dimension;

/**
 * @author julie
 *
 */
public class QuitMenuButton extends MenuWindowButton {

	private static final long serialVersionUID = 1L;

	/**
	 * @param _text
	 */
	public QuitMenuButton(String _text, Dimension d) {
		super(_text);
		setSize(d);
		isDynamic(false);
	}

}
