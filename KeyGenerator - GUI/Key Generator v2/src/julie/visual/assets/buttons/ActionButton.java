/**
 * 
 */
package julie.visual.assets.buttons;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * @author julie
 *
 */
public abstract class ActionButton extends JButton implements MouseListener, IMenuButton {
	private static final long serialVersionUID = 1L;
	
	private Font focFont = new Font("Verdana", Font.BOLD, 20);
	private Font nfocFont = new Font("Verdana", Font.BOLD, 18);
	
	private boolean dynamic = true;
	
	
	public ActionButton(String _text) {
		super();
		addMouseListener(this);
		setText(_text);
		setFocFont(false);
	}

	@Override
	public void mousePressed(MouseEvent e) { 
		setFocFont(true);
	}

	@Override
	public void mouseReleased(MouseEvent e) { 
		setFocFont(false);
	}
	
	public void isDynamic(boolean is) {
		dynamic = is;
	}

	private void setFocFont(boolean foc) {
		if (dynamic) {
			if (foc) {
				setFont(focFont);
			} else {
				setFont(nfocFont);
			} 
		}
	}
	
	/**
	 * Unused methods
	 */
	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {	}
}
