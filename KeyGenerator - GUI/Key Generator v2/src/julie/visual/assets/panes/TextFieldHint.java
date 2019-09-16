package julie.visual.assets.panes;

import java.awt.Font;

import javax.swing.JLabel;

public class TextFieldHint extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TextFieldHint(String text) {
		super(text);
		setFont(new Font("Verdana",Font.PLAIN, 14));
	}
}
