/**
 * 
 */
package julie.visual.assets.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * @author julie
 *
 */
public class ActionButton extends JButton implements MouseListener {
	private static final long serialVersionUID = 1L;
	private Font focFont = new Font("Verdana", Font.BOLD, 20);
	private Font nfocFont = new Font("Verdana", Font.BOLD, 18);
	
	public ActionButton(String _text) {
		super();
		addMouseListener(this);
		setText(_text);
		setPreferredSize(new Dimension(200, 50));
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

	private void setFocFont(boolean foc) {
		if (foc) {
			setFont(focFont);
		}
		else {
			setFont(nfocFont);
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
