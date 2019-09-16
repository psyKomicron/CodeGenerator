/**
 * 
 */
package julie.visual.windows;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;

import julie.codeGenerator.IGenerator;
import julie.visual.assets.panes.CodesTextArea;



/**
 * @author julie
 *
 */
public class CodeWindow extends JDialog implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private JButton closeButton = new JButton("CLOSE");
	
	private GenerateWindow parent;

	private int repetitionNumber = 10;
	
	
	public CodeWindow(int pos, GenerateWindow _gw) {
		super(_gw);
		parent = _gw;
		setup(pos, _gw);
		closeButton.addActionListener(new ClButtListener());	
	}
	
	public void launchCalculation() {
		displayCodes();
		setVisible(true);
	}
	
	public void setRepetitionNumber(int number) {
		if (number >= 1 & number <= 150000) {
			repetitionNumber = number;
		}
	}
	
	@Override
	public void run() {
		System.out.println("second window running");
	}
	
	/**
	 * asks for this JDialog's parent for this JDialog to be removed
	 */
	public void informParentToRemove() {
		parent.removeCodeWindow(this);
	}
	
	/**
	 * Used only by the constructor. Setup all needed parameters.
	 * @param pos (int) number representing the position of the CodeWindow  
	 * @param _gw Parent GenerateWindow. The window (this) is not directly 
	 * 		  fitted into the GenerateWindow but rather uses the position 
	 * 		  of it to calculate it's own
	 */
	private void setup(int pos, GenerateWindow _gw) {
		setSize(new Dimension(200, 300));
		setResizable(false);
		setLocation(move(pos, _gw.getLocation()));
		setLayout(new BorderLayout());
		setUndecorated(true);
	}
	
	private void displayCodes() {
		ArrayList<String> codes = createCodes();
		CodesTextArea textArea = new CodesTextArea();
		add(closeButton, BorderLayout.SOUTH);
		textArea.addText(codes);
		add(textArea, BorderLayout.CENTER);
	}
	
	/**
	 * Uses the KeyGenerator.jar to create codes
	 * @return
	 */
	private ArrayList<String> createCodes() {
		ArrayList<String> codes = new ArrayList<>();
		IGenerator generator = parent.getGenerator();
		for (int i = 0; i < repetitionNumber ; i++) {
			generator.generate();
			codes.add(generator.getCode());
		}
		return codes;
	}
	
	/**
	 * Calculate the new position of the JDialog 
	 * @param offset
	 * @param location position of the parent's window
	 * @return the new position for this window
	 */
	private Point move(int offset, Point location) {
		Point point = new Point();
		Rectangle rect = getParent().getBounds();
		int x = (int)rect.getCenterX();
		int y = (int)rect.getCenterY() + 197;
		x -= (getWidth()/2)-(offset*10);
		y -= (getHeight()/2)-(offset*10);
		point.move(x, y);
		return point;
	}
	

/************************************************************
 * 
 * nested classes
 *
 ************************************************************/
	private class ClButtListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			informParentToRemove();
			dispose();
		}
		
	}
	
}
