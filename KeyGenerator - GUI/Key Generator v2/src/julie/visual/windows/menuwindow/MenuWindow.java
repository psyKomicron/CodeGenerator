/**
 * 
 */
package julie.visual.windows.menuwindow;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import julie.visual.windows.AppWindow;
import julie.visual.windows.GenerateWindow;

/**
 * @author julie
 *
 */
public class MenuWindow extends AppWindow {

	private static final long serialVersionUID = 1L;
	
	private final ModeButton numButton = new ModeButton("Numerical");
	private final ModeButton alphButton = new ModeButton("Alphanumerical");
	
	private GenerateWindow generateWindow = null;
	
	
	public MenuWindow(String name, GenerateWindow generateWindow) {
		super(name);
		this.generateWindow = generateWindow;
		setSize(new Dimension(500, 300));
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		centerOnScreen(getBounds());
		setLayout(new GridBagLayout());
		numButton.addActionListener(new NumButtonListener());
		alphButton.addActionListener(new AlphButtonListener());
		numButton.setEnabled(true);
		alphButton.setEnabled(false);
		add(numButton);
		add(alphButton);
		setup();
	}
	
	private void setup() {
		if (generateWindow.getGeneratorType().equalsIgnoreCase("numerical")) {
			numButton.setEnabled(false);
			alphButton.setEnabled(true);
		}
		else if (generateWindow.getGeneratorType().equalsIgnoreCase("alphanumerical")) {
			numButton.setEnabled(true);
			alphButton.setEnabled(false);
		}
		else {
			numButton.setEnabled(true);
			alphButton.setEnabled(true);
		}
		setVisible(true);
	}
	
	public void changeGeneratorMode(String mode) {
		System.out.println(mode);
		generateWindow.setCodeGeneratorMode(mode);
	}
	
	
/************************************************************
 * 
 * nested classes
 *
 ************************************************************/		
	
	class NumButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateWindow.setCodeGeneratorMode("Numerical");
			dispose();
		}
	}
	
	class AlphButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			generateWindow.setCodeGeneratorMode("Alphanumerical");
			dispose();
		}
		
	}
}
