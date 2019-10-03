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

	private ArrayList<String> codeArray = new ArrayList<>();
	
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

	public void addText(ArrayList<String> codes) {
		for (int i = 0; i < codes.size(); i++) {
			if (i == codes.size() - 1) {
				append(codes.get(i));
				codeArray.add(codes.get(i));
			}
			else {
				append(codes.get(i)+newLine);
				codeArray.add(codes.get(i)+newLine);
			}
		}
	}
	
	public String getTextAreaContent() {
		String content = "";
		for (String s : codeArray) {
			content += s;
		}
		return content;
	}
	
}
