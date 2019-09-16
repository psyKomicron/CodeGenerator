/**
 * 
 */
package julie.visual.assets.panes;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;

/**
 * @author julie
 *
 */
public class CodesTextArea extends JTextArea {
	
	private static final long serialVersionUID = 1L;
	
	private final static String newLine = "\n";

	
	public CodesTextArea() {
		super();
		setup();
		revalidate();
	}
	
	private final void setup() {
		setFont(new Font("Verdana", Font.BOLD, 17));
		setOpaque(true);
		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);
		setColumns(11);
		setTabSize(10);
		setRows(10);
		setLineWrap(true);
		setWrapStyleWord(true);
		setEditable(false);
	}

	public void addText(ArrayList<String> _codes) {
		for (int i = 0; i < _codes.size(); i++) {
			if (i == _codes.size() - 1) {
				append(_codes.get(i));
			}
			else {
				append(_codes.get(i)+newLine);
			}
		}
	}
	
}
