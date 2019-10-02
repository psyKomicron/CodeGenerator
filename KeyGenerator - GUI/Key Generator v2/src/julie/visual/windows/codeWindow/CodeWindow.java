/**
 * 
 */
package julie.visual.windows.codeWindow;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import julie.codeGenerator.IGenerator;
import julie.visual.assets.panes.CodesTextArea;
import julie.visual.windows.gui.generatewindow.GenerateWindow;



/**
 * @author julie
 *
 */
public class CodeWindow extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private JButton closeButton = new JButton("CLOSE");
	
	private GenerateWindow parent;
	
	private CodesTextArea textArea = new CodesTextArea();

	private int repetitionNumber = 10;
	
	
	public CodeWindow(int pos, GenerateWindow gw) {
		super();
		parent = gw;
		setup(pos, gw);
		closeButton.addActionListener(new ClButtListener());	
	}
	
	/**
	 * Used only by the constructor. Setup all needed parameters.
	 * @param pos (int) number representing the position of the CodeWindow  
	 * @param gw Parent GenerateWindow. The window (this) is not directly 
	 * 		  fitted into the GenerateWindow but rather uses the position 
	 * 		  of it to calculate it's own
	 */
	private void setup(int pos, GenerateWindow gw) {
		setSize(new Dimension(500, 300));
		setLocation(move(pos, gw.getLocation()));
		setLayout(new BorderLayout());
	}
	
	public void launchCalculation() {
		addComponents();
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
	
	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		JPanel pane = new JPanel();
		//scrollablePane.setLayout(new BorderLayout());
		setContentPane(pane);
		pane.setLayout(layout);
//		text area to display generated codes
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx =0;
		gbc.gridy =0;
		gbc.anchor = GridBagConstraints.NORTH;
		JScrollPane scrollablePane = new JScrollPane(textArea);
		pane.add(scrollablePane, gbc);
//		quit button
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx =0;
		gbc.gridy =1;
		gbc.anchor = GridBagConstraints.SOUTH;
		pane.add(closeButton, gbc);
//		label to lead user
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		String text = 
				"<html><p>Scroll UP to show all codes</p><p>Click on close to close this window</p></html>";
		pane.add(new JLabel(text), gbc);
	}
	
	private void displayCodes() {
		ArrayList<String> codes = createCodes();
		textArea.addText(codes);
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
		Rectangle rect = parent.getBounds();
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
