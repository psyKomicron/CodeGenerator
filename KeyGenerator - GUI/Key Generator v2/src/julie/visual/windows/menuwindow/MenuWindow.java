/**
 * 
 */
package julie.visual.windows.menuwindow;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import julie.visual.assets.buttons.ModeButton;
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
		// window parameters
		setTitle("Parameters menu");
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// buttons
		numButton.addActionListener(new NumButtonListener());
		alphButton.addActionListener(new AlphButtonListener());
		addComponents();
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
		pack();
		centerOnScreen(getBounds());
		setVisible(true);
	}
	
	private void addComponents() {
		//
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(numButton, gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(alphButton, gbc);
		//
	}
	
	public void changeGeneratorMode(String mode) {
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
